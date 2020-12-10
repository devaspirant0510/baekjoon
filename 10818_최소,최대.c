#include <stdio.h>
int main(){
	int n,i,el,min,max;
	scanf("%d",&n);
	
	min = 10000001;
	max = -10000001;
	for (i=0; i<n; i++){
		scanf("%d",&el);
		if (el<=min){
			min=el;
		}
		else if (el>=max){
			max = el;
		}
	} 
	

	printf("%d %d",min,max);
	return 0;
}
