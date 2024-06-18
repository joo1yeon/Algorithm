import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] solution;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int ans1 = 0, ans2 = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int start = i + 1;
            int end = N - 1;

            while (start <= end) {
                int mid = (start + end) >> 1;
                int sum = Math.abs(solution[i] + solution[mid]);

                if (min > sum) {
                    min = sum;
                    ans1 = solution[i];
                    ans2 = solution[mid];
                }

                int target = -solution[i];
                if (target <= solution[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
