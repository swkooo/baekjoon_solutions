// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        
        // 학생 입력받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(line[j]);
            }
            // System.out.println(Arrays.toString(room[i]));
        }
        
        // 최대 사각형 길이를 저장
        int maxNum = 0;
        
        // 교실배열순회
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++){
                int checkNum = room[i][j];
                
                for (int r = i + 1; r < N; r++) {
                    for (int c = j + 1; c < M; c++) {
                        
                        // 선택한 한 점에 대해서 정사각형이 되는 반대 꼭지점 체크
                        if ((r - i) == (c - j) && room[r][c] == checkNum) {
                            
                            // 두 점이 같다면 나머지 점들도 체크
                            if (room[i][c] == checkNum && room[r][j] == checkNum) {
                                
                                // 최대값 갱신
                                maxNum = Math.max(maxNum, (r - i + 1));
                            }
                        }
                    }
                }
                
            }
        }
        
        // 넓이 출력
        System.out.println(maxNum * maxNum);
    }// main
}