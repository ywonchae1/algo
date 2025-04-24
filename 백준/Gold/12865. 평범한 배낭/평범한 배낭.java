import java.util.*;

public class Main {
    static class Stuff {
        int W;
        int V;
        
        Stuff(int w, int v) {
            this.W = w;
            this.V = v;
        }
    }
    static List<Stuff> stuffList = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
            stuffList.add(new Stuff(sc.nextInt(), sc.nextInt()));
        }
        
        int[][] dp = new int[K + 1][N + 1];
        
        for(int i = 0; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                // j번째 물건 정보
                Stuff st = stuffList.get(j - 1);
                
                // 채울 수 있는 무게가 i일 때
                // j번째 물건까지 살펴봤을 때 최대 가치를 dp[i][j]에 저장
                
                if(i - st.W >= 0)
                    // j번째 물건을 담을 수 있다면
                    dp[i][j] = Math.max(dp[i - st.W][j - 1] + st.V, dp[i][j - 1]);
                else
                    // 그렇지 않다면 이전 값을 그대로 유지
                    dp[i][j] = dp[i][j - 1];
            }
        }
        
        System.out.println(dp[K][N]);
    }
}