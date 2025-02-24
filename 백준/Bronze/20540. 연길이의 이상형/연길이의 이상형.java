import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String mbti = sc.next();
        String itbm = "";
        
        for(int i = 0; i < 4; i++) {
            char c = mbti.charAt(i);
            
            if(c == 'E') itbm = itbm + 'I';
            else if(c == 'I') itbm = itbm + 'E';
            else if(c == 'N') itbm = itbm + 'S';
            else if(c == 'S') itbm = itbm + 'N';
            else if(c == 'F') itbm = itbm + 'T';
            else if(c == 'T') itbm = itbm + 'F';
            else if(c == 'P') itbm = itbm + 'J';
            else if(c == 'J') itbm = itbm + 'P';
        }
        
        System.out.println(itbm);
    }
}
