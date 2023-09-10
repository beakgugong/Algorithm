import java.util.*;
class location {
    int x;
    int y;
    int[][] maps;
    public location(int x, int y, int[][] maps){
        this.x = x;
        this.y = y;
        this.maps = maps;
    }
    
}
class Solution {
    public int solution(int[][] maps) {
        Queue<location> que = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        
        int n = maps.length;
        int m = maps[0].length;
        que.add(new location(0,0,maps));
    
        while(!que.isEmpty()){
            
            for(int i=0; i<4; i++){
                int x = que.peek().x;
                int y = que.peek().y;
                if(x+dx[i]<0||y+dy[i]<0)
                    continue;
                if(x+dx[i]>n-1||y+dy[i]>m-1)
                    continue;
                if(maps[x+dx[i]][y+dy[i]]==1){
                    maps[x+dx[i]][y+dy[i]] =
                        maps[x][y]+1;
                    que.add(new location(x+dx[i],y+dy[i],maps));
                    
                }
            }
        que.poll(); 
        }
        
        int answer = maps[n-1][m-1];
        if(answer<=1)return -1;
        return answer;
    }
}