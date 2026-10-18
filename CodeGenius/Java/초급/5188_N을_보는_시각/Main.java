// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        
        int answer = 0;
        
        //시
        for (int h = 0; h < 24; h++) {
            String hour = h + "";
            //분
            for (int m = 0; m < 60; m++) {
                String minute = m + "";
                //초
                for (int s = 0; s < 60; s++) {
                    String seccond = s + "";
                    
                    // 시분초에 N이라는 문자가 포함된다면 + 1
                    if (hour.contains(N) || minute.contains(N) || seccond.contains(N)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer); 

    }
}