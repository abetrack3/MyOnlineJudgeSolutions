import os
import re
import json
import shutil
import requests
from typing import Dict
from zipfile import ZipFile

from tqdm import tqdm
from selenium.common import SessionNotCreatedException

from Automations.utils.common_utils import get_platform, get_chrome_version
from Automations.utils.io_utils import copy_file
from Automations.utils.driver_utils import get_driver_binary_file_extension

CHROME_DRIVER_ZIP_FILENAME = 'driver.zip'
CHROME_DRIVER_BINARY_FILENAME = f'chromedriver.{get_driver_binary_file_extension()}'
CHROME_DRIVER_BACKUP_FILENAME = 'chromedriver.bak'
CHROME_DRIVER_ZIP_EXTRACTED_DIRECTORY_PATH = f'chromedriver-{get_platform()}'
CHROME_DRIVER_ZIP_EXTRACTED_BINARY_FILE_PATH = f'{CHROME_DRIVER_ZIP_EXTRACTED_DIRECTORY_PATH}/chromedriver.{get_driver_binary_file_extension()}'
CHROME_ALL_VERSION_LIST_URL = ('https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with'
                               '-downloads.json')
OLD_CHROMEDRIVER_ERROR_MESSAGE_PATTERN = r'''.*This version of ChromeDriver only supports Chrome version \d+
Current browser version is (\d+).*'''


class ChromeDriverUpdater:

    @staticmethod
    def update_driver(caught_exception: SessionNotCreatedException) -> None:
        error_message = caught_exception.msg
        if ChromeDriverUpdater.__old_chrome_driver_error__(error_message):
            target_chrome_driver_version = ChromeDriverUpdater.__get_target_chrome_driver_version(error_message)
            ChromeDriverUpdater.__download_latest_driver_for_version__(target_chrome_driver_version)

    @staticmethod
    def download_driver() -> None:
        chrome_version = '.'.join(get_chrome_version().split('.')[0:3])
        print(f'Chrome version: {chrome_version}')
        ChromeDriverUpdater.__download_latest_driver_for_version__(chrome_version)

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
    def __download_latest_driver_for_version__(target_version: str) -> None:
        ChromeDriverUpdater.__remove_temporary_files_if_exist()
        ChromeDriverUpdater.__create_backup_of_current_chrome_driver_binary()

        all_chrome_version_information = json.loads(requests.get(url=CHROME_ALL_VERSION_LIST_URL).text)

        available_target_versions = [
            each_chrome_version
            for each_chrome_version in all_chrome_version_information['versions']
            if each_chrome_version['version'].startswith(target_version)
        ]

        latest_available_target_version = available_target_versions[-1]

        chrome_driver_urls: Dict[str, str] = latest_available_target_version['downloads']['chromedriver']

        platform: str = get_platform()

        chrome_driver_zip_download_url: str = next(filter(lambda x: x['platform'] == platform,
                                                          chrome_driver_urls))['url']

        ChromeDriverUpdater.__download_chrome_driver_zip(chrome_driver_zip_download_url)

        ChromeDriverUpdater.__extract_driver_zip_file()

        copy_file(CHROME_DRIVER_ZIP_EXTRACTED_BINARY_FILE_PATH, CHROME_DRIVER_BINARY_FILENAME)

        ChromeDriverUpdater.__remove_temporary_files_if_exist()

    @staticmethod
    def __download_chrome_driver_zip(driver_url: str) -> None:

        try:

            response = requests.get(driver_url, stream=True)

            response.raise_for_status()

            file_size = int(response.headers.get('Content-Length', 0))

            progress_bar = tqdm(desc='Downloading Chrome Driver', total=file_size, unit='B', unit_scale=True)

            with open(CHROME_DRIVER_ZIP_FILENAME, 'wb') as driver_zip_file:

                for chunk in response.iter_content(chunk_size=1024):
                    driver_zip_file.write(chunk)

                    progress_bar.update(len(chunk))

            progress_bar.close()

        except requests.exceptions.RequestException as e:

            print(f'Download failed: {e}')

        except Exception as e:

            print(f'An error occurred: {e}')

    @staticmethod
    def __remove_temporary_files_if_exist():

        if os.path.exists(CHROME_DRIVER_ZIP_FILENAME):
            os.remove(CHROME_DRIVER_ZIP_FILENAME)

        if os.path.exists(CHROME_DRIVER_BACKUP_FILENAME):
            os.remove(CHROME_DRIVER_BACKUP_FILENAME)

        if os.path.exists(CHROME_DRIVER_ZIP_EXTRACTED_DIRECTORY_PATH):
            shutil.rmtree(CHROME_DRIVER_ZIP_EXTRACTED_DIRECTORY_PATH)

    @staticmethod
    def __create_backup_of_current_chrome_driver_binary():

        if not os.path.exists(CHROME_DRIVER_BINARY_FILENAME):
            print(f'{CHROME_DRIVER_BINARY_FILENAME} does not exist')
            return

        chrome_driver_binary = open(CHROME_DRIVER_BINARY_FILENAME, 'rb').read()
        with open(CHROME_DRIVER_BACKUP_FILENAME, 'wb') as backup_chrome_driver:
            backup_chrome_driver.write(chrome_driver_binary)
            backup_chrome_driver.flush()
            backup_chrome_driver.close()

    @staticmethod
    def __extract_driver_zip_file():

        with ZipFile(CHROME_DRIVER_ZIP_FILENAME) as driver_zip_file:
            driver_zip_file.extractall()
