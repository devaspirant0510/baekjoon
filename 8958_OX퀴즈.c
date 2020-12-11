#include <stdio.h>
#include <string.h>
int main(){
	int i,j,n,sum,temp;
	sum=0;
	temp=0;
	char ox[80];
	scanf("%d",&n);
	for (j=0; j<n; j++){
	
		scanf("%s",&ox);
		
		sum = 0;
		temp = 0;
		for ( i=0; i<strlen(ox); i++){
			if (ox[i]=='O'){
				
				
				temp+=1;
				sum+=temp;
				
				
			}
			else{
				temp = 0;
			}
		}
		printf("%d\n",sum);
	}
	
	return 0;
}
