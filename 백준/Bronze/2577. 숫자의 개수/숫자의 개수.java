import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//숫자의 개수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Long A = Long.parseLong(br.readLine());
		Long B = Long.parseLong(br.readLine());
		Long C = Long.parseLong(br.readLine());
		
		String multiple = String.valueOf(A * B * C);
		
		int[] num = new int[10];
		
		for(char c : multiple.toCharArray()) {
			num[c - '0']++;
		}
		
		for(int n : num) {
			System.out.println(n);
		}
	}//main
}
