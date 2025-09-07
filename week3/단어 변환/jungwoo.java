import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Deque<StringInfo> deque = new ArrayDeque<>();
        for(int i = 0; i < words.length; i++){
            if(isOneDifferent(begin, words[i])){
                deque.offerLast(new StringInfo(words[i], 1));
                visited[i] = true;
            }
        }

        while(!deque.isEmpty()){
            StringInfo sInfo = deque.pollFirst();
            String s = sInfo.getS();
            int cnt = sInfo.getCnt();

            if(s.equals(target)){
                return cnt;
            }

            for(int i = 0; i < words.length; i++){
                if(isOneDifferent(s, words[i]) && !visited[i]){
                    deque.offerLast(new StringInfo(words[i], cnt+1));
                    visited[i] = true;
                }
            }

        }
        return 0;

    }

    boolean isOneDifferent(String s1, String s2){
        int diffCnt = 0;

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diffCnt ++;
                if(diffCnt > 1) return false;
            }
        }
        return true;
    }

    class StringInfo{
        String s;
        int cnt;
        StringInfo(String s, int cnt){
            this.s = s;
            this.cnt = cnt;
        }

        String getS(){
            return s;
        }
        int getCnt(){
            return cnt;
        }
    }
}