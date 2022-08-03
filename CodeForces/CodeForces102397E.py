def getSum(i, j, arr):
    if i == 0: return arr[j]
    else: return arr[j] - arr[i - 1]


n, x = [int(y) for y in input().split()]
arr = [int(y) for y in input().split()]
for i in range(1, n): arr[i] += arr[i - 1]
if arr[-1] < x:
    print(-1)
    quit()
#used binary search in java but I am gonna take linear search here
i = int(0)
j = int(0)
for y in arr:
    if y >= x: break;
    else: j += 1;
mini = j - i + 1
while j < n:
    while i <= j:
        if i < n - 1:
            if(getSum(i + 1, j, arr) >= x): i += 1
            else: break
        else: break
    mini = min(int(mini), j - i + 1)
    j += 1
print(mini)