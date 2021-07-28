#include <iostream>
#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;
int board[1001][1001] = { 0, };
int cBoard[1001][1001][2] = { 0, }; // ���ձ� ����

typedef struct{
	int y;
	int x;
} dxy;


// ���� �� ������ �� ���� �� �Ʒ���
dxy movePos[4] = { {1,0},{0,1},{-1,0},{0,-1} };
int N, M;

void input();
void output();
int solution();
void outca();
bool check(int y, int x);
// N �� y �� M �� x ��
// 0�� �����ִ� �� 1�� ��
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
	queue <pair<pair<int, int>, int> > que; // y x ��ǥ ���ձ� ����
	que.push({ {0,0},1 });
	cBoard[0][0][1] = 1; // �ʱⰪ�� ���� ������ �ִ� ��ȸ�� �ֱ⶧���� 0,0,1 
	while (!que.empty()) {
		int y = que.front().first.first;
		int x = que.front().first.second;
		int block = que.front().second;
		que.pop();
		// ���� ���� : ���� ����ġ�� (M-1,N-1) �� ������
		if ( y == N-1 && x==M-1) {
			return cBoard[y][x][block];
		}
		for (int i = 0; i < 4; i++) {
			int goY = y+movePos[i].y;
			int goX = x+movePos[i].x;

			// �����ϼ��ִ��� üũ (���� �ִ��� üũ�� ����)
			if (check(goY, goX)) {
				// ���� �ְ�, ���� �ѹ��� �μ��� �ʾ����� 
				if (board[goY][goX] == 1 && block) {
					// �湮ó��
					cBoard[goY][goX][block - 1] = cBoard[y][x][block] + 1;
					que.push({ {goY,goX},block-1 });
				}
				// ���� �ִ±��̰�, �湮ó���� �ȵȰ�
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
