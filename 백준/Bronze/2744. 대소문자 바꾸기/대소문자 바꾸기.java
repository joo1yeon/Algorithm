import java.io.*;
import java.util.*;

class Main {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 65 && c[i] <= 90) {
                c[i] += 32;
            } else {
                c[i] -= 32;
            }
            sb.append(c[i]);
        }

        System.out.println(sb);
    }
}