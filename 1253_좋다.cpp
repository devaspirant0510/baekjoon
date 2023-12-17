#include <iostream>
#include <algorithm>

#define MAX_SIZE 2001
using namespace std;


int main(){
	int N;
	cin >> N;
	int arr[MAX_SIZE];
	int start_point[MAX_SIZE];
	int end_point[MAX_SIZE];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + N);
	int s_i = 0;
	int e_j = N-1;
	int count = 0;
	for (int i = 0; i < N; i++) {
		s_i = 0;
		e_j = N-1;
		for (int j = 0; j < N; j++) {
			int k = arr[i];
			if (s_i>=e_j) {
				break;
			}
			if (arr[s_i] + arr[e_j] == k) {
				if (s_i != i && e_j != i) {
					count++;
					break;
				}
				else if (s_i == i) {
					s_i++;
				}
				else if (e_j == i) {
					e_j--;
				}
			}
			else if (arr[s_i] + arr[e_j] < k) {
				s_i++;
			}
			else if (arr[s_i] + arr[e_j] > k) {
				e_j--;
			}
		}
	}
	cout << count;
	return 0;
}
