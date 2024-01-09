import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    // 상, 우, 하, 좌
    static int[][] tunnel = {
            {},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1}
    };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R, C);

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) {
                        answer++;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int sr, int sc) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(sr, sc));
        visited[sr][sc] = true;

        int time = 1;
        while (!queue.isEmpty() && time < L) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                int tunnelNum = map[now.row][now.col];

                for (int d = 0; d < 4; d++) {
                    if (tunnel[tunnelNum][d] == 1) {
                        int nr = now.row + dr[d];
                        int nc = now.col + dc[d];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) {
                            continue;
                        }
                        int nextTunnelNum = map[nr][nc];

                        if (tunnel[nextTunnelNum][(d + 2) % 4] == 1) {
                            visited[nr][nc] = true;
                            queue.add(new Point(nr, nc));
                        }
                    }
                }
            }
            time++;
        }
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
