import java.util.*;

class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        return bfs(0, 0, maps, n, m);
    }

    private int bfs(int x, int y, int[][] map, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return (map[n - 1][m - 1] != 1) ? map[n - 1][m - 1] : -1;
    }
}