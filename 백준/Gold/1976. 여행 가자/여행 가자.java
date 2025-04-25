import java.util.*;

public class Main {
    static int[] plan = new int[1000];
    static int[] visited = new int[201];
    static int[][] map = new int[201][201];
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < M; i++) {
            plan[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            Arrays.fill(visited, 0);

            bfs(i);

            boolean flag = true;
            for(int j = 0; j < M; j++) {
                if(visited[plan[j] - 1] == 0) {
                    flag = false;
                }
            }

            if(flag) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        visited[start - 1] = 1;

        while(!q.isEmpty()) {
            int p = q.poll();

            for(int i = 0; i < N; i++) {
                // 방문하지 않았고 다리가 연결되어 있다면
                if(visited[i] == 0 && map[p - 1][i] == 1) {
                    q.add(i + 1);
                    visited[i] = 1;
                }
            }
        }
    }
}