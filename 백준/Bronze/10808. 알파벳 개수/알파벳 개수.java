import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] S = br.readLine().toCharArray();
		
		int[] alph = new int[26];
		
		for(char c : S) {
			alph[c - 97]++;
		}
		
		for(int i : alph) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}//main
}
