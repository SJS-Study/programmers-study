//
//  TargetNumber.swift
//  Algorithm
//
//  Created by 오현식 on 9/5/25.
//

// 코딩테스트 연습 > 깊이/너비 우선 탐색 > 타겟 넘버
func targetNumber(_ numbers: [Int], _ target: Int) -> Int {
    
    func dfs(_ index: Int, _ currentSum: Int) -> Int {
        // 배열의 끝에 도달했을 때
        if index == numbers.count {
            // 현재 합과 타겟이 같으면 1 리턴
            return currentSum == target ? 1 : 0
        }
        
        // 현재 숫자를 더할 경우 + 뺄 경우
        return dfs(index + 1, currentSum + numbers[index]) + dfs(index + 1, currentSum - numbers[index])
    }
    
    return dfs(0, 0)
}
