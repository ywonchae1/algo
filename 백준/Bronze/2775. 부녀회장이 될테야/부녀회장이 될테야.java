import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int t = 0; t < T; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            
            int[][] apt = new int[k + 1][n + 1];
            
            for(int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }
            
            for(int i = 1; i <= k; i++) {
                for(int j = 1; j <= n; j++) {
                    for(int m = 1; m <= j; m++) {
                        apt[i][j] += apt[i - 1][m];
                    }
                }
            }
            
            System.out.println(apt[k][n]);
        }
    }
}