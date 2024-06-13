import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, d, k, c, answer;
    static int[] plate;
    static int[] sushi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        plate = new int[N];
        sushi = new int[d + 1];
        sushi[c]++;

        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            sushi[plate[i]]++;
        }
        check();

        int start = 0;
        int end = k;
        while (start < N) {
            if (end >= N) {
                end -= N;
            }
            sushi[plate[start++]]--;
            sushi[plate[end++]]++;
            check();
        }

        System.out.println(answer);
    }

    static void check() {
        int cnt = 0;
        for (int i = 1; i < sushi.length; i++) {
            if (sushi[i] > 0) {
                cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
