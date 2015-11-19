# Enter your code here. Read input from STDIN. Print output to STDOUT
from string import ascii_lowercase
chars = ascii_lowercase
n = input()
R = []
c = 0
for i in range(n):
    R.append(raw_input())
for x in chars:
    present = True
    for r in R:
        if x not in r:
            present = False
    if present:
        c += 1
print c
