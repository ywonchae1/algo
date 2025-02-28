import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        
        long res = A * B * C;
        String str = res + "";
        
        int[] arr = new int[10];
        
        for(int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - '0']++;
        
        for(int i = 0; i < 10; i++)
            System.out.println(arr[i]);
    }
}