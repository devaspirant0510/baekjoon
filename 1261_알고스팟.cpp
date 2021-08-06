#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;

// N 은 X 축 M 은 Y 축
int N, M;
// 벽 부순 횟수
int breakCount = 0;
// 입력받는 배열
int board[101][101];
// 기록할 배열
int cBoard[101][101];


typedef struct {
    int x;
    int y;
} Direction;
Direction dir[4] = { {0,1},{0,-1},{1,0},{-1,0} };


void input();
void logBoard();
void logCBoard();
void solve();
bool isMove(int x, int y);

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cout.tie(NULL);
    input();
    solve();

}
void solve() {
    queue<pair<int, int>> que;
    que.push({ 0,0, });
    cBoard[0][0] = 0;

    while (!que.empty()) {
        int x = que.front().first;
        int y = que.front().second;
        //breakCount = que.front().second;
        //logQueue(que);

        que.pop();

        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i].x;
            int dy = y + dir[i].y;
            if (dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
            if (board[dx][dy] == 1) {
                if (cBoard[dx][dy] > cBoard[x][y] + 1) {
                    cBoard[dx][dy] = cBoard[x][y] + 1;
                    que.push({ dx,dy });
                }
            }
            else if (board[dx][dy] == 0) {
                if (cBoard[dx][dy] > cBoard[x][y]) {
                    cBoard[dx][dy] = cBoard[x][y];
                    que.push({ dx,dy });
                }
            }
        }
    }
    cout << cBoard[M - 1][N - 1];
}
bool isMove(int x, int y) {
    if (0 <= x && x < N && 0 <= y && y < M) {
        return true;
    }
    else {
        return false;
    }
}
void input() {
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        string Inp;
        cin >> Inp;
        for (int j = 0; j < Inp.length(); j++)
        {
            board[i][j] = Inp[j] - '0';
            cBoard[i][j] = 2147483647;
        }
    }


}
void logBoard() {
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cout << board[i][j] << "  ";
        }
        cout << endl;
    }

}
void logCBoard() {
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cout << cBoard[j][i] << "  ";
        }
        cout << endl;
    }
}
