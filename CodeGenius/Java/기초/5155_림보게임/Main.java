// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String[] numArr = br.readLine().split(" ");
        
        boolean isPass = true;
        for (int i = 0; i < N; i++) {
            int check = Integer.parseInt(numArr[i]);
            
            if (check <= 160) {
                System.out.println("I " + check);
                isPass = false;
                break;
            }
        }
        
        if (isPass == true) {
            System.out.println("P");
        }
    }
}