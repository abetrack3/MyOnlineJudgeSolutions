import os
import time
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.common.exceptions import TimeoutException

DELAY_TIMEOUT = 10

def uva_online_judge(description, driver: WebDriver):

    # Getting the problem title
    vjudge_link = f'https://vjudge.net/problem/{description[0]}-{description[1]}'
    driver.get(vjudge_link)
    try:
        elem = WebDriverWait(driver, DELAY_TIMEOUT).until(
            EC.presence_of_element_located((By.XPATH, '//*/div[@id="prob-title"]/h2'))
        )
        question_title = elem.text
    except TimeoutException:
        print("Loading took too much time!")
        print(description)
        return
    print(question_title)

    # Getting the original problem link
    driver.get(f'{vjudge_link}/origin')
    uva_online_judge_link = driver.current_url
    print(uva_online_judge_link)

    # git add
    file_name = f'{description[0]}-{description[1]}.{description[2]}'
    command_git_add = f'git add UVA/{file_name}'
    print(command_git_add)
    os.popen(command_git_add)
    time.sleep(1)

    # git commit
    message = f'UVA-{description[1]}: {question_title}'
    message_description = f'{message}\nLink to the problem: {uva_online_judge_link}'
    command_git_commit = f'git commit -m "{message}" -m "{message_description}"'
    print(command_git_commit)
    os.popen(command_git_commit)
    time.sleep(1)


