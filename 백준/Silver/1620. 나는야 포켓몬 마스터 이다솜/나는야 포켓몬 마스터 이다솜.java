import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i = 1; i < N + 1; i++) {
            String monster = sc.next();
            map1.put(i, monster);
            map2.put(monster, i);
        }
        
        for(int i = 0; i < M; i++) {
            String token = sc.next();
            
            try {
                int index = Integer.parseInt(token);
                System.out.println(map1.get(index));
            } catch(Exception err) {
                System.out.println(map2.get(token));
            }
        }
    }
}