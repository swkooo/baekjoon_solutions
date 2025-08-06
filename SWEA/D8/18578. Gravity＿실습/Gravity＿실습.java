import java.util.Scanner;
import java.io.FileInputStream;
 
//18578. Gravity_실습
class Solution {
    public static void main(String args[]) throws Exception {
        /*
         * [제약 사항] 중력은 회전이 완료된 후 적용된다. 상자들은 모두 한쪽 벽면에 붙여진 상태로 쌓여 2차원의 형태를 이루며 벽에서 떨어져서
         * 쌓인 상자는 없다. 방의 세로 길이는 항상 100이다. 즉, 상자는 최소 0, 최대 100 높이로 쌓을 수 있다
         * 
         * [입력] 첫 번째 줄에 테스트 케이스의 수 T가 주어진다. 각 테스트 케이스의 첫 줄에는 방의 가로길이가 주어지고 그 다음 줄부터는
         * 쌓여있는 상자의 수가 주어진다.
         * 
         * [출력] #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int width = sc.nextInt();
            int[] arr = new int[width];
            for (int i = 0; i < width; i++) {
                arr[i] = sc.nextInt();
            } // 배열 입력받기
                /////////////////////////////////////////////////////
                // 로직띵킹: 입력받은 배열의 인덱스와 그 뒤의 인덱스 숫자들과 비교해서 같거나 큰값을 빼면 되지 않을까?
                // 이중포문 쓰고 앞에서 하나씩 다음 인덱스랑 비교해가면 될듯?
            int max = 0;
 
            for (int i = 0; i < width; i++) {
                int cnt = 0;
                int gravityNum = 0;
 
                for (int j = i + 1; j < width; j++) {
                    if (arr[i] <= arr[j]) {
                        cnt++;
                    }
                }
                gravityNum = width - (i + 1) - cnt;
                if (max < gravityNum) {
                    max = gravityNum;
                }
            }
             
            System.out.println("#" + test_case + " " + max);
 
        } // tc
    }// mc
}