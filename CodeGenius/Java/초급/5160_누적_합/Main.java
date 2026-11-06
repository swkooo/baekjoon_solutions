// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int treeSize = 0;   // 전체 누적합 트리 사이즈
        int len = 1;        // 입력값을 받을 초기배열 길이
        while (len < N) {
            treeSize++;
            len *= 2;
        }
        
        // 누적합 트리 배열로 만들기
        int[] tree = new int[(int) Math.pow(2, treeSize + 1)];
        
        // 배열의 끝부분에 입력값 담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[len + i] = Integer.parseInt(st.nextToken());
        }
        
        // 뒤에서부터 누적합 트리 채우기
        for (int i = len - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        } 
        
        // 피라미드식 출력을 위해 2의 거듭제곱일 경우 개행
        StringBuilder sb = new StringBuilder();
        int temp = 2;
        for (int i = 1; i < tree.length; i++) {
            if (i == temp) {
                sb.append("\n");
                temp *= 2;
            }
            sb.append(tree[i]).append(" ");
        }
        System.out.println(sb);
    }
}