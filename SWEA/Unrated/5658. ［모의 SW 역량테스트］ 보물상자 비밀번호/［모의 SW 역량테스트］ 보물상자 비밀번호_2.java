import java.io.*;
import java.util.*;

class Solution {

    static int N, K;
    static TreeSet<String> treeSet;
    static String[] decimal;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            String s = br.readLine();
            treeSet = new TreeSet<>(((o1, o2) -> o2.compareTo(o1)));

            for (int i = 0; i < N / 4; i++) {
                for (int j = 0; j < N; j += N / 4) {
                    treeSet.add(s.substring(j, j + N / 4));
                }
                s = s.charAt(N - 1) + s.substring(0, N - 1);
            }

            decimal = treeSet.toArray(new String[treeSet.size()]);

            sb.append('#').append(tc).append(' ').append(Integer.parseInt(decimal[K - 1], 16)).append('\n');
        }
        
        System.out.println(sb);
    }
}
