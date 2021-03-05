#include<iostream>
#include<cstring>

using namespace std;

char input[101];
	
int isPal(int len){
	for (int i=0; i<=len/2; i++){
		if(input[i] != input[len-i]){
			return 0;
		}
		
	}
	return 1;
}
int main(){

	cin >> input;
	int len = strlen(input)-1;
	cout << isPal(len)<<endl;	

	return 0;	
}
