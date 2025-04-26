import java.util.*;
import java.awt.*;

public class Main {
    static int N, M; // 가로, 세로
    static int[][] map;
    static int walls = 3;
    static int[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int maxSafe = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // i, j를 선택한다
                if(map[i][j] != 0) continue;
                map[i][j] = 1;

                for(int ii = 0; ii < N; ii++) {
                    for(int jj = 0; jj < M; jj++) {
                        // ii, jj를 선택한다
                        if(map[ii][jj] != 0) continue;
                        map[ii][jj] = 1;

                        for(int iii = 0; iii < N; iii++) {
                            for(int jjj = 0; jjj < M; jjj++) {
                                // iii, jjj를 선택한다
                                if(map[iii][jjj] != 0) continue;
                                map[iii][jjj] = 1;

                                // 3개의 벽이 선택되었고 바이러스를 확산시켜본다
                                int[][] nmap = new int[N][M];
                                for(int k = 0; k < N; k++) {
                                    if (M >= 0)
                                        System.arraycopy(map[k], 0, nmap[k], 0, M);
                                }
                                bfsVirus(nmap);

                                // 안전지역의 개수를 체크하고 최대값을 갱신한다
                                int safe = 0;
                                for(int k = 0; k < N; k++) {
                                    for(int l = 0; l < M; l++) {
                                        if(nmap[k][l] == 0) safe++;
                                    }
                                }
                                maxSafe = Math.max(maxSafe, safe);

                                // iii, jjj의 선택을 취소한다
                                map[iii][jjj] = 0;
                            }
                        }

                        // ii, jj의 선택을 취소한다
                        map[ii][jj] = 0;
                    }
                }

                // i, j의 선택을 취소한다
                map[i][j] = 0;
            }
        }

        System.out.println(maxSafe);
    }

    static void bfsVirus(int[][] nmap) {
        Queue<Point> q = new LinkedList<>();

        int[][] v = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(nmap[i][j] == 2) {
                    q.add(new Point(i, j));
                    v[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = (int) (p.getX() + d[i][0]);
                int ny = (int) (p.getY() + d[i][1]);

                if(nx < 0 || nx >= N || ny < 0 || ny >= M
                        || v[nx][ny] == 1 || nmap[nx][ny] != 0) continue;

                nmap[nx][ny] = 2; // 바이러스 확산
                q.add(new Point(nx, ny));
                v[nx][ny] = 1;
            }
        }
    }

    static void printMap(int[][] map) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}