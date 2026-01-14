import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//나머지
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> rest = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			int temp = Integer.parseInt(br.readLine());
			rest.add(temp % 42);
		}
		
		System.out.println(rest.size());
	}
	
	
}
