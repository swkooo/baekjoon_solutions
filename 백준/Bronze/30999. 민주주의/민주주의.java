import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int problemNum = 0;
		for (int i = 0; i < N; i++) {
			int oNum = 0;	// 찬성하는 사람 수 세기
			char[] line = br.readLine().toCharArray();
			for(char ch : line) {
				if (ch == 'O') {
					oNum++;
				}
			}
			if (oNum > M / 2) {
				problemNum++;
			}
		}
		System.out.println(problemNum);
		
	}//main
}
