#include <iostream>
#include <stack>
#include <string.h>
using namespace std;

int main(){
	stack<char> s;
	char vps[51];
	int n,len;
	bool end = false;
	cin >> n;
	for (int i=0; i<n; i++){
		cin >> vps;
		len = strlen(vps);
		for (int j=0; j<len; j++){
	
			s.push(vps[j]);
			if (vps[j]==')'){
				if (s.size()>=2){
					s.pop();
					s.pop();
				}
				else{
					printf("NO\n");
					end = true;
					break;
				}
			}
		}
		if (s.empty()==1){
			printf("YES\n");
		}
		else if (s.empty() == 0 && end == false){
			printf("NO\n");
		
		}
		end = false;
		while(s.empty()==0){
			s.pop();
		}
	}
	

	return 0;
}
