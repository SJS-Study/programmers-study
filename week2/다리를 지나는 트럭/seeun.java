import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int currentWeight = 0;
        Deque<Integer> bridge = new ArrayDeque<>(bridge_length);

        for (int i = 0; i < bridge_length; i++) bridge.add(0);

        while(index < truck_weights.length) {
            currentWeight -= bridge.poll();

            if (currentWeight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            } else {
                bridge.add(0);
            }

            answer++;
        }
        return answer + bridge_length;
    }
}