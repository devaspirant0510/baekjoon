#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

int field[51][51];
bool check_field[51][51];

int N,M;

void DFS(int y, int x){
	if(check_field[y][x]==false && field[y][x]==1){
		
		check_field[y][x]=true;
		//up
		if(y-1>=0){
			DFS(y-1,x);
		}
		//down
		if(y+1<N){
			DFS(y+1,x);
			
		}
		//left
		if(x-1>=0){
			DFS(y,x-1);
			
		}	
		//right
		if(x+1<M){
			DFS(y,x+1);
		}
	}
}
int main(){

	int K;
	// 배추의 좌표
	int x,y; 
	int len;
	int count;
	//int test[1000];
	cin >> len;
	for (int k=0; k<len; k++){
		memset(field, 0, sizeof(field));
		memset(check_field, false, sizeof(check_field));
		//field[51][51]={0};
		//check_field[51][51]={0};
		// M 가로길이
		// N 세로길이
		// K 배추 개수
		cin >> M >> N >> K;
		count = 0;
		for (int i=0; i<K; i++){
			cin >> x >> y;
			field[y][x] = 1;	
		} 
		for (int i=0; i<N; i++){		
			for (int j=0; j<M; j++){
				if(check_field[i][j]==false && field[i][j]==1){
					DFS(i,j);
					count+=1;	
				}
			}

		}
		cout << count << endl;
	}


	return 0;
}
