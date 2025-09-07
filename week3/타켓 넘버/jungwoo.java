import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return getCaseCnt(numbers, target);
    }

    int getCaseCnt(int[] numbers, int targetNum){
        Deque<CurrentSum> deque = new ArrayDeque<>();
        int caseCnt = 0;
        deque.offerLast(new CurrentSum(numbers[0], 1));
        deque.offerLast(new CurrentSum(-numbers[0], 1));


        while(!deque.isEmpty()){
            CurrentSum currentSum = deque.pollLast();
            int sumCnt = currentSum.getSumCnt();
            int sum = currentSum.getSum();
            if(sumCnt == numbers.length){
                if(sum == targetNum){
                    caseCnt ++;
                }
                continue;
            }
            deque.offerLast(new CurrentSum(sum + numbers[sumCnt], sumCnt+1));
            deque.offerLast(new CurrentSum(sum - numbers[sumCnt], sumCnt+1));
        }
        return caseCnt;
    }

    class CurrentSum{
        int sum;
        int sumCnt;
        CurrentSum(int sum, int sumCnt){
            this.sum = sum;
            this.sumCnt = sumCnt;
        }

        int getSumCnt(){
            return sumCnt;
        }
        int getSum(){
            return sum;
        }
    }
}