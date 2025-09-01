import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열을 만들어요
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		if(line.contains("gori"))
			System.out.println("YES");
		else
			System.out.println("NO");
	}//main
}
