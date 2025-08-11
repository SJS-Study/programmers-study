import java.util.*;
import java.util.stream.*;

class Solution {
    boolean solution(String s) {
        if(s.startsWith(")")) return false;

        Deque<String> deque = new ArrayDeque<>();
        Arrays.stream(s.split("")).forEach(c -> {
            if(c.equals("(")) deque.offerLast("(");
            else deque.pollFirst();
        });

        return deque.size() == 0;
    }
}