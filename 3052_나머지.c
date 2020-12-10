#include <stdio.h>
int main(){
	int i,el;
	int num[43]={0};
	for (i=0; i<10; i++){
		scanf("%d",&el);
		num[el%42]+=1;
	}
	int result = 0;
	for (i=0; i<sizeof(num)/4; i++){
		if (num[i]!=0){
			result+=1;
		}
	}
	printf("%d",result);
	return 0;
}
