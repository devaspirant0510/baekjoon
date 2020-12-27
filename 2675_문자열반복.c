#include <stdio.h>
#include <string.h>
int main(){
	int j,len,n,i,k,l;
	scanf("%d",&len);
	for (j=0; j<len; j++){
		k=0;
		char str[21]={0};
		n=0;
		scanf("%d %s",&n,&str);
		k=strlen(str);

		for (i=0; i<k; i++){
			for(l=0; l<n; l++){
				printf("%c",str[i]);
			}
			
		}
		printf("\n");
	}
	
	return 0;
}
