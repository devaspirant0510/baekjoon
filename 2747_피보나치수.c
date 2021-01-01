#include <stdio.h>

int fibo(int n){
	if (n==0){
		return 0;
	}
	else if (n==1){
		return 1;
	}

	else{
		int i;
		int front = 0;
		int back = 1;
		int temp;
		for (i=1; i<n; i++){
			temp = front+back;
			front = back;
			back = temp;
			
			
		}
		return temp;
	}
}
int main(){


	int n;
	scanf("%d",&n);
	printf("%d\n",fibo(n));

	return 0;
}
