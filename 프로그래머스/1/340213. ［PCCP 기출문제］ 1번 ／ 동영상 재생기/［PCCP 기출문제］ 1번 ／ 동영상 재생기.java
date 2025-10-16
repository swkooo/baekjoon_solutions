import java.util.*;

class Solution {
    public StringBuffer solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuffer answer = new StringBuffer();
        
        lenTime = transTime(video_len);
        posTime = transTime(pos);
        opTimeS = transTime(op_start);
        opTimeE = transTime(op_end);
        
        posTime = opSkip(posTime);
        for(String command : commands) {
            
            if(command.equals("prev")) {
                posTime = commandPrev(posTime);
            }
            if(command.equals("next")) {
                posTime = commandNext(posTime);
            }
            posTime = opSkip(posTime);
        }
        
        int min = posTime / 60;
        int sec = posTime % 60;
        
        if(min < 10) {
            answer.append(0);
        }
        answer.append(min).append(":");
        if(sec < 10) {
            answer.append(0);
        }
        answer.append(sec);
        
        return answer;
    }
    
    public static int lenTime;
    public static int posTime;
    public static int opTimeS;
    public static int opTimeE;
    
    public int transTime(String strTime) {
        String[] tempTime = strTime.split(":");
        
        int min = Integer.parseInt(tempTime[0]);
        int sec = Integer.parseInt(tempTime[1]);
        
        return min * 60 + sec;
    }
    
    public int opSkip(int currTime) {
        if(currTime >= opTimeS && currTime < opTimeE) {
            currTime = opTimeE;
        }
        return currTime;
    }
    
    public int commandPrev(int currTime) {
        currTime = currTime - 10;
        if(currTime < 0) {
            currTime = 0;
        }
        return currTime;
    }
    
    public int commandNext(int currTime) {
        currTime = currTime + 10;
        if(currTime > lenTime) {
            currTime = lenTime;
        }
        return currTime;
    }
}