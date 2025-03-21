class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        for(int i = 0; i < players.length; i++) {
            int p = players[i];
            
            int cnt = p / m;
            if(servers[i] < cnt) {
                cnt = cnt - servers[i];
                for(int j = i; j < i + k && j < 24; j++) servers[j] += cnt;
                answer += cnt;
            }
        }
        
        return answer;
    }
}