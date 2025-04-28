import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextInt();
        long B = sc.nextInt();

        int cnt = 1;
        while(A <= B) {
            if(A == B) {
                System.out.println(cnt);
                return;
            }

            if(B % 2 == 0) {
                B /= 2;
                cnt++;
            } else if(B % 10 == 1) {
                B = (B - 1) / 10;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(-1);
    }
}