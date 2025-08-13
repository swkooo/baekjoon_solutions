import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//숫자 카드 2
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//상근이가 가지고 있는 숫자 카드에 대해서...
		int N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		
		Map<Integer, Integer> hasNumMap = new HashMap<>();	// 숫자카드 저장할 map
		for (int i = 0; i < N; i++) {
			int hasNum = Integer.parseInt(line[i]);
			// 만약 map에 num값이 키로 이미 있다면
			if (hasNumMap.containsKey(hasNum)) {
				// value값을 하나 증가시키고 대체한다.
				int curVal = hasNumMap.get(hasNum) + 1;
				hasNumMap.replace(hasNum, curVal);
			}
			// 그렇지 않다면 num을 집어 넣는다.
			else {
				hasNumMap.put(hasNum, 1);
			}
		}
		
		//확인하려는 숫자들에 대해서...
		int M = Integer.parseInt(br.readLine());
		String[] check = br.readLine().split(" ");
		
		for (int i = 0; i < M; i++) {
			int checkNum = Integer.parseInt(check[i]);
			//가지고 있는 숫자들중 확인하려는 숫자가 있다면... map에서 갯수 가져오기
			if (hasNumMap.containsKey(checkNum)) {
				sb.append(hasNumMap.get(checkNum) + " ");
			}
			//가지고 있지 않다면...
			else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}// main
}
