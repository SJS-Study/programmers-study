import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int waitCnt = 0;
        Deque<Integer> priorityDeque = new ArrayDeque<>();
        Arrays.stream(priorities).forEach(i -> priorityDeque.offerLast(i));

        while(!priorityDeque.isEmpty()){
            Integer first = priorityDeque.pollFirst();
            if(priorityDeque.stream().anyMatch(i -> first<i)){
                priorityDeque.offerLast(first);

                if(location == 0){
                    location = priorityDeque.size()-1;
                }else{
                    location --;
                }

            }else{
                waitCnt++;
                if(location == 0){
                    return waitCnt;
                }
                location --;

            }
        }
        throw new IllegalStateException();
    }
}