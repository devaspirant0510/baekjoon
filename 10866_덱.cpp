#include <iostream>
#include <deque>
#include <cstring>
#include <stdlib.h>
using namespace std;

int main(){
    deque<int> dq;
    int n;
    cin >> n;
    char input[20];
    int num;
    for (int i =0 ; i<n; i++ ){

        cin >> input;

        if (strcmp(input,"push_back")==0){
            cin >> num;
            dq.push_back(num);

        }
        if (strcmp(input,"push_front")==0){
            cin >> num;
            dq.push_front(num);

        }
        else if (strcmp(input,"size")==0){
            cout << dq.size() << endl;
        }
        else if (strcmp(input,"empty")==0){
            cout << dq.empty() << endl;
        }
        else if (strcmp(input,"front")==0){
            if (dq.empty()){
                cout << "-1" << endl;
            }
            else{
                cout << dq.front() << endl;
            }
        }
        else if (strcmp(input,"back")==0){
            if (dq.empty()){
                cout << "-1" << endl;
            }
            else{
                cout << dq.back() << endl;
            }
        }
        else if (strcmp(input,"pop_front")==0){
            if (dq.empty()){
                cout << "-1" << endl;

            }
            else{
                cout << dq.front()<<endl;
                dq.pop_front();
            }

        }
        else if (strcmp(input,"pop_back")==0){
            if(dq.empty()){
                cout<< "-1" << endl;

            }
            else{
                cout << dq.back() << endl;
                dq.pop_back();

            }
        }

    }


    return 0;
}

