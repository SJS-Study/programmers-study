import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> map = getMap(phone_book);
        return answer(map , phone_book);
    }

    private Map<String , String> getMap(String[] phone_book){
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i<phone_book.length; i++){
            map.put(phone_book[i] , phone_book[i] );
        }
        return map;
    }

    private boolean answer(Map<String , String> map , String[] phone_book){
        for(String number : phone_book){
            for(int i= 0; i<number.length(); i++){
                String chars = number.substring(0 , i);
                if (map.containsKey(chars)) {
                    return false;
                }
            }
        }
        return true;
    }
}