import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int start = 0;
        int end = N - 1;
        int temp = Integer.MAX_VALUE;
        int idx1 = 0, idx2 = 0;

        while (start < end) {
            int sum = solution[start] + solution[end];
            if (sum > 0) {
                if (Math.abs(sum) < temp) {
                    idx1 = start;
                    idx2 = end;
                    temp = Math.abs(sum);
                }
                sum -= solution[end];
                sum += solution[--end];
            } else if (sum < 0) {
                if (Math.abs(sum) < temp) {
                    idx1 = start;
                    idx2 = end;
                    temp = Math.abs(sum);
                }
                sum -= solution[start];
                sum += solution[++start];
            } else {
                idx1 = start;
                idx2 = end;
                break;
            }
        }

        System.out.println(solution[idx1] + " " + solution[idx2]);
    }
}
