class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = {0, 0};
        answer[0] = gcd(n, m);
        answer[1] = answer[0] * (n / answer[0]) * (m / answer[0]);
        return answer;
    }
}