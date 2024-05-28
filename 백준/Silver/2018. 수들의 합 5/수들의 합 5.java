import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        int start = 0;
        int end = 0;
        int sum = num[start];
        int count = 0;

        while (end < N) {
            if (sum < N) {
                sum += num[++end];
            } else if (sum > N) {
                sum -= num[start++];
            } else {
                count++;
                sum += num[++end];
            }
        }

        System.out.println(count);
    }
}