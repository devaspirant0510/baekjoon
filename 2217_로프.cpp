#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std; 

int arr[10001];

int max(int a, int b){
	return a>b?a:b;	

	
}
int main(){
	int n;
	int res=0;
	cin >> n;
	for (int i =0 ; i<n; i++){
		cin >> arr[i];
	}
	sort(arr,arr+n);
	for (int i=0; i<n; i++){
		res = max(arr[i]*(n-i),res);
	}
	cout << res;
	
	return 0;
} 
