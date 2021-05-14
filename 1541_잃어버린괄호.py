s = input()
li=[]

ps = s.split('-')
start=ps[0]
start = sum(map(int,start.split('+')))
for i in ps[1:]:
    start-=sum(map(int,i.split("+")))
print(start)
