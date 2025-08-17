import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1208. [S/W 문제해결 기본] 1일차 - Flatten 다시 풀어보기...
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <=  10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			
			String[] line = br.readLine().split(" ");
			
			int[] box = new int[100];
			
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(box);
			
			for (int i = 0; i < dump; i++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
		
			sb.append("#"+ tc + " " + (box[99] - box[0]) + "\n");
		}//tc
		//출력
		System.out.println(sb);
	}//main
}
