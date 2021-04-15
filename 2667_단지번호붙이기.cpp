#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int road[25][25];
bool visited[25][25];
int n;
int dan[625];
void DFS(int row,int col);
int cnt = 0;
int main(){
	scanf("%d",&n);
	for (int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            scanf("%1d",&road[i][j]);
        }
    }

	int size = 0;
	for (int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
        	if(visited[i][j]==false && road[i][j]==1){
        		cnt = 0;
				DFS(i,j);
				dan[size] = cnt;
				size+=1;
							
			}
        }
    }	
	printf("%d\n",size);
	sort(dan,dan+size);
	for (int i=0; i<size; i++){
		printf("%d\n",dan[i]);
		
	}
	return 0;
}

void DFS(int row,int col){
	if (road[row][col] == 1 && visited[row][col] == false){
		visited[row][col] = true;
		// ╩С
		cnt+=1;
		if (row-1>=0){
			DFS(row-1,col);
		} 
		// го 
		if (row+1<n){
			DFS(row+1,col);
		}
		//аб
		if (col-1>=0){
			DFS(row,col-1);
		} 
		//©Л 
		if (col+1<n){
			DFS(row,col+1);
		}
	}
	
} 
