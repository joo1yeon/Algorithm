import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int orderVal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        orderVal = 1;
        order[R] = orderVal++;
        visited[R] = true;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        for (int next : graph[idx]) {
            if (!visited[next]) {
                order[next] = orderVal++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
