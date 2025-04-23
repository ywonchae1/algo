import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[11];
        int[] adder = new int[11];
        int[] addadder = new int[11];
        int[] v = new int[11];

        dp[0] = 1;
        addadder[0] = 1;
        addadder[1] = 1;
        addadder[2] = 3;
        addadder[3] = addadder[0] + addadder[1] + addadder[2];
        adder[0] = 1;
        for(int i = 1; i < 4; i++) {
            adder[i] = adder[i - 1] + addadder[i - 1];
        }

        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();

            for(int i = 1; i < N; i++) {
                if(v[i] == 1) continue;
                v[i] = 1;
                if(i > 3) {
                    addadder[i] = addadder[i - 3] + addadder[i - 2] + addadder[i - 1];
                    adder[i] = adder[i - 1] + addadder[i - 1];
                }
                dp[i] = dp[i - 1] + adder[i - 1];
            }

            System.out.println(dp[N - 1]);
        }
    }
}