import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int sum = solution[start] + solution[end];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }

            if (sum > 0) {
                end--;
            } else if (sum < 0) {
                start++;
            } else {
                break;
            }
        }

        System.out.println(min);
    }
}