import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] v;
    static int maxArea = 0;
    static int areaCnt = 0;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        v = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(v[i][j] == 1 || map[i][j] == 0) continue;
                bfs(i, j);
                areaCnt++;
            }
        }

        System.out.println(areaCnt);
        System.out.println(maxArea);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        v[x][y] = 1;
        int size = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + d[i][0];
                int ny = p.y + d[i][1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m
                        || v[nx][ny] == 1 || map[nx][ny] == 0) continue;

                q.add(new Point(nx, ny));
                v[nx][ny] = 1;
                size++;
            }
        }

        maxArea = Math.max(maxArea, size);
    }
}