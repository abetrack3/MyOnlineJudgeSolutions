test_case = int(input())
 
for i in range(test_case):
    size = int(input())
    arr = [int(x) for x in input().split()]
    l = -1
    r = -1
    arr2 = None
    for i in range(size):
        if i + 1 == arr[i]:
            continue
        else:
            l = i
            r = arr.index(i + 1)
            arr2 = arr[:l] + arr[l: r + 1][::-1] + arr[r + 1 :]
            break
    if arr2 == None:
        print(str(arr).replace('[', '').replace(']', '').replace(',', ''))
    else:
        print(str(arr2).replace('[', '').replace(']', '').replace(',', ''))