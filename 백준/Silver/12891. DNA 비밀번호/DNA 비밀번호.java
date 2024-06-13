import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int s, p, answer;
    static int[] acgt, cnt;
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        acgt = new int[4];
        cnt = new int[4];

        str = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;

        for ( ; end < p; end++) {
            add(end);
        }
        check();

        int start = 0;
        while (end < str.length()) {
            sub(start++);
            add(end++);
            check();
        }

        System.out.println(answer);
    }

    static void check() {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] < acgt[i]) {
                return;
            }
        }
        answer++;
    }

    static void add(int idx) {
        char temp = str.charAt(idx);
        switch (temp) {
            case 'A': cnt[0]++; break;
            case 'C': cnt[1]++; break;
            case 'G': cnt[2]++; break;
            case 'T': cnt[3]++; break;
        }
    }

    static void sub(int idx) {
        char temp = str.charAt(idx);
        switch (temp) {
            case 'A': cnt[0]--; break;
            case 'C': cnt[1]--; break;
            case 'G': cnt[2]--; break;
            case 'T': cnt[3]--; break;
        }
    }
}
