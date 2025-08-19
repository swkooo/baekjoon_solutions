import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//딱지놀이
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 라운드마다 a딱지 b딱지 개수 받기
		for (int i = 0; i < N; i++) {
			// a딱지 받기
			String[] a = br.readLine().split(" ");
			int aNum = Integer.parseInt(a[0]);
			int[] aDdakji = new int[4];

			for (int j = 0; j < aNum; j++) {
				aDdakji[Integer.parseInt(a[j + 1]) - 1]++;
			}
			
			// b딱지 받기
			String[] b = br.readLine().split(" ");
			int bNum = Integer.parseInt(b[0]);
			int[] bDdakji = new int[4];

			for (int j = 0; j < bNum; j++) {
				bDdakji[Integer.parseInt(b[j + 1]) - 1]++;
			}
			
			// 승자 체크
			boolean isDraw = true;
			for (int j = 3; j >= 0; j--) {	// 뒤에서부터.. 큰 수부터 체크
				if (aDdakji[j] > bDdakji[j]) {
					sb.append("A\n");
					isDraw = false;
					break;
				}
				else if (bDdakji[j] > aDdakji[j]) {
					sb.append("B\n");
					isDraw = false;
					break;
				}
			}
			if (isDraw) {
				sb.append("D\n");
			}
			
		}
		//출력
		System.out.println(sb);
	}// main
}
