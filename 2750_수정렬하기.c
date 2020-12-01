#include <stdio.h>

int main(){
	int index,i,j,min,temp;
	int input;
	scanf("%d",&input);
	int arr[input];
	int el;
	for (i=0; i<input; i++){
		scanf("%d",&el);
		arr[i] = el;
	}
	int n = sizeof(arr)/4;
	
	for (i=0; i<n; i++){
		int min = arr[i];
		for (j=i; j<n; j++){
			if (min>=arr[j]){
				index = j;
				min = arr[j];
			}
		}

		temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}
	
	for (i = 0; i<input; i++){
		printf("%d ",arr[i]);
	}
	return 0;
} 
