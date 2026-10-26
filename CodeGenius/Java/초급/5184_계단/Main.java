// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 칸마다 움직이는 최소 횟수 저장
        int [] dp = new int[K + 2]; // 혹시 초과될 수 있으므로
        
        dp[N] = 0;
        dp[N + 1] = 3;
        dp[N + 2] = 2;
        
        
        for (int i = N + 3; i < K + 1; i++) {
            int minTemp = Math.min(dp[i - 2] + 2, dp[i - 1] + 3);   // 한칸 전, 두칸 전 최소값 비교
            minTemp = Math.min(minTemp, dp[i - 3] + 1); // 세칸 전 최소값 비교
            
            dp[i] = minTemp;
        }
        
        System.out.println(dp[K]); 

    }
}