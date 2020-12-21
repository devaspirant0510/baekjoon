#include <stdio.h>

int main(){
	int sum=0;
	int i,n,k,index;
	int count=0;
	int tempK[100001]={0};
	int p;
	scanf("%d",&n);
	for (i=0; i<n; i++){
		scanf("%d",&k);
		if (k==0){
			count-=1;
			sum-=tempK[count];

			
			
		}
		else{
			tempK[count] = k;
			sum+=k;
			count+=1;
			
		}
		
		
	}
	printf("%d",sum);
	return 0;
}
