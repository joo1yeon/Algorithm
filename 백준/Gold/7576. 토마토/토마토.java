import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, tomato, days;
	static int[][] box;
	static Queue<Tomato> queue;
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				tomato += box[i][j];
			}
		}
		
		// 상자에 전부 익은 토마토가 들어있는 경우
		if (tomato == N * M) {
			System.out.println(0);
			System.exit(0);
		}
		
		queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 0일차에 익은 토마토들
				if (box[i][j] == 1) {
					queue.offer(new Tomato(i, j));
				}
			}
		}
		
		bfs();
		
		if (check()) {
			System.out.println(days);			
		} else {
			System.out.println(-1);
		}
		
	}
	
	static int bfs() {

		while (!queue.isEmpty()) {
			// 현재 익어있는 토마토 개수
			int queueSize = queue.size();
			for (int s = 0; s < queueSize; s++) {
				// 익은 토마토 꺼내자
				Tomato now = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = now.row + dr[i];
					int nc = now.col + dc[i];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						continue;
					}
					
					if (box[nr][nc] == 0) {
						// 익었다고 표시
						box[nr][nc] = 1;
						queue.offer(new Tomato(nr, nc));
					}
				}
			}
			// 내일 익는 토마토가 있는 경우
			if (!queue.isEmpty()) {
				days++;				
			}
		}
		return days;
	}
	
	// 토마토가 다 익었는지 확인
	private static boolean check() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}

class Tomato {
	
	int row;
	int col;
	
	public Tomato(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
}
