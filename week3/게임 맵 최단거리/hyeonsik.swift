//
//  MapforShortestDist.swift
//  Algorithm
//
//  Created by 오현식 on 9/7/25.
//

// 코딩테스트 연습 > 깊이/너비 우선 탐색 > 게임 맵 최단거리
func mapforShortestDist(_ maps: [[Int]]) -> Int {
    let rows = maps.count - 1
    let cols = maps[0].count - 1
    // 상대 진영에 도댤할 수 없을 때, -1 리턴
    if (maps[rows - 1][cols] == 0 && maps[rows][cols - 1] == 0) || (maps[0][1] == 0 && maps[1][0] == 0) {
        return -1
    }
    
    var queue: [(row: Int, col: Int, steps: Int)] = [(0, 0, 1)]
    var visited: Set<String> = ["0, 0"]
    
    // 이동할 수 있는 방향
    let directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    // 이동할 수 있는 범위는 최소/최대 넘지 않고 벽이 아닐 때
    func toMove(_ row: Int, _ col: Int) -> Bool {
        return row >= 0 && row <= rows && col >= 0 && col <= cols && maps[row][col] == 1
    }
    
    // 방문할 문자가 아직 남았다면, 루프
    while queue.isEmpty == false {
        let current = queue.removeFirst()
        // 상대 진영에 도착했다면, 현재 거리 리턴
        if current.row == rows && current.col == cols {
            return current.steps
        }
        
        // 움직일 수 있는 방향에서 이동할 수 있는 좌표 찾기
        for direction in directions {
            let nextRow = current.row + direction.0
            let nextCol = current.col + direction.1
            let key = "\(nextRow), \(nextCol)"
            
            if toMove(nextRow, nextCol), visited.contains(key) == false {
                visited.insert(key)
                queue.append((nextRow, nextCol, current.steps + 1))
            }
        }
    }
    
    return -1
}
