#include <stdio.h>
#include <string.h>
int main(){
	char str[101];
	int alpha[26]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; 
	int i;
	scanf("%s",&str);
	int len = strlen(str);
	for (i=0; i<len; i++){
		if (alpha[str[i]%97]==-1){
			alpha[str[i]%97]=i;
		}
		
		
	}
	for (i=0; i<26; i++){
		printf("%d ",alpha[i]);
	}
	return 0;
	
}
