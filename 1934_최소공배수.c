#include <stdio.h>
int min(int a, int b){
	if (a<b){
		return a;
	}
	else{
		return b;
	}
}
int main(){
	
	int i,a,b;
	int n;
	int gcd;
	scanf("%d",&n);
	
	for (i=0; i<n; i++){
		scanf("%d %d",&a,&b);
		int d = min(a,b);

		gcd = 1;
		while (1){
		
			if (a%d==0 && b%d==0){
	
				a/=d;
				b/=d;
				gcd*=d;
				if (d==1){
					break;
				}
				
			}
			else{
				
				d-=1;
			}
			
		}
		printf("%d\n",a*b*gcd);
		
	}
	
	return 0;
} 
