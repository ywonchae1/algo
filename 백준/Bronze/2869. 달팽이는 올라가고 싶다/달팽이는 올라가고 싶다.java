import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());
        
        long time;
        double rem;
        if(A >= V) time = 1;
        else if(V - A >= A - B) {
            rem = (V - A) % (A - B);
            if(rem > 0) time = (V - A) / (A - B) + 2;
            else time = (V - A) / (A - B) + 1;
        } else {
            rem = V % (A - B);
            if(rem > 0) time = V / (A - B) + 1;
            else time = V / (A - B);
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(time + "");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}