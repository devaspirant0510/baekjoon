#include <stdio.h>
long long int arr[92]={0};
long long int fibo(int n){
	if (n==0){
		return 0;
	}
	else if (n==1){
		return 1;
	}
	
	arr[1] = 1;
	int i;
	for (i=2; i<=n; i++){
		arr[i] = arr[i-1]+arr[i-2];
	}
	return arr[i-1];

}
int main(){


	int n;
	scanf("%d",&n);
	printf("%lld\n",fibo(n));

	return 0;
}
