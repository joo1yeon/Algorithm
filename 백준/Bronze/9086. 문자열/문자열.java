import java.io.*;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
        }
        
        System.out.println(sb);
    }
}