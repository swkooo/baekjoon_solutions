// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        String name = st.nextToken(); 

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String check = st.nextToken();
            if (check.equals(name)) {
                System.out.println(i + 1);
                break;
            }
        }

    }
}