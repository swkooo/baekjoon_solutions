import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int smallNum = Math.min(a, b);
        int bigNum = Math.max(a, b);
        System.out.println(smallNum + " " + bigNum);
        
        int answer = 1;
        while(bigNum - smallNum != 1 || bigNum % 2 != 0) {
            smallNum = reNumbering(smallNum);
            bigNum = reNumbering(bigNum);
            answer++;
        }

        return answer;
    }
    
    public static int reNumbering(int num) {
        if(num % 2 == 0) {
            return num / 2;
        }
        else {
            return num / 2 + 1;
        }
    }
}