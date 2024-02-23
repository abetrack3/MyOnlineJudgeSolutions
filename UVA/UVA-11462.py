size = int(input())
while size != 0:
    arr = [int(x) for x in input().split()]
    arr.sort()
    print(*arr)
    size = int(input())