import os
import re
import sys

from Automation_CodeChef import code_chef
from Automation_CodeForces import code_forces
from Automation_HackerRank import hacker_rank
from Automation_LeetCode import leet_code
from SeleniumWebDriver import WebDriverFactory

###################### Global Script Variables ######################

chromeDriver = WebDriverFactory.get_driver('./chromedriver', headless=True)


################## Automation Main Controller ##################

def __main__():
    judge_map = {
        'LeetCode': leet_code,
        'CodeForces': code_forces,
        'HackerRank': hacker_rank,
        'CodeChef': code_chef
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
        judge_map[file[0]](file, chromeDriver)


if __name__ == '__main__':
    try:
        __main__()
    except Exception:
        sys.stderr.write('Error Occurred')
        sys.stderr.flush()
    finally:
        chromeDriver.close()
        chromeDriver.quit()
