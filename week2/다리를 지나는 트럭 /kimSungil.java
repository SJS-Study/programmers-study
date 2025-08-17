import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> bridge = makeBridge(bridge_length);
        Deque<Integer> truck = makeTruck(truck_weights);
        return answer(bridge, truck, weight);
    }

    private Deque<Integer> makeBridge(int bridgeLength) {
        Deque<Integer> bridge = new ArrayDeque<>(bridgeLength);
        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }
        return bridge;
    }

    private Deque<Integer> makeTruck(int[] truck_weights) {
        Deque<Integer> truck = new ArrayDeque<>();
        for (int weight : truck_weights) {
            truck.add(weight);
        }
        return truck;
    }

    private int answer(Deque<Integer> bridge, Deque<Integer> truck, int weight) {
        int answer = 0;
        int currentBridgeWeight = 0;
        while (!truck.isEmpty() || !bridge.isEmpty()) {
            answer++;
            currentBridgeWeight -= bridge.removeFirst();
            if (!truck.isEmpty()) {
                if (currentBridgeWeight + truck.peekFirst() <= weight) {
                    int next = truck.removeFirst();
                    bridge.addLast(next);
                    currentBridgeWeight += next;
                } else {
                    bridge.addLast(0);
                }
            }
        }
        return answer;
    }
}