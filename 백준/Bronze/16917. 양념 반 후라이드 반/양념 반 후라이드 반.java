import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//양념 반 후라이드 반
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int A = Integer.parseInt(line[0]);
		int B = Integer.parseInt(line[1]);
		int C = Integer.parseInt(line[2]);
		int X = Integer.parseInt(line[3]);
		int Y = Integer.parseInt(line[4]);

		// 양념, 후라이드 주문 개수 중 겹치는 개수.. 즉 반반 주문 가능 개수
		int minNum = Math.min(X, Y);

		int noHalf = (X * A) + (Y * B);

		int yesHalf = ((X - minNum) * A) + ((Y - minNum) * B) + (minNum * 2 * C);
		
		int minPrice = Math.min(noHalf, yesHalf);
		
		// 반반이 너무 싸서 그냥 전부 반반으로 시켜버릴 수도 있다..
		int allHalf = Math.max(X, Y) * C * 2;

		// 반반섞을 때와 그냥 시킬 때의 가격 비교해서 최솟값 출력
		
		System.out.println(Math.min(minPrice, allHalf));

	}// main
}
