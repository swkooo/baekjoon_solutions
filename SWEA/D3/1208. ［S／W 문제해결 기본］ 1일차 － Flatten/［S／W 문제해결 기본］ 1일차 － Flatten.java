import java.util.Scanner;

//1208. [S/W 문제해결 기본] 1일차 - Flatten
class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] width = new int[100];

        for (int test_case = 1; test_case <= 10; test_case++) {
            int dump = sc.nextInt();

            // 배열입력
            for (int i = 0; i < 100; i++) {
                width[i] = sc.nextInt();
            }

            // dump횟수만큼 반복문
            for (int d = 0; d < dump; d++) {
                int maxIdx = 0;
                int minIdx = 0;

                // 현재 max과 min의 인덱스 찾기
                for (int i = 0; i < 100; i++) {
                    if (width[i] > width[maxIdx]) {
                    	maxIdx = i;
                    }
                    if (width[i] < width[minIdx]) {
                    	minIdx = i;
                    }
                }

                // min-max값 차이가 1이하면 반복문 중지
                if (width[maxIdx] - width[minIdx] <= 1) {
                    break;
                }

                // max값에서 하나 빼고, min값에 하나 더함
                width[maxIdx]--;
                width[minIdx]++;
            }

            // 최종 max - min 계산
            int max = width[0];
            int min = width[0];
            for (int i = 1; i < 100; i++) {
                if (width[i] > max) {
                	max = width[i];
                }
                if (width[i] < min) {
                	min = width[i];
                }
            }

            System.out.println("#" + test_case + " " + (max - min));
        }//tc
    }//main
}
