for i in range(int(input())):
    n = int(input())
    
    if n == 1:
        print(1)
    elif n == 2:
        print(2)
    elif n == 3:
        print(21)
    elif n == 4:
        print(121)
    elif n == 5:
        print(212)
    else:
        if n % 3 == 0:
            print('21' * (n//3))
        elif n % 3 == 1:
            print('12' * (n//3) + '1')
        else:
            print('21' * (n//3) + '2')