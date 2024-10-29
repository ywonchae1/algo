import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxnum = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int num = sc.nextInt();
                if(num > maxnum) {
                    maxnum = num;
                    x = i; y = j;
                }
            }
        }
        System.out.println(maxnum);
        System.out.printf("%d %d", x + 1, y + 1);
    }
}