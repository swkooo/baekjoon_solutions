// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(br.readLine());
        
        char grade = 'D';
        
        if (weight >= 200) {
            grade = 'A';
        }
        else if (weight >= 180) {
            grade = 'B';
        }
        else if (weight >= 150) {
            grade = 'C';
        }

        System.out.println(grade); 

    }
}