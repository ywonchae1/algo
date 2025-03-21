import java.util.*;

class Solution {
    static final int INF = 100000;
    public int solution(int[][] info, int n, int m) {
        int answer = INF;
        int[][] dp = new int[info.length + 1][m];
        for(int i = 0; i <= info.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        
        for(int i = 1; i <= info.length; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            
            for(int j = 0; j < m; j++) {
                // a 선택
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                
                // b 선택
                if(j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }
        return answer >= n ? -1 : answer;
    }
}