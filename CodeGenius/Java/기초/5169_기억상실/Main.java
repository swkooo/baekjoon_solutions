// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        
        long day = (N - A) / (A - B) + 1;
        
        if ((N - A) % (A - B) != 0) {
            day++;
        }
        
        System.out.println(day);

    }
}