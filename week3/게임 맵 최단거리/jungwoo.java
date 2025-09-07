import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        Deque<Coordinate> deque = new ArrayDeque<>();

        deque.offerLast(new Coordinate(0,0,1));
        visited[0][0] = true;

        while(!deque.isEmpty()){
            Coordinate currentPos = deque.pollFirst();
            int x = currentPos.getX();
            int y = currentPos.getY();
            if(x == maps.length-1 && y == maps[0].length-1){
                return currentPos.getCnt();
            }

            if(x == maps.length-1 && y == maps[0].length-1){
                return currentPos.getCnt();
            }

            for(int i = 0; i < direction.length; i++){
                int nextX = x - direction[i][0];
                int nextY = y - direction[i][1];
                if(((nextX >= 0 && nextY >= 0) && (nextX < maps.length && nextY < maps[0].length)) && !visited[nextX][nextY] && maps[nextX][nextY]==1){
                    deque.offerLast(new Coordinate(nextX, nextY, currentPos.getCnt()+1));
                    visited[nextX][nextY] = true;
                }

            }
        }
        return -1;

    }

    class Coordinate {
        int x;
        int y;
        int cnt;

        Coordinate(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        int getX() {
            return x;
        }
        int getY() {
            return y;
        }
        int getCnt() {
            return cnt;
        }
    }
}