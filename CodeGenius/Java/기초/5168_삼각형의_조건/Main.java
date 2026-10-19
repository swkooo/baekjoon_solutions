// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        
        for (int i = 0; i < 3; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        
        if (sum == 180) {
            System.out.println("P");
        }
        else {
            System.out.println("F"); 
        }
    }
}