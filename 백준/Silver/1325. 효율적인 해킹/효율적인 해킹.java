import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        cnt = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (!list[i].isEmpty()) {
                bfs(i);
            }
        }

        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (!visited[next]) {
                    cnt[next]++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
