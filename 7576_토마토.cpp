#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>

using namespace std;

#define SIZE 1000

queue< pair<int,int> > q;
queue<int> s_q;


int M,N;
int cache[SIZE][SIZE];
int tomato[SIZE][SIZE];

int tomato_full(){
	for (int i=0; i<N; i++){
		for (int j=0; j<M; j++){
			if(tomato[i][j]==0){
				return 0;
			}
		}
	}
	return 1;
}
// 모두 탐색했는지 확인
int check_empty(){
	for (int i=0; i<N; i++){
		for (int j=0; j<M; j++){
			if(tomato[i][j]==0){
				return 0;
			}
		}
	}
	return 1;
}

void input(){
	cin >> M >> N;
	for (int i=0; i<N; i++){
		int el;
		for (int j=0; j<M; j++){
			cin >>el;
			cache[i][j]=0;
			if(el==-1){
				cache[i][j]=el;
			}
			tomato[i][j]=el;
			if(el==1){
				q.push(make_pair(i, j));
				s_q.push(0);
			}
		}
	}
}

int is_can_go(int y,int x){
	if (y>=0 && y<N && x>=0 && x<M){
		// 감염되지 않은 토마토일때
		if(tomato[y][x]==0){
			return 1;
		}
		return 0;
	}
	return 0;
}

void logging(){
	for (int i=0; i<N; i++){
		for (int j=0; j<M; j++){
			cout << tomato[i][j]<< " ";
		}
		cout << endl;
	}
}

void logging2(){
	for (int i=0; i<N; i++){
		for (int j=0; j<M; j++){
			cout << cache[i][j]<< " ";
		}
		cout << endl;
	}
}
int main(){
	input();
	int date = 0;
	if(tomato_full()==1){
		cout << 0 << endl;
		return 0;
	}

	while(!q.empty()){
		pair<int,int> pos  = q.front();
		int c_date = s_q.front();
		date = max(c_date,date);
		q.pop();
		s_q.pop();
		int y = pos.first;
		int x = pos.second;
		//cout << "queue  size " << q.size() << endl;
		//cout << "pop queeue y:" << y << "x : "<< x<< endl;
		//cout << "cache ["<<y<<","<<x<<"]="<<cache[y][x]<<endl;
		//cout << "date: " << date << endl;
		if(is_can_go(y-1,  x)==1){
			tomato[y-1][x] = 1;
			q.push(make_pair(y-1, x));
			s_q.push(c_date+1);
		}
		if(is_can_go(y+1,  x)==1){
			tomato[y+1][x] = 1;
			q.push(make_pair(y+1, x));
			s_q.push(c_date+1);
		}
		if(is_can_go(y,  x-1)==1){
			tomato[y][x-1] = 1;
			q.push(make_pair(y, x-1));
			s_q.push(c_date+1);
		}
		if(is_can_go(y,  x+1)==1){
			tomato[y][x+1] = 1;
			q.push(make_pair(y, x+1));
			s_q.push(c_date+1);
		}
		//logging2();
	}
	if(check_empty()==0){
		cout << -1 << endl;
	}else{
		cout << date << endl;
	}

	return 0;
}

