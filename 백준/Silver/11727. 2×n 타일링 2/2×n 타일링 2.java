import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] a = new int[1001];
        int[] d = new int[1001];

        for(int n = 0; n < N; n++) {
            if(n == 0) {
                a[n] = 1;
                d[n] = 2;
                continue;
            }

            a[n] = (a[n - 1] + d[n - 1]) % 10007;

            d[n] = 2 * a[n - 1];
        }

        System.out.println(a[N - 1]);
    }
}