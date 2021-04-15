"""
add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다. 
"""
import sys

n = int(input())
s = set()

ts = set([i for i in range(1,21)])

for i in range(n):
    key = sys.stdin.readline().strip().split()
    if len(key) !=1:
        key[1] = int(key[1])
    if (key[0]=="add"):
        s.add(key[1])
    elif (key[0]=="remove"):
        if key[1] in s: 
            try:
                s.remove(key[1])
            except:
                pass
    elif key[0]=="check":
        if key[1] in s: 
            print(1)
        else:
            print(0)
    elif key[0]=="toggle":
        if key[1] in s: 
            s.remove(key[1])
        else:
            s.add(key[1])
    elif key[0]=="all":
        s = ts
    elif key[0]=="empty":
        s.clear()


