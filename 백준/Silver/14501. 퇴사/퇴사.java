import java.util.*;

public class Main {
    static int N, maxPay;
    static Work[] arr = new Work[15];
    static int[] dp = new int[15];

    static class Work {
        int t;
        int p;

        Work(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        maxPay = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = new Work(sc.nextInt(), sc.nextInt());
        }

        Arrays.fill(dp, 0);

        // dfs 진행
        for(int i = 0; i < N; i++) {
            // i번째 일을 시작하는 것이 이득이라면 dfs 진행
            // i번째 일을 기한 내에 진행할 수 있다면 dfs 진행
            if(dp[i] < arr[i].p && i + arr[i].t - 1 < N) {
                dp[i] = arr[i].p;
                // i번째 일은 i + arr[i].t - 1일에 종료되고,
                // i + arr[i].t일에 다시 일을 시작할 수 있음
                dfs(i, i + arr[i].t);
            }
        }

        for(int i = 0; i < N; i++) {
            maxPay = Math.max(maxPay, dp[i]);
        }

        System.out.println(maxPay);
    }

    public static void dfs(int i, int ni) {
        // 다음 위치에서 일할 수 있는지 확인
        // 다음 위치가 인덱스 범위 내에 있고,
        // 다음 위치의 일을 기한 내에 수행할 수 있다면 진행
        if(ni < N && ni + arr[ni].t - 1 < N) {
            dp[ni] = Math.max(dp[ni], dp[i] + arr[ni].p);
            dfs(ni, ni + arr[ni].t);
        }

        // 다음 위치에서 일하지 않고, 하루 뒤의 일부터 진행
        for(int k = 1; ni + k < N; k++) {
            int newNi = ni + k;
            // 하려는 일을 기한내에 끝낼 수 있다면 진행
            if(newNi + arr[newNi].t - 1 < N) {
                dp[newNi] = Math.max(dp[newNi], dp[i] + arr[newNi].p);
                dfs(newNi, newNi + arr[newNi].t);
            }
        }
    }
}