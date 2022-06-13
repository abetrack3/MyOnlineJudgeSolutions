import os
import re
import time

from bs4 import BeautifulSoup
from selenium.webdriver.chrome.webdriver import WebDriver


def code_forces(description, driver: WebDriver):
    driver.get('https://codeforces.com')
    contest_no, problem = re.findall('([0-9]+)([A-Z])', description[1])[0]
    link = f'https://codeforces.com/contest/{contest_no}/problem/{problem}'

    driver.get(link)
    doc = BeautifulSoup(driver.page_source, 'html.parser')

    problem_type = 'contest'
    if doc.title.string == 'Codeforces':
        link = f'https://codeforces.com/gym/{contest_no}/problem/{problem}'
        driver.get(link)
        doc = BeautifulSoup(driver.page_source, 'html.parser')
        problem_type = 'gym'

    problem_title = doc.find('div', {'class': 'title'}).contents[0]
    codeforces_round = doc.find('a', {'href': f'/{problem_type}/{contest_no}'}).text

    # git add
    command_git_add = f'git add CodeForces/CodeForces{description[1]}.{description[2]}'
    print(command_git_add)
    os.popen(command_git_add)
    time.sleep(1)

    # git commit
    message = f'CodeForces{description[1]}: {problem_title}'
    message_description = f'{message}\n{codeforces_round}\nLink to the problem: {link}'
    command_git_commit = f'git commit -m "{message}" -m "{message_description}"'
    print(command_git_commit)
    os.popen(command_git_commit)
    time.sleep(1)
