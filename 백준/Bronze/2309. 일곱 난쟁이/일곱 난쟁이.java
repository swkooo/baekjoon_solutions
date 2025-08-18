import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//일곱 난쟁이
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// int쓰면 나중에 list에서 값 제거할 때 인덱스랑 겹쳐서 안되던데.. 다른 방법 있나?
		List<Long> dwarf = new ArrayList<>();
		
		// 난쟁이 9명 받기, 전체 키 합 구하기
		long sum = 0L;
		for (int i = 0; i < 9; i++) {
			long height = Long.parseLong(br.readLine());
			dwarf.add(height);
			sum += height;
		}
		
		// 9명의 키 합에서 100을 빼면 스파이 2명의 키 합이 나온다.
		long spyHeights = sum - 100;
		
		// spyHeights에서 1명의 키를 뺐을 때 나머지 1명의 키가 있다면 금마가 스파이
		for (long num : dwarf) {
			long check = spyHeights - num;
			if (num != check && dwarf.contains(check)) {	// 전부 키가 다르다고 했으므로 같은 사람 체크 X
				dwarf.remove(num);	//둘다 나가
				dwarf.remove(check);
				break;
			}
		}
		
		// 오름차순 정렬
		Collections.sort(dwarf);
		
		//출력
		for (long num : dwarf) {
			sb.append((int) num + "\n");
		}
		
		System.out.println(sb);
	}// main
}
