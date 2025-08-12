import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//카드2
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//큐 만들기
		ArrayDeque<Integer> arrDeq = new ArrayDeque<>();
		
		//큐에 1~N까지 집어넣기
		for (int i = 1; i <= N; i++) {
			arrDeq.offer(i);
		}
		
		int tryCnt = 1;	//시도횟수
		while(N > 1) {
			if (tryCnt % 2 == 1) {	// 2의 배수 시도마다 버리기, 사이즈 감소
				arrDeq.poll();
				N--;
			}
			else {
				arrDeq.offer(arrDeq.poll());	// 아니면 앞에서 꺼내서 뒤에다 다시 넣기
			}
			tryCnt++;	//시도 횟수 증가
		}
		//출력
		System.out.println(arrDeq.poll());
	}//main
}
