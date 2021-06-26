
#include <iostream>

using namespace std;

int main(void)
{
    int arr[50][2];
    int score[50] = { 0, };
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i][0] >> arr[i][1];

    }
    for (int i = 0; i < n; i++) {
        score[i] = 1;
        for (int j = 0; j < n; j++) {
            if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                score[i] += 1;
            }

        }
    }
    for (int i = 0; i < n; i++) {
        cout << score[i] << " ";
    }
    return 0;
}


