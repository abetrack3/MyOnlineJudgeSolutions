import os
import re
from zipfile import ZipFile

import requests
from bs4 import BeautifulSoup
from selenium.common import SessionNotCreatedException


CHROME_DRIVER_ZIP_FILENAME = 'driver.zip'
CHROME_DRIVER_BINARY_FILENAME = '../chromedriver'
CHROME_DRIVER_BACKUP_FILENAME = 'chromedriver.bak'
CHROME_DRIVER_ZIP_DOWNLOAD_URL_TEMPLATE = 'https://chromedriver.storage.googleapis.com/{}/chromedriver_linux64.zip'
OLD_CHROMEDRIVER_ERROR_MESSAGE_PATTERN = r'''.*This version of ChromeDriver only supports Chrome version \d+
Current browser version is (\d+).*'''


class ChromeDriverUpdater:

    @staticmethod
    def update_driver(caught_exception: SessionNotCreatedException):
        error_message = caught_exception.msg
        if ChromeDriverUpdater.__old_chrome_driver_error__(error_message):
            target_chrome_driver_version = ChromeDriverUpdater.__get_target_chrome_driver_version(error_message)
            ChromeDriverUpdater.__update_chrome_driver__(target_chrome_driver_version)

    @staticmethod
    def __old_chrome_driver_error__(error_message: str) -> bool:
        regex_search_result = re.search(OLD_CHROMEDRIVER_ERROR_MESSAGE_PATTERN, error_message)
        return regex_search_result is not None

    @staticmethod
    def __get_target_chrome_driver_version(error_message: str) -> str:
        regex_search_result = re.search(OLD_CHROMEDRIVER_ERROR_MESSAGE_PATTERN, error_message)
        target_version = regex_search_result.groups()[0]
        return target_version

    @staticmethod
    def __update_chrome_driver__(target_version: str):

        ChromeDriverUpdater.__remove_temporary_files_if_exist()
        ChromeDriverUpdater.__create_backup_of_current_chrome_driver_binary()

        response_download_page = requests.request(method='GET', url='https://chromedriver.chromium.org/downloads')
        document = BeautifulSoup(response_download_page.text, features='lxml')
        anchor_tag_list = document.find_all(name='a', recursive=True)
        anchor_tag_list = [
            each_anchor_tag
            for each_anchor_tag in anchor_tag_list
            if each_anchor_tag.text.startswith(f'ChromeDriver {target_version}')
        ]
        full_version = anchor_tag_list[0].text.split()[-1]  # choosing the first result from search and filter
        chrome_driver_zip_download_url = CHROME_DRIVER_ZIP_DOWNLOAD_URL_TEMPLATE.format(full_version)
        chrome_driver_zip_download_response = requests.request(method='GET', url=chrome_driver_zip_download_url)
        with open(CHROME_DRIVER_ZIP_FILENAME, 'wb') as driver_zip_file:
            driver_zip_file.write(chrome_driver_zip_download_response.content)
            driver_zip_file.flush()
            driver_zip_file.close()

        ChromeDriverUpdater.__extract_driver_zip_file()
        ChromeDriverUpdater.__remove_temporary_files_if_exist()

    @staticmethod
    def __remove_temporary_files_if_exist():

        if os.path.exists(CHROME_DRIVER_ZIP_FILENAME):
            os.remove(CHROME_DRIVER_ZIP_FILENAME)

        if os.path.exists(CHROME_DRIVER_BACKUP_FILENAME):
            os.remove(CHROME_DRIVER_BACKUP_FILENAME)

    @staticmethod
    def __create_backup_of_current_chrome_driver_binary():

        chrome_driver_binary = open(CHROME_DRIVER_BINARY_FILENAME, 'rb').read()
        with open(CHROME_DRIVER_BACKUP_FILENAME, 'wb') as backup_chrome_driver:
            backup_chrome_driver.write(chrome_driver_binary)
            backup_chrome_driver.flush()
            backup_chrome_driver.close()

    @staticmethod
    def __extract_driver_zip_file():

        with ZipFile(CHROME_DRIVER_ZIP_FILENAME, 'r') as driver_zip_file:
            driver_zip_file.extractall()
