import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static int[][] v;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[M][N];
        v = new int[M][N];

        for(int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int nx = sc.nextInt();
            int ny = sc.nextInt();

            // 색칠한다
            for(int j = M - ny; j < M - y; j++) {
                for(int k = x; k < nx; k++) {
                    map[j][k] = 1;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 || v[i][j] == 1) continue;
                pq.add(bfs(i, j));
            }
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        v[x][y] = 1;
        int size = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + d[i][0];
                int ny = p.y + d[i][1];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N
                        || v[nx][ny] == 1 || map[nx][ny] == 1)
                    continue;

                v[nx][ny] = 1;
                size++;
                q.add(new Point(nx, ny));
            }
        }

        return size;
    }

    static void printMap(int[][] map) {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}