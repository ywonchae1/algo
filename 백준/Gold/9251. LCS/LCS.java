import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int[][] dp = new int[a.length()][b.length()];

        for(int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            for(int j = 0; j < b.length(); j++) {
                char c2 = b.charAt(j);

                if(i == 0 && j == 0) {
                    dp[i][j] = c1 == c2 ? 1 : 0;
                    continue;
                } else if(i == 0) {
                    dp[i][j] = c1 == c2 ? 1 : dp[i][j - 1];
                    continue;
                } else if(j == 0) {
                    dp[i][j] = c1 == c2 ? 1 : dp[i - 1][j];
                    continue;
                }

                if(c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        System.out.println(dp[a.length() - 1][b.length() - 1]);
    }
}