import java.util.*;
class Solution {
    public List<String> solution(String[] record) {
        
        Map<String, String> userMap = new HashMap<>();
        for(String message : record) {
            String[] line = message.split(" ");
            String command = line[0];
            String userId = line[1];
            String nickName = "";
            if(!command.equals("Leave")) {
                nickName = line[2];
            }
            if(!userMap.containsKey(userId)) {
                userMap.put(userId, nickName);
            }
            else if(command.equals("Enter") || command.equals("Change")) {
                userMap.replace(userId, nickName);
            }
        }
        List<String> answer = new ArrayList<>();
        for(String message : record) {
            String[] line = message.split(" ");
            String command = line[0];
            String userId = line[1];
            String nickName = userMap.get(userId);
            
            StringBuilder sb = new StringBuilder();
            if(command.equals("Enter")) {
                sb.append(nickName).append("님이 들어왔습니다.");
                String chat = sb.toString();
                answer.add(chat);
            }
            if(command.equals("Leave")) {
                sb.append(nickName).append("님이 나갔습니다.");
                String chat = sb.toString();
                answer.add(chat);
            }         
        }        
        return answer;
    }
}