import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int N, M, X, answer;
    static int[] distance1, distance2;
    static ArrayList<Node>[] origin_graph, reverse_graph;
    static final int INF = 1_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        origin_graph = new ArrayList[N + 1];
        reverse_graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            origin_graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            origin_graph[start].add(new Node(end, time));
            reverse_graph[end].add(new Node(start, time));
        }

        distance1 = dijkstra(origin_graph);
        distance2 = dijkstra(reverse_graph);

        for (int i = 1; i <= N; i++) {
            answer = Math.max(distance1[i] + distance2[i], answer);
        }

        System.out.println(answer);
    }

    static int[] dijkstra(ArrayList<Node>[] graph) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        boolean[] visited = new boolean[N + 1];
        distance[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.node] = true;

            for (Node next : graph[now.node]) {
                if (visited[next.node]) {
                    continue;
                }
                if (distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    pq.offer(new Node(next.node, distance[next.node]));
                }
            }
        }
        return distance;
    }
}

class Node {
    int node;
    int weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
