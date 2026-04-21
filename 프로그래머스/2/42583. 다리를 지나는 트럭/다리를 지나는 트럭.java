import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int truck_nums = truck_weights.length;
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int currWeight = truck_weights[0];
        int currNum = 0;
        int totalTime = 1;
        
        dq.offer(new int[] {truck_weights[currNum], 0});
        
        while(!dq.isEmpty()) {
            
            int size = dq.size();
            for(int i = 0; i < size; i++) {
                int[] check = dq.poll();
                if(check[1] + 1 == bridge_length) {
                    currWeight -= check[0];
                }
                else {
                    check[1]++;
                    dq.offer(check);
                }
            } //다리진행
            
            if(currNum + 1 < truck_nums && currWeight + truck_weights[currNum + 1] <= weight) {
                currNum++;
                dq.offer(new int[] {truck_weights[currNum], 0});
                currWeight += truck_weights[currNum];
                
            } //트럭추가
            
            totalTime++; //시간추가
        }//queue
        
        int answer = totalTime;
        return answer;
    }
}