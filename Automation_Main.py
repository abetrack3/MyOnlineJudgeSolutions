import os
import re
import time

from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.webdriver import WebDriver

from Automation_CodeForces import code_forces
from SeleniumWebDriver import WebDriverFactory

###################### Global Script Variables ######################

chromeDriver = WebDriverFactory.get_driver('./chromedriver', headless=True)
DELAY_TIMEOUT = 10


################## Judge Wise Automation Functions ##################

def hacker_rank(description, driver : WebDriver):
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


def leet_code(description, driver : WebDriver):
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


################## Automation Main Controller ##################

def __main__():
    judge_map = {
        'LeetCode': leet_code,
        'CodeForces': code_forces,
        'HackerRank': hacker_rank
    }
    judge_list = judge_map.keys()

    command_git_status = 'git status --untracked-files'

    command_result = os.popen(command_git_status)

    pattern = f'({"|".join(judge_list)})-?([A-Za-z0-9\-]+)\.(java|cpp|py|c|js)$'

    files = []
    for file in command_result.readlines():
        res = re.findall(pattern, file)
        if len(res) > 0:
            files.append(res[0])

    for file in files:
        # print(file)
        judge_map[file[0]](file, chromeDriver)
        # break
    chromeDriver.close()
    chromeDriver.quit()


if __name__ == '__main__':
    __main__()
