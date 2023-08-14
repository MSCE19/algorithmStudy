import java.util.*;

class Solution {
    // 지나온 길은 2로 표시 
    public int solution(int[][] maps) { 
        int min = 1 ;        // 상대 진영까지의 최소 거리
        int x=0, y=0;       // 현재 위치의 좌표, 기본 위치는 [0][0]으로 표기
        
        min = four_sides(maps, 0,0, 1);
        if(min <= maps.length * maps[0].length)
            return min;
        else 
            return -1;
    }
    public int four_sides(int[][] maps, int x, int y, int distance){
        int n = maps.length;
        int m = maps[0].length;
        int[] min = {n*m+1, n*m+1, n*m+1, n*m+1};
        
        if(x == n-1 && y == m-1)
            
            return distance;
        
        if( !(can_go(maps, x-1, y)) && !(can_go(maps, x, y+1)) && !(can_go(maps, x+1, y)) 
            && !(can_go(maps, x, y-1))){ //사방 다 못가면
            return n*m +1;
        }
        
        maps[x][y] = 2;
        
        if(can_go(maps, x-1, y))   // 위
            min[0] = four_sides(maps, x-1, y, distance + 1);
        if(can_go(maps, x, y+1))   // 오른쪽
            min[1] = four_sides(maps, x, y+1, distance + 1);
        if(can_go(maps, x+1, y))   // 아래
            min[2] = four_sides(maps, x+1, y, distance + 1);
        if(can_go(maps, x, y-1))   // 왼쪽
            min[3] = four_sides(maps, x, y-1, distance +1);
        
        maps[x][y] = 1;
        
        return Math.min(Math.min(min[0],min[1]), Math.min(min[2], min[3]));
    }
    // 1 반환시 갈 수 있음. 0 반환 시 못 가. 
    public boolean can_go(int[][] maps, int x, int y){
        int n = maps.length;
        int m = maps[0].length;
        if( !( (0<=x && x<n) && (0<=y && y<m) ) ) //지도를 벗어나면 -1 반환, x좌표가 세로
            return false;
        if(maps[x][y] != 1) //0(벽) 또는 2(지나온 길)이면
            return false;
        return true;
    }
}