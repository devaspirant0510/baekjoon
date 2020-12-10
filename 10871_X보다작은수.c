#include <stdio.h>

int main(){
	int i,el,n,x;
	int arr[5];
	scanf("%d %d",&n,&x);
	for (i=0; i<n; i++){
		scanf("%d",&el);
		arr[i]=el;
	}
	for (i=0; i<5; i++){
		if (arr[i]<x){
			printf("%d",arr[i]);
		}
		
	}
	return 0;
}
