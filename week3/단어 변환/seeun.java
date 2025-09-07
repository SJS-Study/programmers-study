import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(Arrays.asList(words).contains(target));
            answer = bfs(begin, target, words);
        return answer;
    }
    
    private static int bfs(String begin, String target, String[] words) {
        boolean visited[] = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        
        q.add(new Word(begin,0));
        while(!q.isEmpty()) {
            Word w = q.poll();
            
            for(int i = 0; i < words.length; i++) {
                            
                String str = w.str;
                int cnt = w.cnt;

                if(str.equals(target))
                    return cnt;
                
                if(!checkStr(str, words[i]) || visited[i] == true)
                    continue;
                
                q.add(new Word(words[i], cnt+1));
                visited[i] = true; 
            }
        }
        return 0;
    }
    
    public static class Word {
        String str;
        int cnt;
        
        public Word(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    private static boolean checkStr(String s1, String s2) {
        int different = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                different++;
            
            if(different > 1)
                return false;
        }
        return different == 1;
    }
}