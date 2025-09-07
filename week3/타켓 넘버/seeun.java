import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int sum, int index) {
        if(index == numbers.length){
            if(sum == target)
                answer++;
        }
        else {
            dfs(numbers, target, sum + numbers[index], index + 1);
            dfs(numbers, target, sum - numbers[index], index + 1);
        }
    }
}