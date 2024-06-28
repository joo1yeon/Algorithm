import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int w, h, time;
    static char[][] map;
    static boolean[][] fireVisited;
    static Queue<Point> fireQ, personQ;
    static boolean impossible, out;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w =  Integer.parseInt(st.nextToken());
            h =  Integer.parseInt(st.nextToken());

            map = new char[h][w];

            fireQ = new ArrayDeque<>();
            fireVisited = new boolean[h][w];
            personQ = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') {
                        personQ.offer(new Point(i, j, 0));
                    } else if (map[i][j] == '*') {
                        fireQ.offer(new Point(i, j));
                        fireVisited[i][j] = true;
                    }
                }
            }
            impossible = true;
            out = false;
            time = 0;
            fire();
            while (!personQ.isEmpty() && !out) {
                person();
            }

            if (impossible && !out) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(time + 1);
            }
        }
    }

    static void fire() {
        // 불 번짐
        while (!fireQ.isEmpty() && !out) {
            int size = fireQ.size();
            for (int i = 0; i < size; i++) {
                Point now = fireQ.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = now.row + dr[d];
                    int nc = now.col + dc[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                        continue;
                    }
                    if (map[nr][nc] == '#') {
                        continue;
                    }
                    if (fireVisited[nr][nc]) {
                        continue;
                    }

                    fireQ.offer(new Point(nr, nc));
                    map[nr][nc] = '*';
                    fireVisited[nr][nc] = true;
                }
            }
            person();
        }
    }

    static void person() {
        // 사람 이동
        if (personQ.isEmpty()) {
            impossible = !out;
            return;
        }

        int size = personQ.size();
        for (int i = 0; i < size; i++) {
            Point now = personQ.poll();
            time = now.time;
            for (int d = 0; d < 4; d++) {
                int nr = now.row + dr[d];
                int nc = now.col + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    out = true;
                    break;
                }
                if (map[nr][nc] == '*' || map[nr][nc] == '#' || map[nr][nc] == '@') {
                    continue;
                }
                if (fireVisited[nr][nc]) {
                    continue;
                }

                map[nr][nc] = '@';
                personQ.offer(new Point(nr, nc, now.time + 1));
            }
        }
    }
}

class Point {
    int row;
    int col;
    int time;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
        this.time = 0;
    }

    public Point(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
