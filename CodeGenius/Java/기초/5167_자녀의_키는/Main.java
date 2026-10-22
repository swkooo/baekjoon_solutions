// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        System.out.println((F + M) / 2); 

    }
}