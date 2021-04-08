#include <iostream>

using namespace std;

int main(){
	int n;
	int count = 0;
	
	cin >> n;

	for (int i=2; i<=n; i++){
		if (i%5==0){
			count +=1;
		}
		if (i%25==0){
			count +=1;
		}
		if (i%125==0){
			count +=1;
		}
	}
	cout << count;
	return 0;
} 
