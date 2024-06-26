import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] house = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                house[i] = Integer.parseInt(st.nextToken());
            }

            int money = 0;
            int end = 0;
            for (end = 0; end < M; end++) {
                money += house[end];
            }

            if (N == M) {
                if (money < K) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else {
                int cnt = 0;
                int start = 0;
                while (start <= N - 1) {
                    if (end >= N) {
                        end -= N;
                    }
                    if (money < K) {
                        cnt++;
                    }

                    money -= house[start++];
                    money += house[end++];
                }
                sb.append(cnt).append('\n');
            }
        }
        System.out.println(sb);
    }
}