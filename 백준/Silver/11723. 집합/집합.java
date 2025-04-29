import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int S = 0;

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String calc = st.nextToken();

            if(calc.equals("all")) {
                S = (1 << 21) - 1;
                continue;
            } else if(calc.equals("empty")) {
                S = 0;
                continue;
            }

            int val = Integer.parseInt(st.nextToken());

            switch(calc) {
                case "add":
                    S |= (1 << val);
                    break;
                case "remove":
                    S &= ~(1 << val);
                    break;
                case "check":
                    sb.append((S & (1 << val)) == 0 ? 0 : 1).append('\n');
                    break;
                case "toggle":
                    S ^= (1 << val);
                    break;
            }
        }

        System.out.println(sb);
    }
}