import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//ATM
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");
		
        //String 문자열 그대로 쓰면 10이 2보다 작기때문에 무조건 변환해줘야 함
		int[] numArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(line[i]);
		}
		
		Arrays.sort(numArr);
				
		int sum = 0;
		for (int i = 0; i < N; i++) {
			
			//결국 크기순으로 sort해서 X N, X N-1, ... X 1하는거랑 같음
			sum += numArr[i] * (N - i);
		}
		
		System.out.println(sum);
	}// main
}

