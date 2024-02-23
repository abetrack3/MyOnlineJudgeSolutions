a = int(input())

for i in range(a):
    s = input().split()
    first, second = int(s[0]), int(s[1])
    if first > second:
        print('>')
    elif first < second:
        print('<')
    else:
        print('=')