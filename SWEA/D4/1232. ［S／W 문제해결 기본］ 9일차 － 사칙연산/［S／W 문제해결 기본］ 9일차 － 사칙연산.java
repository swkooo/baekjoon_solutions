import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//1232. [S/W 문제해결 기본] 9일차 - 사칙연산
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 총 10개의 테스트 케이스가 주어진다. (총 테스트 케이스의 개수는 입력으로 주어지지 않는다)
		 * 
		 * 각 테스트 케이스의 첫 줄에는 정점의 개수 N(1≤N≤1000)이 주어진다. 그다음 N 줄에 걸쳐 각 정점의 정보가 주어진다.
		 * 
		 * 정점이 정수면 정점 번호와 양의 정수가 주어지고, 정점이 연산자이면 정점 번호, 연산자, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점
		 * 번호가 차례대로 주어진다.
		 * 
		 * 정점 번호는 1부터 N까지의 정수로 구분된고 루트 정점의 번호는 항상 1이다.
		 * 
		 * 위의 예시에서, 숫자 4가 7번 정점에 해당하면 “7 4”으로 주어지고, 연산자 ‘/’가 2번 정점에 해당하면 두 자식이 각각 숫자 9인
		 * 4번 정점과 연산자 ‘-’인 5번 정점이므로 “2 / 4 5”로 주어진다.
		 * 
		 * [출력]
		 * 
		 * 각 테스트케이스마다 '#t'(t는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 사칙연산을 계산한 결과값을 출력한다.
		 * 
		 * 결과값은 소수점 아래는 버리고 정수로 출력한다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			String[][] tree = new String[N+1][3];	// 0은 데이터, 1은 왼쪽, 2는 오른쪽 자식
			for (int i = 0; i < N; i++) {
				String[] node = br.readLine().split(" ");
				int idx = Integer.parseInt(node[0]);
				tree[idx][0] = node[1];
				if (node.length == 4) {
					tree[idx][1] = node[2];
					tree[idx][2] = node[3];					
				}
				
			}
			
			//후위연산식으로 바꾼 후 사칙연산 실행
			postCal(1, tree);
			
			//출력
			System.out.printf("#%d %.0f\n", test_case, arrDeq.pop());
			
		}//tc
	}//main
	
	//스태틱하게 밖에 스택 생성
	static ArrayDeque<Double> arrDeq = new ArrayDeque<>();
	
	
	// 후위 순회 (LRV)
	// v: 현재 노드의 번호!
	public static void postCal(int root, String[][] tree) {
		// v is not null; //일단 go!로직
		
		
		if (root < tree.length && tree[root][0] != null) { //&& 순서 중요!!! 바꾸면 에러 발생
			
			String lChild = tree[root][1];
			String rChild = tree[root][2];
			
			//왼쪽 오른쪽 자식이 있을 경우에 처리
			if (lChild != null) {
			    int leftChild = Integer.parseInt(lChild);
			    postCal(leftChild, tree);
			}

			if (rChild != null) {
			    int rightChild = Integer.parseInt(rChild);
			    postCal(rightChild, tree);
			}
			//방문처리 연산시행		
			String data = tree[root][0];
			
			if (data.equals("+")) {
				Double A = arrDeq.pop();
				Double B = arrDeq.pop();
				arrDeq.push(B + A);
			}
			else if(data.equals("-")) {
				Double A = arrDeq.pop();
				Double B = arrDeq.pop();
				arrDeq.push(B - A);
			}
			else if (data.equals("*")) {
				Double A = arrDeq.pop();
				Double B = arrDeq.pop();
				arrDeq.push(B * A);
			}
			else if (data.equals("/")) {
				
				Double A = arrDeq.pop();
				Double B = arrDeq.pop();
				
				arrDeq.push(B / A);
			}
			//숫자일 경우
			else {
				arrDeq.push(Double.parseDouble(data));
			}
		}
	}
}