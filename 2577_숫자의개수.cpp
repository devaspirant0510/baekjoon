#include <stdio.h>
#include <string.h>
#include <math.h>
int main(){
	int A,B,C,i; 
	// A,B,C 인풋   
	scanf("%d",&A);
	scanf("%d",&B);
	scanf("%d",&C);
	int result = A*B*C;
	// 계산한 결과 문자열에 담아서 길이 출 력  
	char r[100]; 
	int num[10]={0};
	sprintf(r,"%d",result);
	int len = strlen(r);
	int l,front;
	for (i=len-1; i>-1; i--){ 
		// 각 자릿수 뽑아 냄  
		l = pow(10,i);
		front = result  / l;
		result -= l*front;
		num[front]+=1;
	}
	for (i = 0; i<10; i++){
		printf("%d\n",num[i]);
	}
	return 0;
}
