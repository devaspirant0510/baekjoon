#include <stdio.h>
int main(){
	int n;

	printf("\n");
	scanf("%d",&n);
	if (n==1){
		printf("1");
	}
	else{
		int i=0;
		int front = 2;
		int back = front+6;
		while (1){
			i+=1;
			if (front <= n && n<back){
				printf("%d\n",i+1);
				break;
			}
			else{
				front = front+6*i;
			back = front+6*(i+1);
			}

			
		}
	}

	return 0;
} 
