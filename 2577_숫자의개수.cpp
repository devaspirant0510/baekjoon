#include <stdio.h>
#include <string.h>
#include <math.h>
int main(){
	int A,B,C,i; 
	// A,B,C ��ǲ   
	scanf("%d",&A);
	scanf("%d",&B);
	scanf("%d",&C);
	int result = A*B*C;
	// ����� ��� ���ڿ��� ��Ƽ� ���� �� ��  
	char r[100]; 
	int num[10]={0};
	sprintf(r,"%d",result);
	int len = strlen(r);
	int l,front;
	for (i=len-1; i>-1; i--){ 
		// �� �ڸ��� �̾� ��  
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
