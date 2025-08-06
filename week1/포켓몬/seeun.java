import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int selectLimit = nums.length / 2;  
        Set<Integer> uniqueKinds = new HashSet<>(); 
        for (int n : nums)
            uniqueKinds.add(n);

        return Math.min(uniqueKinds.size(), selectLimit);
    }
}