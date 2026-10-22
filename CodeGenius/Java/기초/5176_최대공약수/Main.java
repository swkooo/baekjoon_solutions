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
        
        int lower = Math.min(N, M);
        
        int answer = 1;
        for (int i = 2; i < lower; i++) {
            if (N % i == 0 & M % i == 0) {
                answer = i;
            }
        }
        
        System.out.println(answer);

    }
}