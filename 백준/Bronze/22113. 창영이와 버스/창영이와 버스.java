import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] route = new int[M];
        for(int i = 0; i < M; i++) route[i] = sc.nextInt() - 1;
        
        int[][] cost = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        int total = 0;
        
        for(int i = 0; i < M - 1; i++) {
            total += cost[route[i]][route[i + 1]];
        }
        
        System.out.println(total);
    }
}