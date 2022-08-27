t = int(input())
for i in range(1, t + 1):
    input()
    input()
    ans = sum([ max(0, int(x)) for x in input().split()])
    print('Case ', i, ': ', ans, sep = '')