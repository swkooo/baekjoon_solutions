// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        sb.append(Integer.toString(N, 8)).append(" ").append(Integer.toString(N, 16).toUpperCase());

        System.out.println(sb); 

    }
}