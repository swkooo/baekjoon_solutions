import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int[][] graph = new int[n + 1][n + 1];
        
        for (int[] w : wires) {
            graph[w[0]][w[1]] = 1;
            graph[w[1]][w[0]] = 1;
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int[] w : wires) {
            int v1 = w[0];
            int v2 = w[1];
            
            // 전선 끊기
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            
            // BFS 탐색
            int cnt = 1;
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            
            dq.offer(1);
            visited[1] = true;
            
            while (!dq.isEmpty()) {
                int check = dq.poll();
                for (int next = 1; next <= n; next++) {
                    // 연결되어 있고 방문하지 않았다면
                    if (graph[check][next] == 1 && !visited[next]) {
                        cnt++;
                        visited[next] = true;
                        dq.offer(next);
                    }
                }
            }
            
            minDiff = Math.min(minDiff, Math.abs(n - 2 * cnt));
            
            // 전선 복구
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        return minDiff;
    }
}