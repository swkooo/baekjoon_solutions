import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int num : course) {
            // hashmap 초기화
            count = new HashMap<>();
            
            for(String order : orders) {
                if(order.length() >= num) {
                    char[] temp = order.toCharArray();
                    Arrays.sort(temp);
                    String temp2 = "";
                    for(char ch : temp) {
                        temp2 += ch;
                    }
                    
                    DFS(temp2, num, "", 0, 0);
                } //코스
            }
            // 1. 가장 많이 주문된 횟수(최댓값) 찾기
            int maxCount = 0;
            for (int cnt : count.values()) {
                maxCount = Math.max(maxCount, cnt);
            }

            // 2. 최댓값이 2 이상인지 확인
            if (maxCount >= 2) {
                // 3. 최댓값과 같은 주문 횟수를 가진 메뉴(Key)들을 찾아 리스트에 저장
                for (String key : count.keySet()) {
                    if (count.get(key) == maxCount) {
                        answer.add(key);
                    }
                }
            }
        }
        Collections.sort(answer);
        
        return answer;
    } //solution
    
    private static HashMap<String, Integer> count;
    
    public static void DFS(String order, int num, String selected, int currNum, int currIdx) {
        //종료부분
        if(currNum == num) {
            if(count.containsKey(selected)) {
                count.replace(selected, count.get(selected) + 1);
            }
            else {
                count.put(selected, 1);
            }
            return;
        }
        
        //재귀부분
        for(int i = currIdx; i <= order.length() - (num - currNum); i++) {
            DFS(order, num, selected + order.charAt(i), currNum + 1, i + 1);
        }
        
    }
}