class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            long d_squared = (long) d * d;
            long x_squared = x * x;

            long y_max = (long) Math.sqrt(d_squared - x_squared);
            
            answer += (y_max / k) + 1;
        }
        return answer;
    }
}