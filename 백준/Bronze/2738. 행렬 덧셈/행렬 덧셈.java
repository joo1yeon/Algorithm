import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] m = new int[N][M];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    m[i][j] += Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < N; i++) {           
            for (int j = 0; j < M; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
