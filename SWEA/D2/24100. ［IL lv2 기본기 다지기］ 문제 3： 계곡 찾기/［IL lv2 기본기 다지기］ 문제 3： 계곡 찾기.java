import java.util.Scanner;
import java.io.FileInputStream;
 
//24100. [IL lv2 기본기 다지기] 문제 3: 계곡 찾기
class Solution {
    public static void main(String args[]) throws Exception {
        /*
         * 문제 설명 N×N 크기의 지도에서 각 셀은 산의 높이를 나타낸다. 한 셀이 상하좌우 인접한 셀(존재하는 경우)보다 낮다면 그 셀을
         * “계곡”이라 한다. 지도에 있는 계곡의 개수를 구하는 프로그램을 작성하라. (*이 때에 가장자리에 해당되는 셀은 비교하지 않고 건너뛰도록
         * 한다)
         * 
         * 
         * 입력
         * 
         * 첫 줄에 테스트 케이스 T가 주어진다. 각 테스트 케이스의 첫 줄에 자연수 N (1 ≤ N ≤ 100)이 주어진다. 이후 N개의 줄에
         * N개의 정수가 공백으로 구분되어 주어진다. (높이: 1 이상 1000 이하)
         * 
         * 출력 각 테스트 케이스마다 “#테스트케이스번호 계곡개수” 형식으로 출력한다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
 
            // 배열 입력받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            // 델타 탐색
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
 
            int cnt = 0;
            // idx 1~N-1 사이값으로 설정해서 가장자리 제외
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    boolean isLowest = true; // 디폴트 값은 일단 가장 낮다
                    for (int d = 0; d < 4; d++) {
                        if (arr[i][j] >= arr[i + dr[d]][j + dc[d]]) {
                            isLowest = false; // 상하좌우에 더 낮은 값 있으면 false로 변환
                            break; // false가 되면 굳이 더 탐색 필요 X
                        }
                    }
                    // 델타 탐색이 끝났는데도 true면 cnt 증가
                    if (isLowest) {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);
 
        } // tc
    }// main
}