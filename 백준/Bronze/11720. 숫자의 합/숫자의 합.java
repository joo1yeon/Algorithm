import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] num = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i] - '0';
        }

        System.out.println(sum);
    }
}
