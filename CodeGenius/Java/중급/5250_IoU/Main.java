// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][4];
        
        //좌표값 입력받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
            // System.out.println(Arrays.toString(arr[i]));
        }
        
        double checkIoU = 0;
        int[] answer = new int[] {1, 2};    //겹치는 사각형이 없더라도 1, 2 번째 쌍 선택하도록
        
        //비교할 첫번째 직사각형 선택
        for (int i = 0; i < N - 1; i++) {
            int x1 = arr[i][0];
            int y1 = arr[i][1];
            int w1 = arr[i][2];
            int h1 = arr[i][3];
            
            //두번째 직사각형 선택
            for (int j = i + 1; j < N; j++) {
                int x2 = arr[j][0];
                int y2 = arr[j][1];
                int w2 = arr[j][2];
                int h2 = arr[j][3];
            
                //겹치는 밑변, 높이 계산
                int overlapW = Math.min((x1 + w1), (x2 + w2)) - Math.max(x1, x2);
                int overlapH = Math.min((y1 + h1), (y2 + h2)) - Math.max(y1, y2);
                
                int overlapArea = 0;
                // 음수값이 아니라면 교집합 존재
                if (overlapW > 0 && overlapH > 0) {
                    overlapArea = overlapW * overlapH;
                }
                
                // 합집합 넓이 계산
                int sumArea = (w1 * h1) + (w2 * h2) - overlapArea;
                
                // 교집합이 0이 아니라면
                if (overlapArea > 0) {
                    double IoU = (double) overlapArea / sumArea;
                    // 기존 IoU와 비교해 큰값으로 바꿈, 정답쌍 갱신
                    if (checkIoU < IoU) {
                        checkIoU = IoU;
                        answer[0] = i + 1;
                        answer[1] = j + 1;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb); 

    }
}