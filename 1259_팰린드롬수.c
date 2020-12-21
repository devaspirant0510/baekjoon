#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(){
	char qu[1001];
	char st[1001];
	 
	char input[100000];
	int start=0;
	int end=0;
	int len,i;
	int yn=1;
	while (1){
		scanf("%s",input);
		
		if (atoi(input)==0){
			break;
		}
		else{
			yn=1;
			len = strlen(input)-1;
			for (i=0; i<len/2+1; i++){
				if(input[i]!=input[len-i]){
					printf("no\n");
					yn=0;
					break;
				}
				
			}
			if(yn==1){
				printf("yes\n");
			}
			
		
		}
				
	}
	return 0;
}
