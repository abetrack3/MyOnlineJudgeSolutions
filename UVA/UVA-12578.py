import math
for i in range(int(input())):
    length = int(input())
    width = length * 6 / 10
    radius = length * 1 / 5
    rectangularArea = length * width
    circleArea = math.pi * radius * radius
    print("{:.2f} {:.2f}".format(circleArea, rectangularArea-circleArea))