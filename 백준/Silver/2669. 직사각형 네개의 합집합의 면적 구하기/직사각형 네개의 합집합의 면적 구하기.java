import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//직사각형 네개의 합집합의 면적 구하기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//중복되는 칸 제외하기 위해 set
		Set<String> squareSet = new HashSet<>();
		
		//입력은 4줄
		for (int i = 0; i < 4; i++) {
			String[] line = br.readLine().split(" ");
			
			//좌표값 받기
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);
			
			//좌표값 기준으로 한칸 한칸씩 해당되는 부분 set에 넣기
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					//편하게 구분짓기 위해 string으로 변환해서 붙여넣기
					String square = String.valueOf(j) + String.valueOf(k);
					squareSet.add(square);
				}
			}
		}
		
		//총 넓이는 set의 크기!
		System.out.println(squareSet.size());
	}//main
}
