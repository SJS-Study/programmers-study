import java.util.*;
import java.util.stream.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        return IntStream.range(0, phone_book.length - 1)
                .noneMatch(i -> phone_book[i + 1].startsWith(phone_book[i]));
    }
}