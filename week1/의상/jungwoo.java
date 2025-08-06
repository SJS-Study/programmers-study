import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.counting()))
                .values()
                .stream()
                .reduce(1L, (a, b) -> a * (b + 1))
                .intValue() - 1;
    }
}