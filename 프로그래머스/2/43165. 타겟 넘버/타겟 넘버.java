class Solution {
    int answer = 0;
    void dfs(int[] numbers, int index, int res, int target) {
        if(index == numbers.length) {
            if(res == target) answer++;
            return;
        }
        dfs(numbers, index + 1, res + numbers[index], target);
        dfs(numbers, index + 1, res - numbers[index], target);
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
}