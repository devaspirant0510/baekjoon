#include <stdio.h>
int quicksort(int *arr,int start,int end){
	if (start>=end){
		return;
	}
	int i = start+1;
	int j = end;
	int pivot = start;
	int temp;
	while (i<=j){
		while (arr[i] <= arr[pivot]){
			i++;
		}
		while (arr[j] >= arr[pivot] && j>start){
			j--;
		}
		if (i>j){
			temp = arr[j];
			arr[j] = arr[pivot];
			arr[pivot]=temp;
			
		}
		else{
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}	
	}
	quicksort(arr,start,j-1);
	quicksort(arr,j+1,end);
}
int main(){
	int i,n,el;
	scanf("%d",&n);
	int arr[n];
	for(i=0; i<n; i++){
		scanf("%d",&el);
		arr[i]=el;
	}
	quicksort(arr,0,n-1);

	int sum = 0;
	int pre = 0;
	for(i=0; i<n; i++){
		
		sum+=pre+arr[i];
		pre = pre+arr[i];
	}
	printf("%d",sum);
	return 0;
}
