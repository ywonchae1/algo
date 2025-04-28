import java.util.*;
import java.awt.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];
        v = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                initV();
                if(dfs(i, j)) arr[i][j] = 1;
            }
        }

        printMap();
    }

    static void initV() {
        for(int i = 0; i < N; i++) {
            Arrays.fill(v[i], 0);
        }
    }

    static boolean dfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        v[x][y] = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();
            
            int nx = (int) p.getX();

            for(int i = 0; i < arr[nx].length; i++) {
                if(v[nx][i] == 1) continue;
                if(arr[nx][i] == 1 && i == y) return true;
                else if(arr[nx][i] == 1) {
                    v[nx][i] = 1;
                    q.add(new Point(i, 0));
                }
            }
        }

        return false;
    }

    static void printMap() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}