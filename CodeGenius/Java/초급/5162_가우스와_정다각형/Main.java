// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long k = Long.parseLong(br.readLine());
        
        int[] fermat = new int[] {3, 5, 17, 257, 65537};
        
        for (int i = 0; i < 5; i++) {
            if (k % fermat[i] == 0) {
                k /= fermat[i];
            }
        }
        
        boolean isPossible = true;
        
        while (isPossible && k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            }
            else {
                isPossible = false;
            }
        }
        
        if (isPossible) {
            System.out.println("YES"); 
        }
        else {
            System.out.println("NO"); 
        }

    }
}