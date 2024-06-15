import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());

                boolean find = false;
                int start = 0;
                int end = N - 1;
                while (start <= end) {
                    int midIdx = (start + end) >> 1;
                    int midVal = num[midIdx];

                    if (target < midVal) {
                        end = midIdx - 1;
                    } else if (midVal < target) {
                        start = midIdx + 1;
                    } else {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    sb.append('1').append('\n');
                } else {
                    sb.append('0').append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
