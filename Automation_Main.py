import os, re, time, requests
from bs4 import BeautifulSoup
from SeleniumWebDriver import WebDriverFactory
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException

###################### Global Script Variables ######################

driver = WebDriverFactory.get_driver('./chromedriver', headless=True)
DELAY_TIMEOUT = 10

################## Judge Wise Automation Functions ##################

def code_forces(description):
    # print('code_forces')
    contest_no, problem = re.findall('([0-9]+)([A-Z])', description[1])[0]
    link = f'https://codeforces.com/contest/{contest_no}/problem/{problem}'

    result = requests.get(link)
    doc = BeautifulSoup(result.text, 'html.parser')

    if doc.title.string == 'Codeforces':
        link = f'https://codeforces.com/gym/{contest_no}/problem/{problem}'
        doc = BeautifulSoup(requests.get(link).text, 'html.parser')

    problem_title = doc.find('div', {'class': 'title'}).contents[0]
    codeforces_round = doc.find('a' , {'href' : f'/contest/{contest_no}'}).text
    # print(codeforces_round)

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

def leet_code(description):
    file_name = f'{description[0]}-{description[1]}.{description[2]}'
    print(file_name)
    link = f'https://leetcode.com/problems/{description[1]}/'
    print(link)
    driver.get(link)
    try:
        elem = WebDriverWait(driver, DELAY_TIMEOUT).until(EC.presence_of_element_located((By.XPATH, f'//*/div[@data-cy="question-title"]')))
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
        'LeetCode' : leet_code,
        'CodeForces' : code_forces
    }
    judge_list = ['LeetCode', 'CodeForces']

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
        judge_map[file[0]](file)
        # break
    driver.close()
if __name__ == '__main__':
    __main__()