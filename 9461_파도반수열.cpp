#include <iostream>

using namespace std;

long long pn[101];

int main(){
	pn[0]=1;
	pn[1]=1;
	pn[2]=1;
	int size,n;
	cin >> size;
	for (int i=0; i<size; i++){
		cin >> n;
		for(int j=3;j<n; j++){
			pn[j] = pn[j-2]+pn[j-3];
		}
		cout << pn[n-1] << endl;
		
	}	
	return 0;
}
