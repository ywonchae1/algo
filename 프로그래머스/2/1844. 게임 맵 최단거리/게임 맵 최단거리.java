import java.util.*;

class Solution {
    int[][] visited = new int[100][100];
    int[][] dist = new int[100][100];
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    class Node {
        int h, w;
        Node(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
    
    void bfs(int[][] map, Node n) {
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        visited[n.h][n.w] = 1;
        dist[n.h][n.w] = 1;
        
        while(!q.isEmpty()) {
            Node p = q.poll();
            for(int i = 0; i < 4; i++) {
                Node np = new Node(p.h + d[i][0], p.w + d[i][1]);
                if(np.h < 0 || np.h >= map.length || np.w < 0 || np.w >= map[0].length) {
                    continue;
                }
                if(visited[np.h][np.w] == 1 || map[np.h][np.w] == 0) continue;
                
                q.add(np);
                visited[np.h][np.w] = 1;
                int nd = dist[p.h][p.w] + 1;
                if(dist[np.h][np.w] == 0 || dist[np.h][np.w] > nd)
                    dist[np.h][np.w] = nd;
            }
        }
    }
    public int solution(int[][] maps) {
        bfs(maps, new Node(0, 0));
        int answer = dist[maps.length - 1][maps[0].length - 1];
        return answer == 0 ? -1 : answer;
    }
}