import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[][] map, answer;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = -1;
            }
        }

        Point start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Point(i, j);
                    map[i][j] = 0;
                    answer[i][j] = 0;
                }
            }
        }

        bfs(start);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(answer[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(start);
        visited[start.row][start.col] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.row + dr[d];
                int nc = now.col + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    continue;
                }

                map[nr][nc] += map[now.row][now.col];
                answer[nr][nc] = map[nr][nc];
                q.offer(new Point(nr, nc));
                visited[nr][nc] = true;
            }
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
