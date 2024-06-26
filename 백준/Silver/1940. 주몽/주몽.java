import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N, M, cnt;
    static int[] ingredient;
    static boolean[] armor;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ingredient = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            ingredient[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredient);

        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = ingredient[start] + ingredient[end];
            if (sum < M) {
                start++;
            } else if (sum > M) {
                end--;
            } else {
                cnt++;
                start++;
            }
        }

        System.out.println(cnt);
    }
}
