import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int N, M, start, end;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<City>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new City(e, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(distance[end]);

    }

    static void dijkstra() {
        PriorityQueue<City> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        distance[start] = 0;
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City now = pq.poll();
            visited[now.node] = true;
            
            if (now.node == end) {
                return;
            }

            for (City next : graph[now.node]) {
                if (visited[next.node]) {
                    continue;
                }
                if (distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    pq.offer(new City(next.node, distance[next.node]));
                }
            }
        }
    }
}

class City {
    int node;
    int weight;

    public City(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}