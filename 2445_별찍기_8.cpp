#include <iostream>

using namespace std;
int main() {
    int n;
    cin >> n;
    for(int i=0; i<n-1; i++){
        for(int j=0; j<i+1; j++){
            cout << "*";
        }
        for (int k=2*n-2; k>2*i; k-=1){
            cout << " ";

        }
        for(int l=0; l<i+1; l++){
            cout << "*";

        }
        cout << endl;
    }
    for(int i=0; i<n*2; i++){
        cout << "*";
    }
    cout <<endl;
    for (int i=0; i<n-1; i++){
        for (int j=n-1; j>i; j--){
            cout<<"*";
        }
        for (int k=0; k<=(2*(i))+1; k++){
            cout << " ";
        }
        for (int l=n-1; l>i; l--){
            cout<<"*";
        }
        cout << endl;
    }

    return 0;
}

