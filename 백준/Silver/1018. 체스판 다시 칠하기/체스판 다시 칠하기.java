import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//체스판 다시 칠하기...2번째 도전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        
        char[][] board = new char[N][M];
        
        for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // (i, j)를 시작점
                int countW = 0; // W로 시작하는 경우
                int countB = 0; // B로 시작하는 경우

                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        char check = board[i + y][j + x];

                        // W로 시작하는 체스판 기준
                        if ((y + x) % 2 == 0) { // 짝수 번째 칸
                            if (check != 'W') countW++;
                        } else { // 홀수 번째 칸
                            if (check != 'B') countW++;
                        }

                        // B로 시작하는 체스판 기준
                        if ((y + x) % 2 == 0) { // 짝수 번째 칸
                            if (check != 'B') countB++;
                        } else { // 홀수 번째 칸
                            if (check != 'W') countB++;
                        }
                    }
                }
                
                min = Math.min(min, Math.min(countW, countB));
            }
        }
        
        System.out.println(min);
    }//main
}