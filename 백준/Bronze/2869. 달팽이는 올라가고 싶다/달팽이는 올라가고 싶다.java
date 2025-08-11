import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//달팽이는 올라가고 싶다
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		long A = Long.parseLong(line[0]);
		long B = Long.parseLong(line[1]);
		long V = Long.parseLong(line[2]);
		
		
		//아니 while써서 시간초과날거면 그럼 이건 걍 수학적으로 생각하는건데 문제를 이렇게 내는게 맞아?
		int days = (int) ((V - A) / (A - B) + 1);
		
		if ((V - A) % (A - B) != 0) {
			days++;
		}
		
		System.out.println(days);
	}// main
}
