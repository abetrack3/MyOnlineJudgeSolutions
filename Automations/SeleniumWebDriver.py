from selenium.common import SessionNotCreatedException, NoSuchDriverException
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.webdriver import WebDriver

from Automations.ChromeDriverUpdater import ChromeDriverUpdater

PAGE_LOAD_TIMEOUT = 120


class WebDriverFactory:
    @staticmethod
    def __get_configurations__(headless: bool = False) -> Options:
        options = Options()
        options.headless = headless
        options.add_argument("--start-maximized")
        options.add_argument('--disable-blink-features=AutomationControlled')
        options.add_argument('--no-first-run --no-service-autorun --password-store=basic')
        options.add_argument('--disable-popup-blocking')
        options.add_argument("--disable-web-security")
        options.add_argument("--disable-site-isolation-trials")

        if headless:
            options.add_argument("--mute-audio")

        if not headless:
            options.add_argument('--auto-open-devtools-for-tabs')

        return options

    @staticmethod
    def get_driver(path: str, headless: bool = False) -> WebDriver:
        options = WebDriverFactory.__get_configurations__(headless)
        chrome_driver = WebDriverFactory.__get_driver_instance(service=Service(path), options=options)
        chrome_driver.set_page_load_timeout(PAGE_LOAD_TIMEOUT)
        return chrome_driver

    @staticmethod
    def __get_driver_instance(service: Service, options: Options) -> WebDriver:
        try:
            chrome_driver = WebDriver(service=service, options=options)
            return chrome_driver
        except SessionNotCreatedException as caught_exception:
            ChromeDriverUpdater.update_driver(caught_exception)
            chrome_driver = WebDriver(service=service, options=options)
            return chrome_driver
        except NoSuchDriverException:
            ChromeDriverUpdater.download_driver()
            chrome_driver = WebDriver(service=service, options=options)
            return chrome_driver
