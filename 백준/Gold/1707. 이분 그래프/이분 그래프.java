import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int V, E;
    static int[] bipartite;
    static boolean isBipartite;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            visited = new boolean[V + 1];
            bipartite = new int[V + 1];
            isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (isBipartite) {
                    visited[i] = true;
                    if (bipartite[i] == 0) {
                        bipartite[i] = 1;
                    }
                    dfs(i);
                } else {
                    break;
                }
            }

            if (isBipartite) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        for (int next : graph[idx]) {
            if (visited[next]) {
                if (bipartite[next] == bipartite[idx]) {
                    isBipartite = false;
                    return;
                }
            } else {
                visited[next] = true;
                bipartite[next] = bipartite[idx] * (-1);
                dfs(next);
            }
        }
    }
}
