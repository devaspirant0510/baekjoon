#include <iostream>

#define MAX 100000031
using namespace std;

int N;
int Arr[101];
// ����,����, ����, ������
int cal[4];

int minResult=MAX, maxResult=-minResult;
void input();
void output();
void solve();
void DFS(int sum, int count,int plus, int minus, int multiple, int divide);


int main(void) {
	input();
	solve();
	output();

}
void input() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		scanf("%d", &Arr[i]);
	}
	for (int i = 0; i < 4; i++) {
		scanf("%d", &cal[i]);
	}
}
void solve() {
	DFS(Arr[0], 0,cal[0], cal[1], cal[2], cal[3]);
}
/*
* @params sum : ������
* @params count : ����Ƚ��
* @parmas plus, minus,multiple,divide : ���� ��Ģ���� ����
*/
void DFS(int sum, int count, int plus, int minus, int multiple, int divide) {
	if (count == N-1) {
		// �ּڰ�
		minResult = sum < minResult ? sum : minResult;
		// �ִ�
		maxResult = sum > maxResult ? sum : maxResult;
	}
	if (plus > 0) {
		DFS(sum + Arr[count+1], count + 1, plus - 1, minus, multiple, divide);
	}
	if (minus > 0) {
		DFS(sum - Arr[count+1], count + 1, plus, minus - 1, multiple, divide);
	}
	if (multiple > 0) {
		DFS(sum * Arr[count+1], count + 1, plus, minus, multiple - 1, divide);
	}
	if (divide > 0) {
		DFS(sum / Arr[count+1], count + 1, plus, minus, multiple, divide - 1);
	}
}
void output() {
	cout << maxResult << endl;
	cout << minResult << endl;
}

