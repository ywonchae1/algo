class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stu = new int[n];
        for(int l : lost) stu[l - 1]--;
        for(int r : reserve) stu[r - 1]++;
        
        for(int i = 0; i < n; i++) {
            if(stu[i] < 0) {
                // 빌리자
                if(i - 1 >= 0 && stu[i - 1] > 0) {
                    stu[i - 1]--;
                    answer++;
                } else if(i + 1 < n && stu[i + 1] > 0) {
                    stu[i + 1]--;
                    answer++;
                }
            } else {
                answer++;
            }
        }
        return answer;
    }
}