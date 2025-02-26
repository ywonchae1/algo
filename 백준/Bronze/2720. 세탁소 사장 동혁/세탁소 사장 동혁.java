import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int money = sc.nextInt();
            int q = money / 25;
            int d = money % 25 / 10;
            int n = money % 25 % 10 / 5;
            int p = money % 25 % 10 % 5 / 1;
            
            System.out.printf("%d %d %d %d\n", q, d, n, p);
        }
    }
}