n = int(input())
name =[]
year = []
min1 = 20111111
max1 = -1
for i in range(n):
    na,d,m,y= input().split()
    name.append(na)
    date = int(y)*10000+int(m)*100+int(d)
    year.append(date)
#    if date<min1:
#        min1 = date
#    if date>max1:
#        max1 = date

print(name[year.index(max(year))])
print(name[year.index(min(year))])

