import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && (prices[stack.peekLast()] > prices[i])) {
                int index = stack.pollLast();
                answer[index] = i - index;
            }
            stack.offerLast(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pollLast();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}