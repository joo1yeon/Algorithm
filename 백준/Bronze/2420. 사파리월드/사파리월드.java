import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        
        System.out.println(Math.abs(N - M));
    }
}