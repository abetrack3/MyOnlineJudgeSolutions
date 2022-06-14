s = input()
left = [int(0)] * len(s)
right = [int(0)] * len(s)
#left
for i in range(1, len(s)):
    # print(i)
    if (s[i] == ":") & (s[i - 1] == '(') : left[i] = 1 + left[i - 1]
    else: left[i] = left[i - 1]
# print("-----------------")
#right
for i in range(len(s) - 2, -1, -1):
    # print(i)
    if (s[i] == ':') & (s[i + 1] == ')'): right[i] = 1 + right[i + 1]
    else: right[i] = right[i + 1]
# print("-----------------")
#surf from left to right
maxi = max(left[len(s) - 1], right[0])
for i in range(1, len(s) - 1):
    # print(i)
    temp = left[i - 1] + right[i]
    if(s[i] == ')') & (s[0] == ':'): temp += 1
    maxi = max(maxi, temp)
print(maxi)