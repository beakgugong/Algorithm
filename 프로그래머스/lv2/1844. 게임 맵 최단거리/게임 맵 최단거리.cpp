#include<bits/stdc++.h>
using namespace std;

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    int dx[4] = {1,0,-1,0};
    int dy[4] = {0,1,0,-1};
    queue<pair<int,int>> q;
    int n = maps.size();
    int m = maps[0].size();
    q.push({0,0});
    
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        
        if(x == n-1 && y == m-1) return maps[x][y];
        
        
        for(int r=0; r<4; r++) {
            int nx = x + dx[r];
            int ny = y + dy[r];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(maps[nx][ny] != 1) continue;
            
            maps[nx][ny] = maps[x][y] + 1;
            q.push({nx,ny});
        }
    }
    return -1;
}