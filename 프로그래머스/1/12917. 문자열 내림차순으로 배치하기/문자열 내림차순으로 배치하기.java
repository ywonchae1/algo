import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] li = s.toCharArray();
        Arrays.sort(li);
        StringBuilder sb = new StringBuilder();
        for(int i = li.length - 1; i >= 0; i--) sb.append(li[i]);
        answer = sb.toString();
        return answer;
    }
}