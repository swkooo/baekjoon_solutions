import java.util.*;

class Solution {
    public int solution(int[][] land) {
        depth = land.length;
        leng = land[0].length;
        
        visited = new boolean[depth][leng];
        int check = 1;
        Map<Integer, Integer> mapping = new HashMap<>();
        
        for(int i = 0; i < depth; i++) {
            for(int j = 0; j < leng; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    connect = new ArrayList<>();

                    visited[i][j] = true;
                    dq = new ArrayDeque<>();
                    // System.out.println(i + " " + j);

                    int connectCnt = BFS(land, new int[] {i, j});

                    for(int[] temp : connect) {
                        land[temp[0]][temp[1]] = check;
                    }
                    mapping.put(check, connectCnt);                    
                    check++;
                }
            }
        }
        
        int maxCnt = 0;
        for(int j = 0; j < leng; j++) {
            int currCnt = 0;
            Set<Integer> doubtCheck = new HashSet<>();
            for(int i = 0; i < depth; i++) {
                if(land[i][j] != 0 && !doubtCheck.contains(land[i][j])) {
                    doubtCheck.add(land[i][j]);
                    currCnt += mapping.get(land[i][j]);
                }                
            maxCnt = Math.max(maxCnt, currCnt);
            }
        }
        
        int answer = maxCnt;
        return answer;
    }
    
    //델타 탐색.. 상하좌우
    
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    
    public static int depth;
    public static int leng;
    
    public static ArrayDeque<int[]> dq;
    public static boolean[][] visited;
    public static List<int[]> connect;
    
    public int BFS(int[][] land, int[] coord) {
        int cnt = 1;
        
        dq.offer(coord);
        connect.add(coord);
        
        while(!dq.isEmpty()) {
            int[] curr = dq.poll();
            
            for(int d = 0; d < 4; d++) {
                int moveRow = curr[0] + dr[d];
                int moveCol = curr[1] + dc[d];

                if(moveRow >= 0 && moveRow < depth && moveCol >= 0 && moveCol < leng) { // 바운더리
                    if(land[moveRow][moveCol] != 0 && !visited[moveRow][moveCol]) {
                        visited[moveRow][moveCol] = true;
                        int[] move = {moveRow, moveCol};
                        dq.offer(move);
                        connect.add(move);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}