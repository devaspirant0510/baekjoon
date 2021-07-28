#include <iostream>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;
int board[1001][1001] = { 0, };
int cBoard[1001][1001][2] = { 0, }; // 벽뚫기 여부

typedef struct{
	int y;
	int x;
} dxy;


// 왼쪽 → 오른쪽 → 위쪽 → 아래쪽
dxy movePos[4] = { {1,0},{0,1},{-1,0},{0,-1} };
int N, M;

void input();
void output();
int solution();
void outca();
bool check(int y, int x);
// N 은 y 축 M 은 x 축
// 0은 갈수있는 길 1은 벽
int main(void) {
	input();
	cout << solution() << endl;
	//output();
}
void input() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
}
int solution() {
	queue <pair<pair<int, int>, int> > que; // y x 좌표 벽뚫기 여부
	que.push({ {0,0},1 });
	cBoard[0][0][1] = 1; // 초기값은 벽을 뚫을수 있는 기회가 있기때문에 0,0,1 
	while (!que.empty()) {
		int y = que.front().first.first;
		int x = que.front().first.second;
		int block = que.front().second;
		que.pop();
		// 종료 조건 : 현재 내위치가 (M-1,N-1) 에 있을때
		if ( y == N-1 && x==M-1) {
			return cBoard[y][x][block];
		}
		for (int i = 0; i < 4; i++) {
			int goY = y+movePos[i].y;
			int goX = x+movePos[i].x;

			// 움직일수있는지 체크 (벽이 있는지 체크는 안함)
			if (check(goY, goX)) {
				// 벽이 있고, 벽을 한번도 부수지 않았을시 
				if (board[goY][goX] == 1 && block) {
					// 방문처리
					cBoard[goY][goX][block - 1] = cBoard[y][x][block] + 1;
					que.push({ {goY,goX},block-1 });
				}
				// 갈수 있는길이고, 방문처리가 안된곳
				else if (board[goY][goX] == 0 && cBoard[goY][goX][block]==0) {
					cBoard[goY][goX][block] = cBoard[y][x][block]+1;
					que.push({ {goY,goX},block });
				}
			}
		}
	}
	return -1;
}
void output() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << board[i][j];
		}
		cout << endl;
	}
}
void outca() {
	cout << endl;
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				cout << cBoard[j][k][i];
			}
			cout << endl;
		}
		cout << endl;
	}
}

bool check(int y, int x) {
	return (y >= 0 && y <N && x >= 0 && x < M);
}
