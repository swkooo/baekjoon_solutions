import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//빅데이터? 정보보호!
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] line = br.readLine().toCharArray();
		
		int bCnt = 0;
		int sCnt = 0;
		for(char ch : line) {
			if (ch == 'b') {
				bCnt++;
			}
			if (ch == 's') {
				sCnt++;
			}
		}
		
		if (bCnt > sCnt) {
			System.out.println("bigdata?");
		}
		else if(bCnt < sCnt) {			
			System.out.println("security!");
		}
		else {
			System.out.println("bigdata? security!");
		}
	}//main
}
