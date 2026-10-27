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
        
        int[][] palace = new int[N][M];
        // 행에 필요한 기둥 개수 저장
        int rowNeed = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 각행에 최소 1개 이상의 기둥이 존재하는지 체크
            boolean isOk = false;
            for (int j = 0; j < M; j++) {
                palace[i][j] = Integer.parseInt(st.nextToken());
                if (palace[i][j] == 0) {
                    isOk = true;        // 배열 입력을 받아야하므로 break 사용안함
                }
            }
            // 행에 기둥이 하나도 없으면
            if (isOk == false) {
                rowNeed++;
            }
        }
        
        // 열에 필요한 기둥 개수 저장
        int colNeed = 0;
        for (int j = 0; j < M; j++) {
            // 각 열에 최소 1개 이상의 기둥이 존재하는지 체크
            boolean isOk = false;
            for (int i = 0; i < N; i++) {
                if (palace[i][j] == 0) {
                    isOk = true;
                    break;
                }
            }
            // 열에 기둥이 하나도 없으면
            if (isOk == false) {
                colNeed++;
            }
        }
        
        // 행과 열에 공통으로 기둥이 없는 곳에 세우고 추가로 세우면 되므로 둘 중 max값이 정답
        int answer = Math.max(rowNeed, colNeed);

        System.out.println(answer);

    }
}