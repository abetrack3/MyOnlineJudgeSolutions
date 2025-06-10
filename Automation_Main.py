import os
import re
import sys

from Automations.Automation_CodeChef import code_chef
from Automations.Automation_CodeForces import code_forces
from Automations.Automation_HackerRank import hacker_rank
from Automations.Automation_LeetCode import leet_code
from Automations.Automation_LightOJ import light_oj
from Automations.Automation_SphereOJ import sphere_oj
from Automations.Automation_UVA import uva_online_judge
from Automations.SeleniumWebDriver import WebDriverFactory
from Automations.utils.driver_utils import get_driver_binary_file_extension

###################### Global Script Variables ######################

chromeDriver = WebDriverFactory.get_driver(f'./chromedriver.{get_driver_binary_file_extension()}', headless=False)


################## Automation Main Controller ##################

def __main__():

    judge_map = {
        'LeetCode': leet_code,
        'CodeForces': code_forces,
        'HackerRank': hacker_rank,
        'CodeChef': code_chef,
        'LightOJ': light_oj,
        'SPOJ': sphere_oj,
        'UVA': uva_online_judge,
    }

    judge_list = judge_map.keys()

    command_git_status = 'git status --untracked-files'

    command_result = os.popen(command_git_status)

    solution_file_name_pattern = f'({"|".join(judge_list)})-?([A-Za-z0-9\\-_]+)\\.(java|cpp|py|c|js)$'

    files = []

    for file in command_result.readlines():
        res = re.findall(solution_file_name_pattern, file)
        if len(res) > 0:
            files.append(res[0])

    for file in files:
        judge_map[file[0]](file, chromeDriver)
        # break


if __name__ == '__main__':
    try:
        __main__()
    except Exception as e:
        sys.stderr.write('Error Occurred')
        sys.stderr.write(str(e))
        sys.stderr.flush()
    finally:
        chromeDriver.close()
        chromeDriver.quit()
