import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사과
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int school = Integer.parseInt(line[0]);
			int student = Integer.parseInt(line[1]);
			
			sum += student % school;
		}
		System.out.println(sum);
	}
}
