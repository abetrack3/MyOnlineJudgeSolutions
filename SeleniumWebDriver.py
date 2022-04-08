from selenium import webdriver
from selenium.webdriver.chrome.service import Service

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
        if headless:
            options = WebDriverFactory.__get_configurations__()
            chrome_driver = webdriver.Chrome(service=Service(path), options=options)
            return chrome_driver
        else:
            chrome_driver = webdriver.Chrome(service=Service(path))
            chrome_driver.maximize_window()
            return chrome_driver