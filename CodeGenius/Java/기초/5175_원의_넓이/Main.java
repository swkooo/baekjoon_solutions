// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        double answer = N * N * 3.14;
        answer = Math.round(answer * 100) / 100.0;
        
        if(answer % 1 == 0) {
            System.out.println((int) answer);
        }
        else {
            System.out.println(answer); 
        }

    }
}