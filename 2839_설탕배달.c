#include <stdio.h>
int sugar(int n){
	int cnt = 0;
	while (1){
		if (n%5==0){
			n/=5;
			return n+cnt;
		}
		else{
			n-=3;
			cnt+=1;
			if (n<0){
				return -1;
			}
		}
	}
	
		
	
}
int main(){
	int n;
	while (1){
	
	scanf("%d",&n);
	printf("%d\n",sugar(n));
}
	return 0;
}
