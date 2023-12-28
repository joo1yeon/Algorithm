class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] cnt = new int[1000];
        
        for (int a : array) {
            cnt[a]++;
        }
        
        answer = cnt[0];
        boolean flag = false;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == cnt[answer]) {
                flag = true;
            }
            else if (cnt[i] > cnt[answer]) {
                answer = i;
                flag = false;
            }
        }
        
        if (flag) {
            answer = -1;
        }
        
        return answer;
    }
}