# your code goes here
test = int(input())
for t in range(1, test + 1):
	x = [int(y) for y in input().split()]
	x.sort()
	print("Case " + str(t) + ": " + str(x[1]))