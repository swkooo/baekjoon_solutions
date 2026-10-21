// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 이름과 아이큐를 담을 배열리스트
        ArrayList<String[]> iqArr = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            
            // 첫번째 값은 일단 추가
            if (i == 0) {
                iqArr.add(temp);
            }
            else {
                // 이전에 넣었던 값들 하나씩 꺼내서 비교해보기
                for (int j = 0; j < i; j++) {
                    int check = Integer.parseInt(iqArr.get(j)[1]);
                    
                    // 꺼낸 값이 현재 값보다 작다면
                    if (Integer.parseInt(temp[1]) > check) {
                        iqArr.add(j, temp); // 꺼낸 값 앞에 추가
                        break;
                    }
                    // break에 걸리지 않고 모든 값이 현재 값보다 크면
                    iqArr.add(temp);        // 마지막에 추가
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(iqArr.get(i)[0]).append("\n");
        }
        
        System.out.println(sb); 
    }
}