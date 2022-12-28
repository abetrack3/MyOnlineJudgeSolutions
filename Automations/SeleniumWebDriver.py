import re
from typing import Optional

from selenium import webdriver
from selenium.common import SessionNotCreatedException
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.webdriver import WebDriver

from ChromeDriverUpdater import ChromeDriverUpdater

PAGE_LOAD_TIMEOUT = 120


class WebDriverFactory:
    @staticmethod
    def __get_configurations__():
        user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (HTML, like Gecko) " \
                     "Chrome/85.0.4183.83 Safari/537.36 "
        options = webdriver.ChromeOptions()
        options.headless = True
        options.add_argument(f'user-agent={user_agent}')
        options.add_argument("--window-size=1920,1080")
        options.add_argument('--ignore-certificate-errors')
        options.add_argument('--allow-running-insecure-content')
        options.add_argument("--disable-extensions")
        options.add_argument("--proxy-server='direct://'")
        options.add_argument("--proxy-bypass-list=*")
        options.add_argument("--start-maximized")
        options.add_argument('--disable-gpu')
        options.add_argument('--disable-dev-shm-usage')
        options.add_argument('--no-sandbox')
        return options

    @staticmethod
    def get_driver(path: str, headless: bool = False):

        options: Options = WebDriverFactory.__get_configurations__() if headless else None
        chrome_driver: Optional[WebDriver] = WebDriverFactory.__get_driver_instance__(
            service=Service(path),
            options=options
        )

        if chrome_driver is None:
            raise Exception('Failed to load driver')

        if not headless:
            chrome_driver.maximize_window()

        chrome_driver.set_page_load_timeout(PAGE_LOAD_TIMEOUT)

        return chrome_driver

    @staticmethod
    def __get_driver_instance__(service: Service, options: Options) -> WebDriver:
        try:
            chrome_driver = webdriver.Chrome(service=service, options=options)
            return chrome_driver
        except SessionNotCreatedException as caught_exception:
            ChromeDriverUpdater.update_driver(caught_exception)
            chrome_driver = webdriver.Chrome(service=service, options=options)
            return chrome_driver
