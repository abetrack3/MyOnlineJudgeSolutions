size = int(input())
arr = [int(x) for x in input().split()]
for i in range(1, size):
	arr[i] += arr[i - 1]
query = int(input())
for i in range(query):
	a, b = [int(x) for x in input().split()]
	if a == 0: print(arr[b])
	else: print(arr[b] - arr[a - 1])