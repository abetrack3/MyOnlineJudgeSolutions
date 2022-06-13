import os
import time

from selenium.common.exceptions import TimeoutException
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

DELAY_TIMEOUT = 10


def leet_code(description, driver: WebDriver):
    file_name = f'{description[0]}-{description[1]}.{description[2]}'
    print(file_name)
    link = f'https://leetcode.com/problems/{description[1]}/'
    print(link)
    driver.get(link)
    try:
        elem = WebDriverWait(driver, DELAY_TIMEOUT).until(
            EC.presence_of_element_located((By.XPATH, f'//*/div[@data-cy="question-title"]')))
        question_title = elem.text
    except TimeoutException:
        print("Loading took too much time!")
        print(description)
        return
    question_title = 'LeetCode ' + question_title
    print(question_title)

    # git add
    command_git_add = f'git add LeetCode/{file_name}'
    print(command_git_add)
    os.popen(command_git_add)
    time.sleep(1)

    # git commit
    message = question_title
    message_description = f'{message}\nLink to the problem: {link}'
    command_git_commit = f'git commit -m "{message}" -m "{message_description}"'
    print(command_git_commit)
    os.popen(command_git_commit)
    time.sleep(1)
