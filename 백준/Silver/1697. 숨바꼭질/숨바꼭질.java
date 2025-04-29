import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[200000];
        Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(p.n == K && arr[K] > p.cnt) {
                arr[K] = p.cnt;
                continue;
            }

            int np1 = p.n * 2;
            int np2 = p.n + 1;
            int np3 = p.n - 1;

            int ncnt = p.cnt + 1;

            if(np1 < arr.length && arr[np1] > ncnt) {
                arr[np1] = ncnt;
                q.add(new Point(np1, ncnt));
            }
            if(np2 < arr.length && arr[np2] > ncnt) {
                arr[np2] = ncnt;
                q.add(new Point(np2, ncnt));
            }
            if(np3 >= 0 && arr[np3] > ncnt) {
                arr[np3] = ncnt;
                q.add(new Point(np3, ncnt));
            }
        }

        System.out.println(arr[K]);
    }

    static class Point {
        int n;
        int cnt;

        Point(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}