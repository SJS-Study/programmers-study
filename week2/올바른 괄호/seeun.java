import java.util.*;

class Solution {
    boolean solution(String s) {
        if(s.charAt(0) == ')')
            return false;

        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}