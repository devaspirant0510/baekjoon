#include <iostream>
#include <queue>

using namespace std;

int dp[12]={0,};

int main(){
	dp[0]=1;
	dp[1]=2;
	dp[2]=4;
	int n;
	int size;
	cin >> size;
	for (int j=0; j<size; j++){
		cin >> n;
		for (int i=3; i<n; i++){
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		
		}
		cout << dp[n-1] << endl;
	
	}
	

	return 0;
}
