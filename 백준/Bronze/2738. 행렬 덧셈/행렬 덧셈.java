import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] arr1 = new int[100][100];
        
        for(int k = 0; k < 2; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int num = sc.nextInt();
                    arr1[i][j] += num;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}