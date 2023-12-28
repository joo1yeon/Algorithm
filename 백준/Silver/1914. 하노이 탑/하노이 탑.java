import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BigInteger number = new BigInteger("2");
        sb.append(number.pow(N).subtract(new BigInteger("1"))).append('\n');

        if (N <= 20) {
            hanoi(N, 1, 3, 2);
        }

        System.out.println(sb);
    }

    static void hanoi(int cnt, int from, int to, int temp) {
        if (cnt == 0) {
            return;
        }

        hanoi(cnt - 1, from, temp, to);

        sb.append(from).append(' ').append(to).append('\n');

        hanoi(cnt - 1, temp, to, from);
    }
}
