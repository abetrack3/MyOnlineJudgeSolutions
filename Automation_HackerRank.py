import os
import time

from selenium.common.exceptions import TimeoutException
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

DELAY_TIMEOUT = 10


def hacker_rank(description, driver: WebDriver):
    # Getting the Problem Title
    vjudge_link = f'https://vjudge.net/problem/{description[0]}-{description[1]}'
    driver.get(vjudge_link)
    try:
        elem = WebDriverWait(driver, DELAY_TIMEOUT).until(
            EC.presence_of_element_located((By.XPATH, '//*/div[@id="prob-title"]/h2'))
        )
        question_title = elem.text
    except TimeoutException:
        print("Loading took too much time!")
        return
    print(question_title)

    # Getting the original problem link
    driver.get(f'{vjudge_link}/origin')
    hackerrank_link = driver.current_url
    print(hackerrank_link)

    # git add
    file_name = f'{description[0]}-{description[1]}.{description[2]}'
    command_git_add = f'git add HackerRank/{file_name}'
    print(command_git_add)
    os.popen(command_git_add)
    time.sleep(1)

    # git commit
    message = f'HackerRank {question_title}'
    message_description = f'{message}\nLink to the problem: {hackerrank_link}'
    command_git_commit = f'git commit -m "{message}" -m "{message_description}"'
    print(command_git_commit)
    os.popen(command_git_commit)
    time.sleep(1)
