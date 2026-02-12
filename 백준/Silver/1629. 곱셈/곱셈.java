import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        
        long A = Long.parseLong(line[0]);
        long B = Long.parseLong(line[1]);
        long C = Long.parseLong(line[2]);
        
        // 과정을 저장할 리스트
        // 1: 홀수였음(A 곱해야 함), 0: 짝수였음(제곱만 하면 됨)
        ArrayList<Long> binarySteps = new ArrayList<>();
        
        // 1. 분할 과정 (B가 1이 될 때까지 반으로 쪼개며 나머지 저장)
        long tempB = B;
        while(tempB > 1) {
            binarySteps.add(tempB % 2);
            tempB /= 2;
        }
        
        // 2. 정복 과정 (역순으로 계산)
        long rest = A % C; // 초기값은 A^1
        
        // 리스트를 거꾸로 돌면서 수행
        for (int i = binarySteps.size() - 1; i >= 0; i--) {
            // 제곱을 먼저 수행
            rest = (rest * rest) % C;
            
            // 그 다음에 나머지가 1이었다면 A를 곱함
            if (binarySteps.get(i) == 1) {
                rest = (rest * A) % C;
            }
        }
        
        System.out.println(rest);
    }
}