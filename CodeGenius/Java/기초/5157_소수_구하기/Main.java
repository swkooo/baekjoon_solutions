// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 소수인 케이스 갯수 세기
        int cnt = 0;
        
        // 1~N까지 숫자 중에
        for (int i = 1; i <= N; i++) {
            // 약수 개수 저장
            int temp = 0;
            // i 를 1 ~ i 값으로 나눴을 때 나머지 체크
            for (int j = 1; j <= i; j++) {
                // 나머지가 0이면(약수) -> temp + 1
                if (i % j == 0) {
                    temp++;
                }
                // 약수가 2개가 넘어가면 stop
                if (temp > 2) {
                    break;
                }
            }
            // 약수가 2개(1과 자기 자신)이면 -> cnt + 1
            if (temp == 2) {
                cnt++;
            }
        }

        System.out.println(cnt); 

    }
}