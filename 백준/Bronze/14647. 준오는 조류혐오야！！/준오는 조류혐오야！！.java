import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//준오는 조류혐오야!!
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int totalSum = 0;
		int max = 0;
		String[][] bingo = new String[n][m];
		for (int i = 0; i < n; i++) {
			bingo[i] = br.readLine().split(" ");
			int sum = 0;
			for (int j = 0; j < m; j++) {
				char[] check = bingo[i][j].toCharArray();
				for(char ch : check) {
					if (ch == '9') {
						sum++;
						totalSum++;
					}
				}
			}
			max = Math.max(max, sum);
		}
		
		for (int j = 0; j < m; j++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				char[] check = bingo[i][j].toCharArray();
				for(char ch : check) {
					if(ch == '9')
						sum++;
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(totalSum - max);
	}//main
}
