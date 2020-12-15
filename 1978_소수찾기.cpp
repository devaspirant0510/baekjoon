#include <stdio.h>
int isPrime(int n){
	int i;
	if (n==1){
		return 0;
	}
	else{
		for (i=2; i<=n/2; i++ ){
			if (n%i==0){
				return 0;
			}
		}
		return 1;
	}
	
	
}
int main(){

	int i,n,el;
	scanf("%d",&n);
	int result=0;
	for (i=0; i<n; i++){
		scanf("%d",&el);
		result+=isPrime(el);
	}
	printf("%d",result);

	return 0;
}
