import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == 1 && y == 1) {
                sb.append(1).append('\n');
                continue;
            }

            int lcmval = lcm(N, M);

            long cnt = x;
            while(cnt <= lcmval) {
                if((cnt - 1) % M + 1 == y) {
                    sb.append(cnt).append('\n');
                    break;
                }
                cnt += N;
            }

            if(cnt > lcmval) sb.append(-1).append('\n');
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        return a % b != 0 ? gcd(b, a % b) : b;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}