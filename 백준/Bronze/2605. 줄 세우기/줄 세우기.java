import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//줄 세우기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		
		List<Integer> orderList = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(line[i - 1]);
			
			if (num == 0) {
				orderList.add(i);
			}
			else {
				orderList.add(i - 1 - num, i);
			}
			
		}
		
		for(int i : orderList) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}//main
}
