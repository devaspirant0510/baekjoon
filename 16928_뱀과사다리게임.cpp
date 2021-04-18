#include <iostream>
#include <queue>

using namespace std;

int road[101];
int check[101];

int main(){
	int N,M;
	cin >> N >> M;
	for (int i=1; i<101; i++){
		road[i] = i;
		check[i] = -1;
	}
	int loop = N+M;
	for (int i=0; i<loop; i++){
		int u,v;
		cin >> u >> v;
		road[u] = v; 
	}		
	queue<int> q;
	q.push(1);
	check[1] = 0;
	while(!q.empty()){
		int pos = q.front();
		q.pop();
		if (pos==100){
			cout << check[pos];
			break;
		}
		
		for (int i=1; i<7; i++){
			int y=pos+i;
			if (y>100){
				continue;
			}
			y = road[y];
			if(check[y]==-1){
				check[y]= check[pos]+1;
				q.push(y);
				
			}
			
		}
	}
	
	return 0;
}
