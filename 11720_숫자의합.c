#include <stdio.h>
#include <stdlib.h>
int main(){
	char str[101];
	int i,n,el;
	long long sum = 0;
	scanf("%d",&n);
	char num;
	scanf("%s",str);
	for (i=0; i<n; i++){
		
		sum+=str[i]-'0';
	}
	printf("%d",sum);
	return 0;
}
