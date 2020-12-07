#include<stdio.h>

int main(){
	int A,B,C;
	scanf("%d %d %d",&A,&B,&C);
	if (B>C){
		printf("-1");
	}
	else{
		int cost = C-B;
		printf("%d",A/cost+1);
	}
	return 0;
}
