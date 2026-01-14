import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//OX 퀴즈
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			char[] arr = br.readLine().toCharArray();
			
			int score = 0;
			int sum = 0;
			for(char ch : arr) {
				if(ch == 'O') {
					score++;
				}
				else {
					score = 0;
				}
				sum += score;
			}
			sb.append(sum).append("\n");
		}//tc
		System.out.println(sb);
	}//main
}
