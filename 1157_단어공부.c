#include <stdio.h>
#include <string.h>

int main(){
	char str[1000000];
	scanf("%s",&str);
	int i,n;
	int len = strlen(str);

	int alpha[26] ={0};
	for (i=0; i<len; i++){
		if (65<=(int)str[i] && (int)str[i]<=90){
			alpha[(int)str[i]%65]+=1;
		}
		else if (97<=(int)str[i] && (int)str[i]<=122){
			alpha[(int)str[i]%97]+=1;
		}

	}
	int max = 0;
	int index;
	for (i=0; i<26; i++){
		if (max<alpha[i]){
			max = alpha[i];
			index = i;
		}
	}
	int cnt = 0;
	for (i=0; i<26; i++){
		if (alpha[i]!=0 && alpha[i]==max){
			cnt+=1;
			if (cnt ==2 ){
				printf("?");
				break;
			}
		}
		
	}
	if (cnt == 1){
		printf("%c",index+65);
	}
	
	return 0;
}
