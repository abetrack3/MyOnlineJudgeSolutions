testcase = int(input())
for i in range(testcase):
    numberOfProblems = int(input())
    if numberOfProblems <= 10:
        print(f'{numberOfProblems} 0')
    else:
        print(f'{numberOfProblems - 10} 10')