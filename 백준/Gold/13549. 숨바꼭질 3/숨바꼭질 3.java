import java.util.*;

public class Main {
    static class Point {
        int v;
        int cnt;

        Point(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }

    static int[] dp = new int[100001];

    static void bfs(int n, int k) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(n, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(dp[p.v] <= p.cnt) continue;

            dp[p.v] = Math.min(dp[p.v], p.cnt);

            if(p.v == k) continue;

            if(p.v - 1 >= 0 && p.v - 1 < dp.length)
                q.add(new Point(p.v - 1, p.cnt + 1));
            if(p.v + 1 < dp.length)
                q.add(new Point(p.v + 1, p.cnt + 1));
            if(p.v * 2 >= 0 && p.v * 2 < dp.length)
                q.add(new Point(p.v * 2, p.cnt));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Arrays.fill(dp, Integer.MAX_VALUE);

        bfs(N, K);

        System.out.println(dp[K]);
    }
}