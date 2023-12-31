import java.util.*;

class Solution {
    public String solution(String s) {        
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            
            if (word.equals(" ")) {
                sb.append(word);
            } else {
                String temp = word.substring(0, 1).toUpperCase();
                sb.append(temp).append(word.substring(1));
            }
        }

        return sb.toString();
    }
}