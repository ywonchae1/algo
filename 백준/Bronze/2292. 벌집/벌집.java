import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int i = 1;
        int count = 1;
        while(count < N) {
            count += 6 * i++;
        }
        
        System.out.println(i);
    }
}