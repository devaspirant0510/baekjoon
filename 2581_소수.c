#include <stdio.h>
#include <math.h>

int isPrime(int N){
	int i;
	for (i=2; i<=(int)sqrt(N); i++){
		if (N%i==0){
			return 0;
		}
	}
	return N;
}
int prime(int n,int m){
	int sum=0;
	int i,j;
	if (n==1){
		n=2;
	}
	for (i=n; i<=m; i++){
		sum+=isPrime(i);
	}
	return sum;
}
int minPrime(int n,int m){
	int index=0;
	int i,j;
	if (n==1){
		n=2;
	}
	
	for (i=n; i<=m; i++){
		if (isPrime(i)!=0){
			index = isPrime(i);
			return isPrime(i);
		}
	}
	return 0;
}

int main(){
	int min,max;
	scanf("%d",&min);
	scanf("%d",&max);
	if (prime(min,max)+minPrime(min,max)==0 || max==1){
		printf("-1");
	}
	else{
		printf("%d\n",prime(min,max));
		printf("%d\n",minPrime(min,max));
	}
	return 0;
}
