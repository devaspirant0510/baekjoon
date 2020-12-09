#include <stdio.h>

int main(){
	int input;
	int cnt=1;
	scanf("%d",&input);
	if (input == 0){
		printf("1");
	}
	else{
		int temp = input;
		int front = input%10*10;
		int back = (input/10+input%10)%10;
		int full = front+back;
	
		while (1){
			front = full%10*10;
			back = (full/10+full%10)%10;
			full = front+back;
	
			cnt+=1;
			if (temp == full){
				printf("%d",cnt);
				break;
			}	
		}
	}

	return 0;
}
