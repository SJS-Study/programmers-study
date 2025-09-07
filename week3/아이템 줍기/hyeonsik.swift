//
//  main.swift
//  Algorithm
//
//  Created by 오현식 on 5/19/24.
//

import Foundation

// 코딩테스트 연습 > 깊이/너비 우선 탐색 > 아이템 줍기
func getItem(_ rectangle: [[Int]], characterX: Int, characterY: Int, itemX: Int, itemY: Int) -> Int {
    
    var queue: [(x: Int, y: Int, steps: Int)] = [(characterX, characterY, 0)]
    var visited: Set<String> = ["\(characterX), \(characterY)"]
    
    let directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    // 좌표가 가장자리에 있는 지 확인
    func isOnEdge(_ x: Int, _ y: Int, _ overlapRects: [[Int]]) -> Bool {
        var onEdge = false
        for rect in overlapRects {
            let minX = rect[0]
            let minY = rect[1]
            let maxX = rect[2]
            let maxY = rect[3]
            
            // 직사각형 내부의 좌표일 때, false 리턴
            if (x > minX && x < maxX), (y > minY && y < maxY) { return false }
            
            // 직사각형 가장자리 좌표이 때, onEdge = true
            if x == minX, (y >= minY && y <= maxY) { onEdge = true }
            if x == maxX, (y >= minY && y <= maxY) { onEdge = true }
            if y == minY, (x >= minX && x <= maxX) { onEdge = true }
            if y == maxY, (x >= minX && x <= maxX) { onEdge = true }
        }
        
        return onEdge
    }
    
    func currentRect(_ x: Int, _ y: Int) -> [Int] {
        for rect in rectangle {
            let minX = rect[0]
            let minY = rect[1]
            let maxX = rect[2]
            let maxY = rect[3]
            
            if (x >= minX && x <= maxX), (y >= minY && y <= maxY) {
                return rect
            }
        }
        
        return []
    }
    
    func overlapRects(_ x: Int, _ y: Int, currentRect: [Int]) -> [[Int]] {
        var overlaps = [[Int]]()
        for rect in rectangle {
            let minX = rect[0]
            let minY = rect[1]
            let maxX = rect[2]
            let maxY = rect[3]
            
            if (minX < currentRect[2]) &&
                (maxX > currentRect[0]) &&
                (minY < currentRect[3]) &&
                (maxY > currentRect[1]) {
                
                overlaps.append(rect)
            }
        }
        
        return overlaps
    }
    
    while queue.isEmpty == false {
        let current = queue.removeFirst()
        if current.x == itemX && current.y == itemY {
            return current.steps
        }
        
        let currentRect = currentRect(current.x, current.y)
        let overlapRects = overlapRects(current.x, current.y, currentRect: currentRect)
        
        for direction in directions {
            let nextX = current.x + direction.0
            let nextY = current.y + direction.1
            let key = "\(nextX), \(nextY)"
            
            if isOnEdge(nextX, nextY, overlapRects), visited.contains(key) == false {
                visited.insert(key)
                queue.append((nextX, nextY, current.steps + 1))
            }
        }
    }
    
    return 0
}

// print(getItem([[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]], characterX: 1, characterY: 3, itemX: 7, itemY: 8))
// print(getItem([[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]], characterX: 9, characterY: 7, itemX: 6, itemY: 1))
// print(getItem([[1,1,5,7]], characterX: 1, characterY: 1, itemX: 4, itemY: 7))
// print(getItem([[2,1,7,5],[6,4,10,10]], characterX: 3, characterY: 1, itemX: 7, itemY: 10))
print(getItem([[2,2,5,5],[1,3,6,4],[3,1,4,6]], characterX: 1, characterY: 4, itemX: 6, itemY: 3))
