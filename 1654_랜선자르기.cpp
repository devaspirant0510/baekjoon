#include <iostream>

using namespace std;

long long Karr[10001];

int N,K;

bool getLen(long long size){
	int getK = 0;
	for (int i=0; i<N; i++){
		getK+=Karr[i]/size;
	}
	if(getK>=K){
		return true;
	}
	return false;
}
int main(){
	cin >> N >> K;
	long long len;
	long long max=-1;
	for (int i=0; i<N; i++){
		cin >> len;
		Karr[i] = len;
		if (len>max){
			max=len;
		}
	}	
	long long left = 1;
	long long right = max;
	long long middle = (left+right)/2;	
	long long result = 0;
	while (left <= right){
		
		middle = (left+right)/2;
		
		if(getLen(middle)){
			if (result<middle){
				result = middle;
			}
			left = middle+1;
	}
		else{
			right=middle-1;

		}
		
	}
	cout<<result;
	return 0;
}
