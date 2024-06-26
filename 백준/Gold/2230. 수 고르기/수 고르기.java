import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        while (left <= right && right < N) {
            int diff = A[right] - A[left];
            if (diff >= M) {
                min = Math.min(min, diff);
            }

            if (diff < M) {
                right++;
            } else if (diff > M) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(min);
    }
}
