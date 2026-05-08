import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int sum = 0;
        int startIdx = 0;
        int minCnt = Integer.MAX_VALUE;

        for(int i = 0; i < sequence.length; i++) {
            // 1. 큐에 원소를 넣고 sum에 더함
            dq.offer(sequence[i]);
            sum += sequence[i];

            // System.out.println(dq.toString());
            // 2. sum이 k보다 크면 작거나 같아질 때까지 큐에서 원소를 빼고 sum에서 차감
            while(sum > k && !dq.isEmpty()) {
                startIdx++;
                sum -= dq.poll();
            }

            // 3. sum이 k와 같다면 정답 후보 갱신 (큐의 크기가 수열의 길이임)
            if(sum == k && dq.size() < minCnt) {
                answer[0] = startIdx;
                answer[1] = startIdx + dq.size() - 1;
                minCnt = dq.size();
            }
        }
        
        return answer;
    }
}