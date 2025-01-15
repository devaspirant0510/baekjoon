#include <cmath>
#include <iostream>

using namespace std;

int main(){
	int N;
	int shirt[6] = {0,0,0,0,0,0};
	int T,P;
	cin >> N;
	for (int i=0; i<6; i++){
		cin >> shirt[i];
	}
	cin >> T;
	cin >> P;
	int tcount = 0;
	int pGroupCount = 0;
	int pCount = 0;

	for (int i=0; i<6; i++){
		if(shirt[i]%T==0){
			tcount+=(int)(shirt[i]/T);
		}
		else{
			tcount+=(int)(shirt[i]/T)+1;
		}

	}
	pGroupCount=(int)(N/P);
	pCount = N%P;
	cout << tcount << endl;
	cout << pGroupCount << " " << pCount << endl;
	return 0;
}
