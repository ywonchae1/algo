import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine();
        while(!line.equals("#")) {
            int count = 0;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i'
                   || line.charAt(i) == 'o'|| line.charAt(i) == 'u'
                   || line.charAt(i) == 'A' || line.charAt(i) == 'E' || line.charAt(i) == 'I'
                   || line.charAt(i) == 'O'|| line.charAt(i) == 'U') {
                    count++;
                }
            }
            System.out.println(count);
            line = sc.nextLine();
        }
    }
}