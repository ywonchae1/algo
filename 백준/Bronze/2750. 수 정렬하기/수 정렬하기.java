import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) pq.add(sc.nextInt());
        
        for(int i = 0; i < N; i++) System.out.println(pq.poll());
    }
}