#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;

int maze[101][101];
int M,N;
bool check_pos(int y,int x){
    if (x<0 | y<0| x>=N | y>=M){
        return false;
    }
    if (maze[y][x]==0){
        return false;
    }
    return true;
}
int main(){
    scanf("%d%d",&M,&N);
    for (int i = 0; i<M; i++){
        for(int j = 0; j<N; j++){
            scanf("%1d",&maze[i][j]);
        }
    }
//	for (int i = 0; i<M; i++){
//		for(int j = 0; j<N; j++){
//			printf("%d",maze[i][j]);
//		}
//	}

    queue<int> qx,qy,s;
    qx.push(0);
    qy.push(0);
    s.push(1);
    int cx = qx.front();
    int cy = qy.front();
    int cs;
    while (!qx.empty()){
        cx = qx.front();
        cy = qy.front();
        cs = s.front();
        qx.pop();
        qy.pop();
        s.pop();
        if(cy==M-1 && cx==N-1){
            printf("%d",cs);
            break;
        }


        if (maze[cy][cx]==0){
            continue;
        }
        maze[cy][cx] = 0;
        if (check_pos(cy-1,cx)){
            qy.push(cy-1);
            qx.push(cx);
            s.push(cs+1);
        }
        if (check_pos(cy+1,cx)){
            qy.push(cy+1);
            qx.push(cx);
            s.push(cs+1);
        }
        if (check_pos(cy,cx+1)){
            qy.push(cy);
            qx.push(cx+1);
            s.push(cs+1);
        }
        if (check_pos(cy,cx-1)){
            qy.push(cy);
            qx.push(cx-1);
            s.push(cs+1);
        }
    }

    return 0;
}

