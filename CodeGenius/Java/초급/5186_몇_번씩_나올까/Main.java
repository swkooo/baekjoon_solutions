// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] cntArr = new int[10];
        
        for (int i = 1; i <= N; i++) {
            String temp = i + "";
            char[] numArr = temp.toCharArray();
            for (char num : numArr) {
                cntArr[num - 48]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int cnt : cntArr) {
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }
}