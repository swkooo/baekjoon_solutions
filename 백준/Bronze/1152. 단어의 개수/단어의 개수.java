import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단어의 개수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		//공백문자 제외하고 세기
		int cnt = 0;
		for(String str : line) {
			if (!str.equals("")) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}//main
}
