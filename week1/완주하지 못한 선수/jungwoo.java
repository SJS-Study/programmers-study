import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String pName : participant) {
            participantMap.put(
                    pName,
                    participantMap.getOrDefault(pName, 0) + 1
            );
        }

        for (String cName : completion) {
            int incompleteCnt = participantMap.get(cName);
            if(incompleteCnt == 1){
                participantMap.remove(cName);
            }else{
                participantMap.put(
                        cName,
                        incompleteCnt - 1
                );
            }
        }
        if (participantMap.size() > 1) {
            throw new IllegalStateException();
        }

        return participantMap.keySet().stream().findFirst().orElseThrow(IllegalStateException::new);
    }
}