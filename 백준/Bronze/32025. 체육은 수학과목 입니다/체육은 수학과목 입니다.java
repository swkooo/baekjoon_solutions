import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//체육은 수학과목 입니다
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		
		System.out.println(Math.min(H, W) * 100 / 2);
	}
}
