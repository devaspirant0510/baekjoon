#include <iostream>

#include <cstring>

using namespace std;

char board[7000][7000];

string base_tri[3] = {

    "  *  ",                                        " * * ",

    "*****"

};

void draw(int N,int width,int height){

    if (N==3){

        board[height][width] = '*';

        board[height+1][width+1] = '*';

        board[height+1][width-1] = '*';

        for(int i=-2; i<3; i++){

            board[height+2][width+i] = '*';

        }

        /**

          for (int i=height; i <3+height; i++){//height

          for (int j=width; j < width+5; j++){//width

          board[i][j] = (char)base_tri[i-height][j-width];

          }                                           }*/

        return;

    }

    draw(N/2,width,height);

    draw(N/2,width - (N/2),height+N/2);

    draw(N/2,(N/2)+width,height+N/2);

}

void print(int N){

    for (int i=0; i<N*3; i++){

        for(int j=0; j<2*N*3+1; j++){

            cout << board[i][j];

        }

        cout << endl;

    }

}

void init_board(int N){

    for (int i=0; i<7000; i++){

        for(int j=0; j<7000; j++){                           board[i][j] = ' ';

        }

    }

}

int main(){

    int N ;



    cin >> N;

    init_board(N/3);

    draw(N,N-1,0);

    print(N/3);
    return 0;

}
