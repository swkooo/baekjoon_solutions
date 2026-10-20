// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int money = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        
        int[] coupon = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        
        for (int i = 0; i < 8; i++) {
            if (money > 0) {
                cnt += money / coupon[i];   // 가장 큰 쿠폰만큼 나누고
                money %= coupon[i];         // money 나머지값으로 갱신
            }
            
        }
        
        System.out.println(cnt); 

    }
}