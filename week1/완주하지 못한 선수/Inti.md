## 성일
- 완주하지 못한 선수
  1. 메서드로 추출 시 매서드 이름을 의미 있게 작성해보는 것도 좋아요. ex) countCompletion()
  2. ```java
            if(map.containsKey(person)){
                int data = map.get(person);
                data++;
                map.put(person , data);
            }else{
                map.put(person , 1);
            }
            //위 코드는 아래 코드로 간단히 표현할 수 있어요
            map.put(person, map.getOrDefault(person, 0) + 1);
        ```
  3. `return "error";` 대신 예외를 던지는 것도 좋은 방법이에요.

## 세은
- 완주하지 못한 선수
  1. ```java
      for (String c : completion)
        map.put(c, map.get(c) - 1);
     //이 부분에서 개수가 0이면 삭제할 경우 마지막에 검색 속도를 빠르게 할 수 있을 것 같아요.
``` 