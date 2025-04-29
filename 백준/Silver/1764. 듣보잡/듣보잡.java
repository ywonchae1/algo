import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, Integer> arr = new HashMap<>();
        PriorityQueue<String> res = new PriorityQueue<>();

        for(int i = 0; i < N; i++) arr.put(sc.next(), 0);
        for(int i = 0; i < M; i++) {
            String str = sc.next();
            if(arr.get(str) != null) res.add(str);
        }

        System.out.println(res.size());
        while(!res.isEmpty()) System.out.println(res.poll());
    }
}