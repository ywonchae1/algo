import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[2][1000];

        for(int i = 0; i < N; i++) {
            arr[0][i] = sc.nextInt();
            
            if(i == 0) {
                arr[1][i] = 1;
            } else {
                int max = 0;
                for(int j = 0; j < i; j++) {
                    if(arr[0][j] < arr[0][i]) {
                        max = Math.max(max, arr[1][j]);
                    }
                }
                
                arr[1][i] = max + 1;
            }
        }
        
        int answer = 0;
        for(int i = 0; i < N; i++) answer = Math.max(answer, arr[1][i]);
        System.out.println(answer);
    }
}