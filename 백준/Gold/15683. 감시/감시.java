import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int answer; // 사각지대의 최소 크기
    static ArrayList<CCTV> cctvList; // 카메라의 개수를 모르기 때문에 ArrayList로 선언
    // 상, 우, 하, 좌
    static final String[][] cctvDir = {
            {""},
            {"0", "1", "2", "3"}, // 1번 카메라 반복 4번
            {"02", "13"}, // 2번 카메라 반복 2번
            {"01", "12", "23", "30"}, // 3번 카메라 반복 3번
            {"012", "123", "230", "301"}, // 4번 카메라 반복 4번
            {"0123"} // 5번 카메라 반복 1번
    };
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        answer = Integer.MAX_VALUE;
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        // 재귀 한 번에 카메라 하나씩 담당
        dfs(0, map);

        System.out.println(answer);
    }

    static void dfs(int idx, int[][] origin) {
        // 모든 카메라 배치 완료
        if (idx == cctvList.size()) {
            // 사각지대 카운트
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (origin[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            answer = Math.min(cnt, answer);
            return;
        }

        String[] rotateCctv = cctvDir[cctvList.get(idx).type];
        for (int i = 0; i < rotateCctv.length; i++) { // 카메라 종류마다 회전 수 다름
            int[][] copy = copyArr(origin); // 현재 방향으로 그리기 전에 원본 유지

            String now = rotateCctv[i]; // 현재 비추고 있는 방향 정보
            for (int j = 0; j < now.length(); j++) {
                draw(cctvList.get(idx).row, cctvList.get(idx).col, now.charAt(j) - '0', copy);
            }
            dfs(idx + 1, copy);
        }
    }

    static void draw(int sr, int sc, int dir, int[][] copy) {
        // 현재 방향으로 슈퍼 직진
        int nr = sr + dr[dir];
        int nc = sc + dc[dir];

        while (true) {
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || copy[nr][nc] == 6) {
                break;
            }

            // 감시하는 공간을 7로 표시
            copy[nr][nc] = 7;
            nr += dr[dir];
            nc += dc[dir];
        }
    }

    static int[][] copyArr(int[][] origin) {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }

        return copy;
    }
}

class CCTV {
    int row;
    int col;
    int type;

    public CCTV(int row, int col, int type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }
}
