#include <iostream>

using namespace std;

int main(){
	int zeros[41];
	int ones[41];
	zeros[0] = 1;
	ones[0] = 0;
	int n,size;
	cin >> size;
	for (int j=0; j<size; j++){
		cin >> n;
		for (int i=1; i<=n; i++){
			zeros[i] =ones[i-1];
			ones[i] = zeros[i-1]+ones[i-1];
		}
		cout << zeros[n] << " " << ones[n]<<endl;
	} 

	return 0;
}
