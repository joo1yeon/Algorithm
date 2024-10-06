import java.util.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] num, ans;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        ans = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0);

        System.out.println(sb);

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');

            return;
        }

        int prev = 0;
        for (int i = 0; i < N; i++) {

            if (visited[i]) {
                continue;
            } else {
                if (prev != num[i]) {
                    ans[depth] = num[i];
                    visited[i] = true;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
            prev = num[i];
        }
    }
}