import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> priceDeque = toDeque(prices);
        return computeDurations(priceDeque);
    }

    private Deque<Integer> toDeque(int[] prices) {
        Deque<Integer> priceDeque = new ArrayDeque<>();
        for (int price : prices) {
            priceDeque.addLast(price);
        }
        return priceDeque;
    }

    private int[] computeDurations(Deque<Integer> priceDeque) {
        List<Integer> durations = new ArrayList<>();
        while (!priceDeque.isEmpty()) {
            int currentPrice = priceDeque.removeFirst();
            int duration = 0;
            for (Integer futurePrice : priceDeque) {
                duration++;
                if (currentPrice > futurePrice) {
                    break;
                }
            }
            durations.add(duration);
        }
        return durations.stream().mapToInt(Integer::intValue).toArray();
    }
}
