class Solution {
    int[] visited = new int[200];
    void dfs(int[][] computers, int n) {
        int[] comp = computers[n];
        visited[n] = 1;
        for(int i = 0; i < comp.length; i++) {
            if(comp[i] == 1 && visited[i] == 0) {
                dfs(computers, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 1) continue;
            dfs(computers, i);
            answer++;
        }
        return answer;
    }
}