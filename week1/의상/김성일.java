import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = makeClothesMap(clothes);
        return answer(clothesMap);
    }

    private Map<String, Integer> makeClothesMap(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String clotehsType = clothes[i][1];
            map.put(clotehsType, map.getOrDefault(clotehsType, 0) + 1);
        }
        return map;
    }

    private int answer(Map<String, Integer> map) {
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}
