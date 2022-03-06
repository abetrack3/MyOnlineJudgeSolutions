test = int(input())

for x in range(test):
    x = [int(y) for y in input().split()] # welcometo list comprehension my brother
    a = x[0]
    b = x[1]
    c = x[2]
    d = x[3]

    if a + c == b + d:
        if c > b:
            print(1)
        elif c < b:
            print(2)
        else:
            print(-1)
    elif a + c < b + d:
        print(2)
    else:
        print(1)