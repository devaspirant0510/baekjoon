#include <stdio.h>
int abs(int n){
	if (n<0){
		return -n;
	}
	else{
		return n;
	}
}
int main(){
	int N,M,el,i,j,k;
	scanf("%d %d",&N,&M);
	int result;
	int max = 0;
	int arr[M];
	int answer,sum;
	int tr = 0;
	for (i=0; i<N; i++){
		scanf("%d",&el);
		arr[i]=el;
	}
	for(i=0; i<N; i++){
		for(j=0; j<N; j++){
			for(k=0; k<N; k++){
				if(i!=j && j!=k && i!=k){

					sum = arr[i]+arr[j]+arr[k];
					if (sum==M){
						tr=1;
						goto EXIT;
					}
					if(sum<=M && sum>max){
		
						max = sum;
						
					}
				}
			}
		}
	}
	if (tr==0){
		printf("%d",max);
	}
	else{
		EXIT:
			printf("%d",M);
	}
	return 0;
}
