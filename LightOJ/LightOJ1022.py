from math import pi 
for i in range(1, int(input()) + 1):
    r = float(input())
    area = (2 * r) ** 2
    area -= pi * r ** 2
    print(f'Case {i}: {area:.2f}')
