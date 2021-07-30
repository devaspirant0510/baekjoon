#include <iostream>
#include <cstring>
#include <cstdio>
#include <queue>

#define MAX 1001

using namespace std;

int board[MAX][MAX];
int cBoard[MAX][MAX][2];

// N �� y�� M �� x ��
int N, M;

typedef struct {
	int y;
	int x;
} Direction;
Direction dir[4] = { {0,1},{0,-1},{1,0},{-1,0} };
void input();
void solution();
bool isMove(int y,int x);
void log();
void outca();


int main(void) {
	input();
	solution();
	return 0;
}
void input() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
}
void solution() {
	// {{y,x},���μ� ����(1�� �Ⱥμ� 0�� �μ�)
	queue<pair<Direction, int>> q;
	cBoard[0][0][1] = 1;
	q.push({ {0,0,},1 });

	while (!q.empty()) {
		int y = q.front().first.y;
		int x = q.front().first.x;
		int block = q.front().second;
		q.pop();
		if (y == N-1 && x == M-1) {
			cout << cBoard[y][x][block];
			return;
		}
		for (int i = 0; i < 4; i++) {
			int dx = dir[i].x + x;
			int dy = dir[i].y + y;
			if (isMove(dy, dx)) {
				if (block && board[dy][dx] == 1) {
					cBoard[dy][dx][block - 1] = cBoard[y][x][block] + 1;
					q.push({ {dy,dx},block - 1 });
					//outca();

				}if (cBoard[dy][dx][block]==0 && board[dy][dx] == 0) {
					cBoard[dy][dx][block] = cBoard[y][x][block] + 1;
					q.push({ {dy,dx},block });
					//outca();

				}

			}
		}
	}
	
	cout << -1;

}
bool isMove(int y,int x) {
	if (0 <= y && y < N && 0 <= x && x < M) {
		return true;
	}
	else {
		return false;
	}
}
void log() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << board[i][j] << "   ";
		}
		cout << endl;
	}


}
void outca() {
	cout << endl;
	for (int i = 0; i < 2; i++) {
		if (i == 0) {
			cout << "�� �μ� �迭" << endl;
		}
		else {
			cout << "�� �Ⱥμ� �迭" << endl;
		}
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				cout << cBoard[j][k][i];
			}
			cout << endl;
		}
		cout << endl;
	}
}

