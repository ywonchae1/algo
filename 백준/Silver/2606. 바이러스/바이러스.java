import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i < 101; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }

        System.out.println(dfs(1) - 1);
    }

    static List<Integer>[] arr = new ArrayList[101];
    static int[] v = new int[101];

    static int dfs(int p) {
        if(v[p] == 1) return 0;

        v[p] = 1;
        int count = 0;
        for(int i = 0; i < arr[p].size(); i++) {
            if(v[arr[p].get(i)] == 1) continue;
            count += dfs(arr[p].get(i));
        }
        return count + 1;
    }
}