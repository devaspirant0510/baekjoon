#include <stdio.h>
#include <math.h>
float *pt(float *arr){
	float max=-1;
	int i,temp;
	int index=0;
	for (i=0; i<3; i++){
		if (arr[i]>max){
			index+=1;
			max = (int)arr[i];

		}
	}

	temp = arr[index-1];
	arr[index-1] = arr[0];
	arr[0] = temp;

	return arr;
	
}
int main(){
	float a,b,c;
	int i;
	float arr[3]= { 0 };
	while (1){
		scanf("%f %f %f",&a,&b,&c);
		if (a==0 && b==0 && c==0){
			break;
		}
		arr[0]=a;
		arr[1]=b;
		arr[2]=c;
		float *ar = pt(arr);

		if (pow(ar[0],2)==pow(ar[1],2)+pow(ar[2],2)){
			printf("right");
		}
		else{
			printf("wrong");
		}
		putchar('\n');
		
	}
	return 0;
}
