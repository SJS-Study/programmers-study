class Solution {
    public int solution(int[] numbers, int target) {
        return answer(numbers , target , 0 , 0);
    }

    private int answer(int[] numbers , int target , int depth , int sum){
        if(depth == numbers.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        int plus = answer(numbers , target , depth + 1 , sum + numbers[depth]);
        int minus = answer(numbers , target , depth + 1 , sum - numbers[depth]);
        return plus + minus;
    }
}