import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int end = 0;
        for ( ; end < k; end++) {
            sum += num[end];
        }

        int max = sum;
        int start = 0;
        while (end < n) {
            sum -= num[start++];
            sum += num[end++];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
