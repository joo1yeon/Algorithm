import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                sb.append("INF").append('\n');
            } else {
                sb.append(distance[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        distance[K] = 0;
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.end] = true;

            for (Node next : graph[now.end]) {
                if (visited[next.end]) {
                    continue;
                }
                if (distance[next.end] > distance[now.end] + next.weight) {
                    distance[next.end] = distance[now.end] + next.weight;
                    pq.offer(new Node(next.end, distance[next.end]));
                }
            }
        }
    }
}

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
