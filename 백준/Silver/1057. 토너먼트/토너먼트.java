import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int round = 0;
        
        while(x != y) {
            x = x / 2 + x % 2;
            y = y / 2 + y % 2;
            round++;
        }
        
        System.out.println(round);
    }
}