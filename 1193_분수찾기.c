#include <stdio.h>

int main(){
	int n,i,g;
	
	scanf("%d",&n);
	int c=0;
	for (i=1; i<100000000; i++){
		c+=i;g=0;
		if(c-i+1<=n && n<=c){
			printf("%d %d\n",c-i+1,c);
			g=n-(c-i);
			if (i%2==0){
				printf("%d/%d\n",g,i-g+1);
		
				
			}else{
				printf("%d/%d\n",i-g+1,g);
			
				
			}
		}
		
	}
	return 0;
}

