import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H; // 열, 행, 높이
	static int tomato, answer;
	static int[][][] box;
	static boolean[][][] visited;
	static Queue<Point> queue;
	static final int[] dh = {-1, 1, 0, 0, 0, 0};
	static final int[] dr = {0, 0, -1, 1, 0, 0};
	static final int[] dc = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		queue = new ArrayDeque<Point>();
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					tomato += box[h][n][m];
				}
			}
		}
		
		// 모든 토마토가 익어있을 경우
		if (tomato == H * N * M) {
			System.out.println(0);
			System.exit(0);
		}
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (box[h][n][m] == 1) {
						queue.offer(new Point(h, n, m, 0));
						visited[h][n][m] = true;
					}
				}
			}
		}
		
		bfs();
		
		if (check()) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
		
	}

	private static boolean check() {
	
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	private static void bfs() {

		int days = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			days = now.days;
			
			for (int i = 0; i < 6; i++) {
				int nh = now.height + dh[i];
				int nr = now.row + dr[i];
				int nc = now.col + dc[i];
				
				if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}
				
				if (visited[nh][nr][nc]) {
					continue;
				}
				
				if (box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = 1;
					queue.offer(new Point(nh, nr, nc, now.days + 1));
					visited[nh][nr][nc] = true;
				}
			}
		}
		
		answer = days;
	}

}

class Point {
	
	int height;
	int row;
	int col;
	int days;
	
	public Point(int height, int row, int col, int days) {
		super();
		this.height = height;
		this.row = row;
		this.col = col;
		this.days = days;
	}
	
}
