import java.util.*;

public class Main {
    static int[][] house = new int[17][17];
    static int count = 0;
    static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        dfs(1, 2, 0);

        System.out.println(count);
    }

    static void dfs(int x, int y, int status) {
        if(x == N && y == N) {
            count++;
            return;
        }

        if(status == 0) {
            // 가로 상태
            if(check(x, y + 1))
                dfs(x, y + 1, status);
            if(check(x, y + 1) && check(x + 1, y + 1) && check(x + 1, y))
                dfs(x + 1, y + 1, 2);
        } else if(status == 1) {
            // 세로 상태
            if(check(x + 1, y))
                dfs(x + 1, y, status);
            if(check(x, y + 1) && check(x + 1, y + 1) && check(x + 1, y))
                dfs(x + 1, y + 1, 2);
        } else if(status == 2) {
            // 대각선 상태
            if(check(x, y + 1))
                dfs(x, y + 1, 0);
            if(check(x + 1, y))
                dfs(x + 1, y, 1);
            if(check(x, y + 1) && check(x + 1, y + 1) && check(x + 1, y))
                dfs(x + 1, y + 1, status);
        }
    }

    static boolean check(int x, int y) {
        if(x < 0 || x > N || y < 0 || y > N) return false;

        if(house[x][y] != 0) return false;

        return true;
    }
}