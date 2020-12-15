#include <stdio.h>
#include <math.h>
int isPrime(int n){
	int i;
	if (n==1){
		return 0;
	}
	else{
		for (i=2; i<=(int)sqrt(n); i++){
			if (n%i==0){
				return 0;
			}
		}
		return n;
	}
}
void prime(int min,int max){
	int i;
	int prime;
	for (i=min; i<=max; i++){
		prime = isPrime(i);
		if (prime != 0){
			printf("%d\n",isPrime(i));
		}
	}
}
int main(){
	int min,max;
	scanf("%d",&min);
	scanf("%d",&max);
	prime(min,max);
	return 0;
}
