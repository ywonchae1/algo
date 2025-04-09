import java.util.*;

public class Main {
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int maxDate = 0;
    static int M, N;
    static int[][] map = new int[1000][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        Queue<Dot> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) queue.add(new Dot(i, j));
            }
        }

        while(true) {
            int size = queue.size();

            while (size-- > 0) {
                Dot dot = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = dot.x + d[i][0];
                    int ny = dot.y + d[i][1];

                    // 범위 체크, 방문 체크
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M
                            || (map[nx][ny] != 0 && map[nx][ny] <= map[dot.x][dot.y] + 1)
                            || map[nx][ny] == -1)
                        continue;

                    if (map[nx][ny] == 0) map[nx][ny] = map[dot.x][dot.y] + 1;
                    else map[nx][ny] = Math.min(map[nx][ny], map[dot.x][dot.y] + 1);

                    queue.add(new Dot(nx, ny));
                }
            }
            if (queue.isEmpty()) break;
            maxDate++;
        }

        // 모두 익었는지 확인
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(maxDate);
    }

    public static class Dot {
        public int x;
        public int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}