#include <stdio.h>

int main(){
	int a,b,c,d,e,f;
	int ra,rb;
	scanf("%d %d",&a,&b);
	scanf("%d %d",&c,&d);
	scanf("%d %d",&e,&f);
	if (a==c){
		ra = e; 
	}
	else if (c == e){
		ra = a;
	}
	else{
		ra = c;
	}
	if(b==d){
		rb=f;
	}
	else if(d==f){
		rb = b;
	}
	else{
		rb = f;
	}
	printf("%d %d",ra,rb);

	return 0;
}
