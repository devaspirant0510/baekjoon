#include <iostream>

using namespace std;

char star[3000][3000];

void init(){
    for(int i =0; i<3000; i++){
        for (int j=0; j<3000; j++){
            star[i][j] = ' ';
        }
    }
}
void makeStar(int a, int b, int c){
    if (a==1){
        star[b][c]='*';
        return;
    }
    int div = a/3;
    for (int i=0; i<3; i++){
        for (int j=0; j<3; j++){
            if (i==1 && j==1){
                continue;
            }
            makeStar(div,b+(div*i),c+(div*j));
        }
    }
}
int main(){
    init();

    int n;
    cin>>n;
    makeStar(n,0,0);
    int sq = n*n;
    for(int i=0; i<n; i++){
        for (int j=0; j<n; j++){
            cout<<star[i][j];
        }
        cout << endl;
    }



    return 0;
}
