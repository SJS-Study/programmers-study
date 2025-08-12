import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}