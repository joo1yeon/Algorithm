import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 0;

        while (end <= N) {
            if (sum < N) {
                sum += ++end;
            } else if (sum > N) {
                sum -= start++;
            } else {
                count++;
                sum += ++end;
            }
        }

        System.out.println(count);
    }
}