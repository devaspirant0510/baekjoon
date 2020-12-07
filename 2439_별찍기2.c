#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,j,k;
	int *n = (int *)malloc(sizeof(int));
	scanf("%d",&(*n));

	
	for (i=0; i<*n; i++){
		for (j=*n-i-1; j>0; j--){
			printf(" ");
		}
		for (k=0; k<i+1; k++){
			printf("*");
		}
		printf("\n");
	} 
	free(n);
	return 0;
}
