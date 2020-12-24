#include <iostream>
#include <queue>

using namespace std;
int main(){
	int N;
	cin >> N;
	
	
	queue<int> q;
	int fr;
	for (int i=0; i<N; i++){
		q.push(i+1);
	}
	while(q.size()!=1){
		q.pop();
		fr=q.front();
		q.pop();
		q.push(fr);
	}
	cout << q.front();
	return 0;
}
