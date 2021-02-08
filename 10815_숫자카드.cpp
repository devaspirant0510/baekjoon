#include <stdio.h>

int mArr[10000001];
int  arr[10000001];
void merge(int arr[],int start,int mid,int end){
	int i=start;
	int j=mid+1;
	int k = start;
	while(i<=mid && j<=end){
		if(arr[i]<=arr[j]){
			mArr[k] = arr[i];
			i++;
		}
		else{
			mArr[k] = arr[j];
			j++;
		}
		k++;
	}
	int t;
	if (i>mid){
		for (t=j; t<=end; t++){
			mArr[k] = arr[t];
			k++;
		}
	}
	else{
		for(t=i; t<=mid; t++){
			mArr[k] = arr[t];
			k++;
		}
	}

	for(t = start; t <= end; t++){
		arr[t] = mArr[t];
	}
}

void merge_sort(int arr[], int start,int end){
	if (start<end){
		int mid = (start+end)/2;
		merge_sort(arr,start,mid);
		merge_sort(arr,mid+1,end);
		merge(arr,start,mid,end);
	}
}
int bin_search(int start,int end,int find){
	int i=start;
	int j=end;
	int mid = (start+end)/2;
	while(i<=j){
		int mid = (i+j)/2;

		if (find==arr[mid]){
			return 1;
		}
		else if(find<arr[mid]){
			j=mid-1;
		}
		else if(find>arr[mid]){
			i=mid+1;
		}
		
	}
	return 0;
}

int main(){
	
	int i,n,el,m;
	scanf("%d",&n);

	for (i=0; i<n; i++){
		scanf("%d",&el);	
		arr[i] = el;
		
	}
	merge_sort(arr,0,n-1);

	scanf("%d",&m);


	for (i=0; i<m; i++){
		scanf("%d",&el);
		printf("%d ",bin_search(0,n-1,el));
	}
	                                                                                                                                         
	return 0;
}
