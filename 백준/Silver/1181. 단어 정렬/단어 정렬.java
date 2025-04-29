import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) set.add(sc.next());

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        pq.addAll(set);

        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}