import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int n = 3 + 2 * (N - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) sb.append('I');
            else sb.append('O');
        }
        int M = sc.nextInt();

        String S = sc.next();
        int answer = 0;

        for(int i = 0; i < M - n + 1; i++) {
            if(S.charAt(i) == 'O') continue;
            String str = S.substring(i, i + n);
            if(str.contentEquals(sb)) answer++;
        }

        System.out.println(answer);
    }
}