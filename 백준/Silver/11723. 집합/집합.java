import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//집합
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");
			String command = line[0];
			
			// add
			if (command.equals("add")) {
				set.add(line[1]);
			}
			// remove.. 없어도 상관 없음
			if (command.equals("remove")) {
				set.remove(line[1]);
			}
			// check
			if (command.equals("check")) {
				if (set.contains(line[1])) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
			// toggle
			if (command.equals("toggle")) {
				if (set.contains(line[1])) {
					set.remove(line[1]);
				} else {
					set.add(line[1]);
				}
			}
			// all... 다른 set만들어서 같다고 두면 참조하기때문에 변경되면 다른set도 같이 변경됨.. 걍 집어넣는게 나음
			if (command.equals("all")) {
				for (int j = 1; j <= 20; j++) {
					set.add(String.valueOf(j));
				}
			}
			// empty
			if (command.equals("empty")) {
				set.clear();
			}
		}
		
		System.out.println(sb);
		
	}// main
}
