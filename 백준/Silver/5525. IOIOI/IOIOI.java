import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String S = sc.next();
        int answer = 0;
        int cnt = 0;
        
        int i = 0;
        while(i < M - 2) {
            String str = S.substring(i, i + 3);
            if(str.equals("IOI")) {
                cnt++;
                i += 2;
                
                if(cnt == N) {
                    answer++;
                    cnt--;
                }
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(answer);
    }
}