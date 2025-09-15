import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
//4070. [Professional] 타일링
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
         
        // 사실상 주어진 숫자 N을 1과 2를 더해서 만드는 방법과 똑같음 -> 1에서 2를 더하는방법 + 2에서 1을 더하는 방법
        BigInteger[] tile = new BigInteger[250];
        tile[0] = BigInteger.ONE;   // 1
        tile[1] = BigInteger.valueOf(3);    // 1+1, 2 -> 1 + 1 * 2(2를 만드는 방법 2가지)
//          tile[2] = 3;    // 1+2, 1+1+1, 2+1 -> tile[0] * 2 + tile[1]
//          tile[3] = 5;    // 1+1+2, 2+2, 1+2+1, 1+1+1+1, 2+1+1 -> 같은 방식으로...
         
        // 미리 250까지배열 만들어두고 값만 가져오기
        for (int i = 2; i < 250; i++) {
            tile[i] = tile[i - 1].add(tile[i - 2].multiply(BigInteger.valueOf(2)));
        }
         
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
             
            sb.append("#" + tc + " " + tile[N - 1] + "\n");
        }//tc
        System.out.println(sb);
         
    }//main
}