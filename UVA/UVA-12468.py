fromm, to = [int(x) for x in input().split()]
while fromm != -1 and to != -1:
    dist1 = abs(to - fromm)
    dist2 = 100 - dist1
    print(min(dist1, dist2))
    fromm, to = [int(x) for x in input().split()]