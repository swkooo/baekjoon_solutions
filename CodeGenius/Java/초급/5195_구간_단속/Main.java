// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int meter = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        // 입력값을 받을 str이중배열
        String[][] log = new String[N][2];
        
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            log[i][0] = st.nextToken();
            
            // 출발시간 ":" 기준으로 나눈 후 초단위로 바꿔 저장
            String[] temp = st.nextToken().split(":");
            log[i][1] = (Integer.parseInt(temp[0]) * 3600) + (Integer.parseInt(temp[1]) * 60) + Integer.parseInt(temp[2]) + "";
        }
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String carNum = st.nextToken();
            
            for (int j = 0; j < N; j++) {
                //배열 돌면서 차량번호 같은 값 찾기
                if (log[j][0].equals(carNum)) {
                    int depTime = Integer.parseInt(log[j][1]);
                    
                    // 도착시간도 출발시간처럼 계산
                    String[] temp = st.nextToken().split(":");
                    int arrTime = (Integer.parseInt(temp[0]) * 3600) + (Integer.parseInt(temp[1]) * 60) + Integer.parseInt(temp[2]);
                    int time = arrTime - depTime;
                    
                    // 소수점버리기 위해 미터에 3600 곱해서 나눠주기
                    int speed = (meter * 3600) / time;
                    log[j][1] = speed + "";             // 계산한 속력 덮어씌우기
                }
            }
        }
        
        // log[0] 값 기준으로 작은 순으로 정렬
        Arrays.sort(log, (o1, o2) -> o1[0].compareTo(o2[0]));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(log[i][0]).append(" ").append(log[i][1]).append("\n"); 
        }
        System.out.println(sb);
    }
}