import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//스택
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> arrDeq = new ArrayDeque<>(); 
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			
			//push
			if (line[0].equals("push")) {
				arrDeq.push(Integer.parseInt(line[1]));
			}
			//pop
			if (line[0].equals("pop")) {
				if (arrDeq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(arrDeq.pop());
				}
			}
			//size
			if (line[0].equals("size")) {
				System.out.println(arrDeq.size());
			}
			//empty
			if (line[0].equals("empty")) {
				if (arrDeq.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			//top
			if (line[0].equals("top")) {
				if (arrDeq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(arrDeq.peek());;
				}
			}
		}
		
	}//main
}
