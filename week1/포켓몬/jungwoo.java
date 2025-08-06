import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> monster = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        return Math.min(monster.size(), nums.length / 2 );
    }
}