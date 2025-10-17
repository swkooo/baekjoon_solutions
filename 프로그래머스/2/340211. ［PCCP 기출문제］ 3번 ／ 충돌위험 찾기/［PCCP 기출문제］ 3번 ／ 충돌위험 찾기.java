import java.util.*;

class Solution {
    // 델타 탐색: r좌표 우선 규칙에 따라 '상, 하, 좌, 우' 순서로 고정
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};
    // 좌표 최대값 + 1
    public final int MAX_SIZE = 101; 

    public int solution(int[][] points, int[][] routes) {
        // [핵심 자료구조] 시간(t)별로 점유된 좌표와 해당 좌표의 로봇 수를 기록
        // timeOccupied.get(t) -> Map<"r,c", 로봇 수>
        List<Map<String, Integer>> timeOccupied = new ArrayList<>();

        // --- 1단계: 모든 로봇의 전체 경로를 시뮬레이션하여 timeOccupied에 기록 ---
        for (int[] route : routes) {
            int currentTime = 0; // 각 로봇의 누적 시간

            // 로봇의 경로를 구간별로 나누어 처리 (e.g., A->B, B->C, ...)
            for (int i = 0; i < route.length - 1; i++) {
                int startPointId = route[i];
                int endPointId = route[i + 1];

                int[] startCoords = points[startPointId - 1];
                int[] endCoords = points[endPointId - 1];

                // 현재 구간의 최단 경로 계산
                List<int[]> segmentPath = findShortestPath(startCoords, endCoords);

                // 첫 구간(i=0)은 시작점(k=0)부터, 다음 구간부터는 도착점이 겹치므로 이동점(k=1)부터 처리
                int loopStart = (i == 0) ? 0 : 1;

                for (int k = loopStart; k < segmentPath.size(); k++) {
                    int t = currentTime + k;

                    // timeOccupied 리스트가 현재 시간 t를 기록할 수 있도록 확장
                    while (timeOccupied.size() <= t) {
                        timeOccupied.add(new HashMap<>());
                    }

                    int[] currentPos = segmentPath.get(k);
                    String posStr = currentPos[0] + "," + currentPos[1];
                    Map<String, Integer> occupantsAtTime = timeOccupied.get(t);

                    // 현재 시간, 현재 위치의 로봇 수를 1 증가시킴
                    occupantsAtTime.put(posStr, occupantsAtTime.getOrDefault(posStr, 0) + 1);
                }
                
                // 현재 구간에 소요된 시간을 누적 시간에 더함
                currentTime += segmentPath.size() - 1;
            }
        }

        // --- 2단계: 기록된 정보를 바탕으로 위험 상황 카운트 ---
        int answer = 0;
        for (Map<String, Integer> occupantsAtTime : timeOccupied) {
            for (int count : occupantsAtTime.values()) {
                // 한 위치에 2대 이상 있다면 위험 상황으로 카운트
                if (count > 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * BFS를 사용하여 start에서 end까지의 최단 경로를 찾아 리스트로 반환합니다.
     * 델타 배열 순서에 의해 경로는 항상 유일하게 결정됩니다.
     */
    private List<int[]> findShortestPath(int[] start, int[] end) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);

        boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];
        visited[start[0]][start[1]] = true;

        // 경로 역추적을 위한 parent 배열
        int[][][] parent = new int[MAX_SIZE][MAX_SIZE][2];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) {
                break; // 목적지 도착 시 탐색 종료
            }

            for (int d = 0; d < 4; d++) {
                int nextR = curr[0] + dr[d];
                int nextC = curr[1] + dc[d];

                if (nextR >= 1 && nextC >= 1 && nextR < MAX_SIZE && nextC < MAX_SIZE && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC});
                    parent[nextR][nextC] = curr;
                }
            }
        }

        // 경로 역추적 (도착지 -> 출발지)
        List<int[]> path = new ArrayList<>();
        int[] current = end;
        while (current != null) {
            path.add(current);
            if (current[0] == start[0] && current[1] == start[1]) break;
            current = parent[current[0]][current[1]];
        }
        
        // 올바른 순서로 뒤집기 (출발지 -> 도착지)
        Collections.reverse(path);
        return path;
    }
}