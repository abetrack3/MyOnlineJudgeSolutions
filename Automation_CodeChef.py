import os
import re
import time

from typing import Tuple

from selenium.common.exceptions import TimeoutException
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

DELAY_TIMEOUT = 10


def code_chef(description: Tuple[str, str, str], driver: WebDriver):
    online_judge, problem_code, file_extension = description
    file_name = f'{online_judge}-{problem_code}.{file_extension}'
    link = f'https://codechef.com/problems/{problem_code}'

    # getting the problem title
    driver.get(link)
    try:
        element = WebDriverWait(driver, DELAY_TIMEOUT).until(
            EC.presence_of_element_located((By.XPATH, '//*/main/header//*/h1'))
        )
        problem_title: str = element.text
    except TimeoutException:
        print("Loading took too much time!")
        print(description)
        return
    problem_title = re.sub(re.compile(r'(\sProblem Code: [A-Za-z\d]+)?\n.*'), '', problem_title)

    # git add
    command_git_add = f'git add CodeChef/{file_name}'
    print(command_git_add)
    os.popen(command_git_add)
    time.sleep(1)

    # git commit
    git_message = f'{online_judge}-{problem_code}: {problem_title}'
    git_description = f'{git_message}\nLink to the problem: {link}'
    command_git_commit = f'git commit -m "{git_message}" -m "{git_description}"'
    print(command_git_commit)
    os.popen(command_git_commit)
    time.sleep(1)
