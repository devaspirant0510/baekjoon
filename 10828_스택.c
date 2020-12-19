#include <stdio.h>
#include <string.h>
int main(){
	int n,i,num;
	int stack[10000];
	char command[100006];
	int index = 0;
	int size = 0;
	int push;
	scanf("%d",&n);
	for (i=0; i<n; i++){
		scanf("%s",&command);

		if (strcmp(command,"push")==0){
			scanf("%d",&push);
			stack[index]=push;
			index+=1;
			size+=1;
		}
		else if (strcmp(command,"pop")==0){
			if (size !=0){
				printf("%d\n",stack[index-1]);
				size-=1;
				index-=1;
			}
			else{
				printf("-1\n");
			}
		}
		else if (strcmp(command,"size")==0){
			printf("%d\n",size);
		}
		else if (strcmp(command,"top")==0){
			if (size!=0){
				printf("%d\n",stack[index-1]);
			}
			else{
				printf("-1\n");
			}
		}
		else if (strcmp(command,"empty")==0){
	
			if (size == 0 ){
				printf("1\n");
			}
			else {
				printf("0\n");
			}
			
		}
		
	}

	
	
	
}
