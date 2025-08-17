import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> prioritiesMap = prioritiesDeque(priorities);
        int[] queueData = locationPriorities(location, priorities);
        return answer(prioritiesMap, queueData);
    }

    private Deque<int[]> prioritiesDeque(int[] priorities) {
        Deque<int[]> map = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            map.addLast(new int[]{ i, priorities[i] });
        }
        return map;
    }

    private int[] locationPriorities(int location, int[] priorities) {
        return new int[]{ location, priorities[location] };
    }

    private Integer answer(Deque<int[]> priorities, int[] location) {
        List<int[]> answerList = new ArrayList<>();
        while (!priorities.isEmpty()) {
            int[] process = priorities.removeFirst();
            int dataProcess = process[1];
            boolean isHigher = false;

            for (int[] data : priorities) {
                if (data[1] > dataProcess) {
                    isHigher = true;
                    break;
                }
            }

            if (isHigher) {
                priorities.addLast(process);
            } else {
                answerList.add(process);
            }
        }

        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i)[0] == location[0]) {
                return i + 1;
            }
        }
        return -1;
    }
}