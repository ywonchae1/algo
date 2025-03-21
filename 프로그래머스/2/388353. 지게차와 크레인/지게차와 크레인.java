import java.util.*;

class Solution {
    static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int cnt = 0;
    
    class Dot {
        int x;
        int y;
        
        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static Queue<Dot> q = new LinkedList<>();
    
    static int[][] v = new int[51][51];
    
    void sol1(char[][] sto, int n, int m, char req) {
        // 테두리 탐색
        // x가 0인 라인 탐색
        for(int i = 0; i < m; i++) {
            if(v[0][i] == 1) continue;
            if(sto[0][i] == req) {
                q.add(new Dot(0, i));
                v[0][i] = 1;
            } else if(sto[0][i] == '0') {
                dfs(sto, 0, i, n, m, req);
            }
        }
        // y가 0인 라인 탐색
        for(int i = 0; i < n; i++) {
            if(v[i][0] == 1) continue;
            if(sto[i][0] == req) {
                q.add(new Dot(i, 0));
                v[i][0] = 1;
            } else if(sto[i][0] == '0') {
                dfs(sto, i, 0, n, m, req);
            }
        }
        // x가 n인 라인 탐색
        for(int i = 0; i < m; i++) {
            if(v[n - 1][i] == 1) continue;
            if(sto[n - 1][i] == req) {
                q.add(new Dot(n - 1, i));
                v[n - 1][i] = 1;
            } else if(sto[n - 1][i] == '0') {
                dfs(sto, n - 1, i, n, m, req);
            }
        }
        // y가 m인 라인 탐색
        for(int i = 0; i < n; i++) {
            if(v[i][m - 1] == 1) continue;
            if(sto[i][m - 1] == req) {
                q.add(new Dot(i, m - 1));
                v[i][m - 1] = 1;
            } else if(sto[i][m - 1] == '0') {
                dfs(sto, i, m - 1, n, m, req);
            }
        }
    }
    
    void sol2(char[][] sto, int n, int m, char req) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 이 위치의 알파벳이 일치하지 않으면 넘어감
                if(sto[i][j] != req) continue;
                
                // 일치하면 제거 리스트에 추가
                q.add(new Dot(i, j));
            }
        }
    }
    
    void dfs(char[][] sto, int x, int y, int n, int m, char req) {
        Queue<Dot> nq = new LinkedList<>();
        nq.add(new Dot(x, y));
        v[x][y] = 1;
        
        while(!nq.isEmpty()) {
            Dot dot = nq.poll();
            
            for(int i = 0; i < 4; i++) {
                int dx = d[i][0];
                int dy = d[i][1];
                int nx = dot.x + dx;
                int ny = dot.y + dy;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny] == 1)
                    continue;
                
                v[nx][ny] = 1;
                
                if(sto[nx][ny] == req) {
                    q.add(new Dot(nx, ny));
                } else if(sto[nx][ny] == '0') {
                    nq.add(new Dot(nx, ny));
                }
            }
        }
    }
    
    void updateMap(char[][] sto) {
        while(!q.isEmpty()) {
            Dot dot = q.poll();
            sto[dot.x][dot.y] = '0';
            cnt++;
        }
    }
    
    void printMap(char[][] sto, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(sto[i][j] + "");
            }
            System.out.println();
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        int n = storage.length;
        int m = storage[0].length();
        char[][] sto = new char[n][m];
        for(int i = 0; i < n; i++) {
            String row = storage[i];
            for(int j = 0; j < m; j++) {
                sto[i][j] = row.charAt(j);
            }
        }
        
        
        for(int i = 0; i < requests.length; i++) {
            String req = requests[i];
            
            // v 초기화
            for(int j = 0; j < n; j++) {
                Arrays.fill(v[j], 0);
            }
            
            if(req.length() == 1) {
                sol1(sto, n, m, req.charAt(0));
            } else {
                sol2(sto, n, m, req.charAt(0));
            }
            updateMap(sto);
        }
        
        return n * m - cnt;
    }
}