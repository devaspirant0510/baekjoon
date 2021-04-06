#include <iostream>
#include <cstdio>
using namespace std;

//int arr[1000001] ={0,};

int min(int a, int b){
	if (a<b){
		return a;
	}
	else{
		return b;
	}
}
int fx(int n){
	int a,b;
	if (n<2){
		return 0;
	}
	a = fx(n/2)+n%2+1;
	b = fx(n/3)+n%3+1;
	return min(a,b);
}
int main(){
	int n;
	scanf("%d",&n);
	printf("%d",fx(n));
//	arr[1] = 0;
//	for (int i=2; i<=n; i++){
//		arr[i] = arr[i-1]+1;
//		if (i%2==0){
//			arr[i] = min(arr[i],arr[i/2]+1);
//		}
//		if (i%3==0){
//			arr[i] = min(arr[i],arr[i/3]+1);
//		}
//	}
//	cout << arr[n];	
	return 0;
}

