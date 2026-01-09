import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		boolean isAsc = true;
		for (int i = 1; i < 8; i++) {
			if(Integer.parseInt(temp[i - 1]) < Integer.parseInt(temp[i])) {
				continue;
			}
			else {
				isAsc = false;
				break;
			}
		}
		
		boolean isDesc = true;
		
		for (int i = 1; i < 8; i++) {
			if(Integer.parseInt(temp[i - 1]) > Integer.parseInt(temp[i])) {
				continue;
			}
			else {
				isDesc = false;
				break;
			}
		}
		
		if(isAsc) {
			System.out.println("ascending");
		}
		else if(isDesc) {
			System.out.println("descending");
		}
		else {			
			System.out.println("mixed");
		}
		
	}//main
}
