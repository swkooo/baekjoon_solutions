// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            char[] hole = br.readLine().toCharArray();
            // System.out.println(Arrays.toString(hole));
            
            for (int j = 0; j < 8; j++) {
                // 행과 열의 번호를 더했을 때 2의 배수이면 열린 구멍
                if ((i + j) % 2 == 0 && hole[j] == 'F') {
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);

    }
}