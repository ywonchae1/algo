import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] temp;
    static int[][] v;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        temp = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] > 0) temp[i][j] = 1; // 빙하 위치 기억
            }
        }

        int year = 0;
        while(true) {
            v = new int[N][M];
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(temp[i][j] == 1 && v[i][j] == 0) {
                        cnt++;
                        if(cnt > 1) {
                            System.out.println(year);
                            return;
                        }
                        bfs(i, j);
                    }
                }
            }
            if(cnt == 0) {
                System.out.println(0);
                return;
            }

            bfs2();
            year++;
        }
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

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + d[i][0];
                int ny = p.y + d[i][1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M
                        || v[nx][ny] == 1 || temp[nx][ny] == 0) continue;

                v[nx][ny] = 1;
                q.add(new Point(nx, ny));
            }
        }
    }

    static void bfs2() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + d[k][0];
                        int ny = j + d[k][1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M
                                || map[nx][ny] > 0 || temp[nx][ny] == 1) continue;

                        map[i][j] = Math.max(map[i][j] - 1, 0);
                    }
                    if (map[i][j] == 0) q.add(new Point(i, j));
                }
            }
        }

        // 빙하 없어짐 표시
        while(!q.isEmpty()) {
            Point p = q.poll();
            temp[p.x][p.y] = 0;
        }
    }
}
