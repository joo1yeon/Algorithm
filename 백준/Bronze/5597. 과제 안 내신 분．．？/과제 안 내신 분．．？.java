import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] students = new int[31];
        
        for (int i = 0; i < 28; i++) {
            int a = Integer.parseInt(br.readLine());
            students[a]++;
        }
        
        for (int i = 1; i <= 30; i++) {
            if (students[i] == 0) {
                sb.append(i).append('\n');
            }
        }
        
        System.out.println(sb);
    }
}