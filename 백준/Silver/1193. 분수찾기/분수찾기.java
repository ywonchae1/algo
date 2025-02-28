import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int idx = 0;
        while(cnt < N) {
            cnt += ++idx;
        }
        int up, down;
        if(cnt == N) {
            if(idx % 2 == 0) {
                up = idx;
                down = 1;
            } else {
                up = 1;
                down = idx;
            }
        } else {
            cnt -= idx;
            if(idx % 2 == 0) {
                up = 1 + (N - cnt - 1);
                down = idx - (N - cnt - 1);
            } else {
                up = idx - (N - cnt - 1);
                down = 1 + (N - cnt - 1);
            }
        }
        System.out.printf("%d/%d", up, down);
    }
}