#include <stdio.h>
void reverse(int *num){
	int result =0;
	int front,middle,end;
	front = *num/100;
	end = *num%10;
	middle = *num%100-end;
	
	*num = end*100+middle+front;
}
int main(){
	int a,b;
	scanf("%d %d",&a,&b);
	int *p1 = &a;
	int *p2 = &b;

	reverse(p1);
	reverse(p2);
	int answer =  a>b?a:b;
	printf("%d",answer); 
	return 0;
}
