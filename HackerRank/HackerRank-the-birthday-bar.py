def cumulative(arr, x, y):
    return arr[y] if x == 0 else arr[y] - arr[x - 1]

size = int(input())
arr = [int(x) for x in input().split()]
sum, segment = [int(x) for x in input().split()]
for i in range(1, size):
    arr[i] += arr[i - 1]

count = 0

start = 0
end = segment - 1
while end < size:
    tempSum = cumulative(arr, start, end)
    if tempSum == sum:
        count += 1
    end += 1
    start += 1
print(count)
