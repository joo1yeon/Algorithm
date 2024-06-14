import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, d, k, c;
    static int cnt, answer;
    static int[] plate, sushi;

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
        cnt++;

        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 0;

        for ( ; end < k; end++) {
            sushi[plate[end]]++;
            if (sushi[plate[end]] == 1) {
                cnt++;
            }
        }

        answer = Math.max(answer, cnt);

        while (start < N) {
            if (end >= N) {
                end -= N;
            }

            sushi[plate[start]]--;
            if (sushi[plate[start++]] == 0) {
                cnt--;
            }
            sushi[plate[end]]++;
            if (sushi[plate[end++]] == 1) {
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
