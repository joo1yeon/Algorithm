import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input.substring(j, j+1));
            }
        }

        bfs(new Point(0, 0));

        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        visited = new boolean[N][M];

        q.offer(start);
        visited[start.row][start.col] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.row + dr[d];
                int nc = now.col + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (map[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }

                map[nr][nc] = map[now.row][now.col] + 1;
                visited[nr][nc] = true;
                q.offer(new Point(nr, nc));
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
