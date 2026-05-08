import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        HashSet<String> isVisited = new HashSet<>();
        for(String word : words) {
            isVisited.add(word);
        }
        if(!isVisited.contains(target)) {
            return answer;
        }
        
        ArrayDeque<String> dq = new ArrayDeque<>();
        dq.offer(begin);
        
        boolean isFound = false;
        while(!dq.isEmpty() && !isFound) {
            answer++;
            int size = dq.size();
            
            // System.out.println(dq.toString());
            
            for(int i = 0; i < size; i++) {
                String check = dq.poll();
                for(String word : words) {
                    if(isVisited.contains(word)) {
                        int diffCnt = 0;
                        for(int j = 0; j < check.length(); j++) {
                            if(check.charAt(j) != word.charAt(j)) {
                                diffCnt++;
                            }
                            if(diffCnt >= 2) {
                                break;
                            }
                        }
                        
                        if(diffCnt == 1) {
                            if(word.equals(target)) {
                                isFound = true;
                                break;
                            }
                            else {
                                dq.offer(word);
                                isVisited.remove(word);
                            }
                        }
                        
                    }
                }
            }           
            
        }
        
        
        return answer;
    }
}