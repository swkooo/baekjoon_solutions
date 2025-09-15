import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1970. 쉬운 거스름돈
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + "\n");
			
			int N = Integer.parseInt(br.readLine());
			
			//이걸 dp로 왜풀어...
			int[] changes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			// 그리디하게 나눈 몫 sb 에 넣고 나머지 계속 계산하기
			for (int change : changes) {
				sb.append(N / change + " ");
				N = N % change;
			}
			sb.append("\n");
		}//tc
		System.out.println(sb);
	}//main
}
