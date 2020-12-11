#include<stdio.h>
int main(){
	int m,j,i,el,n;
	double c;
	int sum = 0;
	double avg = 0;
	double result = 0;
	scanf("%d",&n);
	for(j=0; j<n; j++){
		scanf("%d",&m);	
		sum=0;
		c=0;
		int arr[100]={0};
		for (i=0; i<m; i++){
			scanf("%d",&el);
			sum+=el;
			arr[i]=el;
		}
		printf("%d %d\n",sum,m);
		avg = sum/m;
		for (i=0; i<m; i++){
			if (arr[i]>(sum/m)){
				c+=1;
			}
		}
		
		result = c/m;
		printf("%.3f%%\n",result*100);
	}


	return 0;
}
