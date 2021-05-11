#include <iostream>
#include <cstdio>

using namespace std;

long long dist[100001];
long long cost[100001];


int main(){
	int n;
	int sum=0;
	cin >> n;
	for (int i=0; i<n-1; i++){
		cin >> dist[i];
	}
	for (int i=0; i<n; i++){
		cin >> cost[i];
	}

	int max = 1000000000;
	for (int i=0; i<n-1; i++){
		if (cost[i]<max){
			max = cost[i];
		}
		sum+=max*dist[i];

		
	}	
	cout << sum;
	return 0;
} 
