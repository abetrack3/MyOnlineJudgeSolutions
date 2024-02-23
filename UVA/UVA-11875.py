for i in range(1, int(input())+1):
    arr = [int(x) for x in input().split()]
    arr.sort()
    print(f'Case {i}: {arr[len(arr) // 2]}')