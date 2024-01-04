import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt, answer;
	static int[][] m1, m2;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		m1 = new int[N][M];
		m2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				m1[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				m2[i][j] = temp.charAt(j) - '0';
			}
		}
		
		if (N < 3 || M < 3) {
			if (!equals()) {
				cnt = -1;
			}
			System.out.println(cnt);
		} else {
			System.out.println(start());			
		}
	}
	
	static int start() {
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (m1[i][j] != m2[i][j]) {
					flip(i, j);
					cnt++;
				}
				if (equals()) {
					return cnt;
				}
			}
		}
		return -1;
	}
	
	static void flip(int startRow, int startCol) {	
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				m1[i][j] = 1 - m1[i][j];
			}
		}
	}
	
	static boolean equals() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m1[i][j] != m2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
