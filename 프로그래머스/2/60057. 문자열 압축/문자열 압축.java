class Solution {
    public int solution(String s) {        
        
        int answer = s.length();
        
        for(int cut = 1; cut <= s.length() / 2; cut++) {
            StringBuilder sb = new StringBuilder();
            String temp = "";
            int repeatNum = 1;
            
            // System.out.println(cut);
            for(int i = cut; i <= s.length(); i += cut) {
                
                String temp2 = s.substring(i - cut, i);
                
                if(temp.equals(temp2)) {
                    repeatNum++;
                }
                else {
                    if(repeatNum != 1) {
                        sb.append(repeatNum);
                    }
                    sb.append(temp);
                    temp = temp2;
                    repeatNum = 1;                    
                }
            }
            if(repeatNum != 1) {
                sb.append(repeatNum);
            }
            sb.append(temp);
            
            int rest = s.length() % cut;
            if(rest != 0) {
                sb.append(s.substring(s.length() - rest, s.length()));
            }
            // System.out.println(sb);
            
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
    }
}