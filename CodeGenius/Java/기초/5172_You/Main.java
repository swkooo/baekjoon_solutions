// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        
        if (A.equals("You")) {
            System.out.println("Me");
        }
        else {
            System.out.println("No");
        }
    }
}