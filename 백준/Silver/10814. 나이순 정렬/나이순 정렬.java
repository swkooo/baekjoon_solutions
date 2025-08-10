import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//나이순 정렬
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			list.add(line.split(" "));
		}
		list.sort(Comparator.comparingInt(a -> Integer.parseInt(a[0])));
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i)[1]);
//		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)[0]).append(' ').append(list.get(i)[1]).append('\n');
		}
		System.out.print(sb);			
	}//main
}
