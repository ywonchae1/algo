import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][] colorList = new int[N][3];
        
        for(int i = 0; i < N; i++) {
            colorList[i][0] = sc.nextInt();
            colorList[i][1] = sc.nextInt();
            colorList[i][2] = sc.nextInt();
        }
        
        int[][] valueList = new int[N][3];
        
        for(int i = 0; i < N; i++) {
            // i가 0일 때는 자기 자신이 최소이므로 그대로 저장한다
            if(i == 0) {
                for(int j = 0; j < 3; j++) valueList[i][j] = colorList[i][j];
                continue;
            }
            
            // 빨간색을 선택한다면
            valueList[i][0]
                = Math.min(valueList[i - 1][1], valueList[i - 1][2]) + colorList[i][0];
            // 초록색을 선택한다면
            valueList[i][1]
                = Math.min(valueList[i - 1][0], valueList[i - 1][2]) + colorList[i][1];
            // 파란색을 선택한다면
            valueList[i][2]
                = Math.min(valueList[i - 1][0], valueList[i - 1][1]) + colorList[i][2];
        }
        
        // 마지막 줄에서 최소를 찾는다
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < 3; i++) answer = Math.min(answer, valueList[N - 1][i]);
        
        System.out.println(answer);
    }
}