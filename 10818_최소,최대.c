#include <stdio.h>
int main(){
	int n,i,el,min,max;
	scanf("%d",&n);
	int arr[n];
	for (i=0; i<n; i++){
		scanf("%d",&el);
		arr[i]=el;
	} 
	min = arr[0];
	max = arr[0];
	for (i=1; i<n; i++){
		if (arr[i]<min){
			min = arr[i];
		}
		if (arr[i]>max){
			max = arr[i];
		}
	}
	printf("%d %d",min,max);
	return 0;
}
