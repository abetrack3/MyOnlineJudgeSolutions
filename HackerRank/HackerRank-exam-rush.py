chapters, hours = [int(x) for x in input().split()]
arr = [0] * chapters
for i in range(chapters):
    arr[i] = int(input())
arr.sort()
count, sum = 0, 0
for i in arr:
    if sum + i <= hours:
        sum += i
        count += 1
    else:
        print(count)
        break
