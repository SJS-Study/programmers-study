//
//  WordConversion.swift
//  Algorithm
//
//  Created by 오현식 on 9/7/25.
//

// 코딩테스트 연습 > 깊이/너비 우선 탐색 > 단어 변환
func wordConversion(_ begin: String, _ target: String, _ words: [String]) -> Int {
    // target이 words 배열에 포함되지 않으면, 0 리턴
    guard words.contains(target) else { return 0 }
    
    // 방문 여부 체크
    var queue: [(String, Int)] = [(begin, 0)]
    var visited: Set<String> = [begin]
    
    // 두 단어가 한 글자만 다른지 판별하는 함수
    func differsByOne(_ first: String, _ second: String) -> Bool {
        guard first.count == second.count else { return false }

        var differ = 0
        var index = first.startIndex
        while index < first.endIndex {
            if first[index] != second[index] {
                differ += 1
                if differ > 1 { return false }
            }
            index = first.index(after: index)
        }

        return differ == 1
    }
    
    // 방문할 문자가 아직 남았다면, 루프
    while queue.isEmpty == false {
        let (currentWord, currentSteps) = queue.removeFirst()
        // 현재 문자가 target과 같으면 현재 변환한 수 반환
        if currentWord == target { return currentSteps }
        
        // words 배열안에서 현재 단어와 한 글자만 다른 단어 찾기
        for word in words {
            if visited.contains(word) == false && differsByOne(currentWord, word) {
                visited.insert(word)
                queue.append((word, currentSteps + 1))
            }
        }
    }
    
    return 0
}
