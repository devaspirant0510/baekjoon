#include <stdio.h>
int main(){
	int a,b,v;
	scanf("%d %d %d",&a,&b,&v);
	int distance = v-a;
	int oneday = a-b;
	printf("%d",distance%oneday==0?distance/oneday+1:distance/oneday+2);
	return 0;
}
