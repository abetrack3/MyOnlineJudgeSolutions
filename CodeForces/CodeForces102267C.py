
s,x = [int(y) for y in input().split()]
count = int(0)
while s != 0:
    count += 1
    s //= x
print(count)