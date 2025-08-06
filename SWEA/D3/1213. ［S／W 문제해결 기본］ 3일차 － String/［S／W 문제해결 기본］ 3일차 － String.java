import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
 
//1213. [S/W 문제해결 기본] 3일차 - String
class Solution {
    public static void main(String args[]) throws Exception {
        /*
         * [입력]
         * 
         * 각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 찾을 문자열, 그 다음 줄에는 검색할 문장이 주어진다.
         * 
         * [출력]
         * 
         * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
         */
        Scanner sc = new Scanner(System.in);
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            String T = sc.nextLine();
            String pattern = sc.nextLine();
            String line = sc.nextLine();
 
            // 길이를 뽑아내자
            int N = pattern.length();
            int M = line.length();
            int cnt = 0;	// 찾고자 하는 문자열이 있는 개수
            for (int i = 0; i < M - N + 1; i++) {
                int charCnt = 0;
                for (int j = 0; j < N; j++) {
                    if (line.charAt(i + j) != pattern.charAt(j)) {
                        break;	// 일치하지 않으면 break
                    }
                    charCnt++; // 일치할 경우 charCnt 증가
                }
                if (charCnt == N) {
                    cnt++; // 일치한 char 개수가 찾고자 한 문자열의 길이와 같을 경우 cnt 증가
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        } // tc
    }// main
}