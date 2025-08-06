import java.util.*;

class Solution {
    public static int solution(String[][] clothes) {
        Map<String, Integer> typeCount = new HashMap<>();
        for (String[] cloth : clothes) {
            typeCount.put(cloth[1], typeCount.getOrDefault(cloth[1], 0) + 1);
        }
        int answer = 1;
        for (int count : typeCount.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}