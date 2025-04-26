import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) arr[i] = new ArrayList<>();
        
        for(int i = 0; i < N - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            arr[x].add(y);
            arr[y].add(x);
        }
        
        // bfs
        int[] parent = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        parent[1] = 1;
        
        while(!q.isEmpty()) {
            int p = q.poll();
            
            for(int el : arr[p]) {
                if(parent[el] > 0) continue;
                
                parent[el] = p;
                q.add(el);
            }
        }
        
        for(int i = 2; i <= N; i++)
            System.out.println(parent[i]);
    }
}