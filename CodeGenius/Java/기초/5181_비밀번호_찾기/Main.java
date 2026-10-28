// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 
        
        // 제출 시에는 이 줄을 주석 처리
        // String testInput = "s a p o a c a s o";
        // System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] line = br.readLine().split(" ");
        
        boolean isOK = false;
        for (String a : line) {
            sb.append(a);
            if (a.equals("c")) {
                break;
            }
            sb.append(" ");
        }
        
        System.out.println(sb); 

    }
}