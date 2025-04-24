import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 0호출, 1호출 횟수 저장
        int[][] dp = new int[2][41];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = 1;
        
        int T = sc.nextInt();
        
        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            
            for(int i = 2; i <= N; i++) {
                if(dp[0][i] != 0) continue; // 이미 계산됨
                // 0호출 횟수 채우기
                dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
                // 1호출 횟수 채우기
                dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
            }
            
            System.out.printf("%d %d\n", dp[0][N], dp[1][N]);
        }
    }
}