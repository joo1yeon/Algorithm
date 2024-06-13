import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        
        while (n-- > 0) {
            
            int a = Integer.parseInt(br.readLine());
            if (a > num) {
                for (int i = num + 1; i <= a; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                num = a;
            } else if (stack.peek() != a) {
                System.out.println("NO");
                return;
            }
            
            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }    
}
