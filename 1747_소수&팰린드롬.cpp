#include <iostream>
#include <cmath>
#include <cstdio>
#include <string>
#include <sstream>
using namespace std;

bool prime(int n){
	if (n<2){
		return false;
	}
	if (n==2){
		return true;
	}
	for (int i=2;i<sqrt(n)+1; i++){
		if (n%i==0){
			return false;
		}
	}
	return true;
}
string intToString(int n){
	stringstream s;
	s << n;
	return s.str();

}
bool palindrome(int n){
	int a = n;
	string str = intToString(a);
	int size = str.size()-1;
	
	for (int i=0; i<size/2+1; i++){

		if (str[i]!=str[size-i]){
			return false;
		}
	}
	return true;

}


int main(){
	int n;
	//cout << palindrome(101);
	cin >> n;

	while (true){
	
		if(palindrome(n)){

			if (prime(n)){
				cout << n;
				break;
			}
		}
		n+=1;

	}
	


	
	return 0;
} 
