import java.util.*;

public class Main {
    public static int x;
    public static int y;
    public static int round = 1;
    
    public static void dfs() {
        if(x < y && x % 2 != 0 && y - x == 1) return;
        else if(y < x && y % 2 != 0 && x - y == 1) return;
        else if(x <= 0 || y <= 0) {
            round = -1;
            return;
        }
        
        if(x % 2 == 0) x = x / 2;
        else x = x / 2 + 1;
        
        if(y % 2 == 0) y = y / 2;
        else y = y / 2 + 1;
        
        round++;
        
        dfs();
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        
        dfs();
        
        System.out.println(round);
    }
}