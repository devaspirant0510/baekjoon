#include <iostream>

using namespace std;

int coin_value[10] = {0};
int main(){
    int n,coin,coin_count=0;
    cin>>n>>coin;
    for(int i =0 ; i<n; i++){
        cin >> coin_value[i];
    }
    for (int i =n-1; i>-1; i--){
        if (coin>=coin_value[i]){
            int div = coin/coin_value[i];
            coin_count+=div;
            coin=coin%coin_value[i];
        }
    }
    cout << coin_count;

    return 0;
}


