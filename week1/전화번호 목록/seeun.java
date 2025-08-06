import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String number : phone_book) {
            set.add(number);
        }
        
        for (String number : phone_book) {
            for (int j = 1; j < number.length(); j++) {
                if (set.contains(number.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
