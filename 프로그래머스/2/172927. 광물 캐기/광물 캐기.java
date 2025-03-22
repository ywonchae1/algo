import java.util.*;
class Solution {
    static int res = 100000;
    void dfs(String[] minerals, int idx, int[] picks, int piro) {
        // picks가 모두 비었다면 최소값을 비교하고 종료
        boolean emptyFlag = true;
        for(int i = 0; i < 3; i++) {
            if(picks[i] != 0) emptyFlag = false;
        }
        if(emptyFlag) {
            if(res > piro) res = piro;
            return;
        }
        // idx가 넘어가면 최소값을 비교하고 종료
        if(minerals.length <= idx) {
            if(res > piro) res = piro;
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(picks[i] > 0) {
                // 곡괭이 사용하고 다음
                int[] npicks = new int[3];
                
                for(int j = 0; j < 3; j++) {
                    if(i == j) npicks[j] = picks[j] - 1;
                    else npicks[j] = picks[j];
                }
                
                int npiro = piro;
                for(int j = idx; j < idx + 5 && j < minerals.length; j++) {
                    // 다섯 개를 캐며 피로도를 계산
                    if(i == 0) {
                        // 다이아몬드 곡괭이는 모두 1
                        npiro += 1;
                    } else if(i == 1) {
                        // 철 곡괭이는 다이아몬드일 때만 5
                        if(minerals[j].equals("diamond")) npiro += 5;
                        else npiro += 1;
                    } else if(i == 2) {
                        // 돌 곡괭이는 다이아몬드일 때 25
                        // 철일 때 5
                        if(minerals[j].equals("diamond")) npiro += 25;
                        else if(minerals[j].equals("iron")) npiro += 5;
                        else npiro += 1;
                    }
                }
                
                dfs(minerals, idx + 5, npicks, npiro);
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        dfs(minerals, 0, picks, 0);
        return res;
    }
}