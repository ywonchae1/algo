import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        while(!s.equals("end")) {
            boolean mocheck = false;
            boolean loopcheck = true;
            int mocnt = 0;
            int jacnt = 0;

            if(s.length() == 1) {
                char c = s.charAt(0);
                if(mochecker(c)) {
                    System.out.printf("<%s> is acceptable.\n", s);
                } else {
                    System.out.printf("<%s> is not acceptable.\n", s);
                }
                loopcheck = false;
            }

            for(int i = 0; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                char nc = s.charAt(i + 1);
                if(c == nc && c != 'e' && c != 'o') {
                    System.out.printf("<%s> is not acceptable.\n", s);
                    loopcheck = false;
                    break;
                }
            }

            if(!loopcheck) {
                s = sc.next();
                continue;
            }

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(mochecker(c)) {
                    // 모음이다
                    mocheck = true;
                    mocnt++;
                    jacnt = 0;
                } else {
                    mocnt = 0;
                    jacnt++;
                }

                if(mocnt == 3 || jacnt == 3) {
                    System.out.printf("<%s> is not acceptable.\n", s);
                    loopcheck = false;
                    break;
                }
            }

            if(loopcheck) {
                if(mocheck) {
                    System.out.printf("<%s> is acceptable.\n", s);
                } else {
                    System.out.printf("<%s> is not acceptable.\n", s);
                }
            }
            s = sc.next();
        }
    }

    static boolean mochecker(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}