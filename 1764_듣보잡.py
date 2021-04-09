nohear,nosee = map(int,(input().split()))
nhlist = [] # 듣도못한 리스트
nslist = [] # 보도못한 리스트
for i in range(nohear):
    nhlist.append(input())
for i in range(nosee):
    nslist.append(input())

print(len(list(set(nhlist) & set(nslist))))
nohslist = list(set(nhlist) & set(nslist)) # 듣보보도못한 리스트
nohslist.sort()
for i in nohslist:
    print(i)