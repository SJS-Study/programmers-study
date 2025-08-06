import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = countPokeMon(nums);
        return answer(nums, map);
    }

    private Map<Integer, Integer> countPokeMon(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num , 1) +1);
        }
        return map;
    }

    private int answer(int[] nums, Map<Integer, Integer> map) {
        int allow = nums.length / 2;
        if(map.size() > allow) return allow;
        return map.size();
    }
}
