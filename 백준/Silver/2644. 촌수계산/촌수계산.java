import java.util.*;

public class Main {
    static int n, m;
    static int p1, p2;
    static ArrayList<Integer>[] arr;
    static int[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new ArrayList[n + 1];
        v = new int[n + 1];
        for(int i = 0; i < n + 1; i++) arr[i] = new ArrayList<>();

        p1 = sc.nextInt();
        p2 = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x].add(y);
            arr[y].add(x);
        }

        System.out.println(bfs());
    }

    static class Pair {
        int p;
        int cnt;

        Pair(int p, int cnt) {
            this.p = p;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(p1, 0));
        v[p1] = 1;

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int np : arr[p.p]) {
                if(np == p2) return p.cnt + 1;

                if(v[np] == 1) continue;
                v[np] = 1;
                q.add(new Pair(np, p.cnt + 1));
            }
        }

        return -1;
    }
}