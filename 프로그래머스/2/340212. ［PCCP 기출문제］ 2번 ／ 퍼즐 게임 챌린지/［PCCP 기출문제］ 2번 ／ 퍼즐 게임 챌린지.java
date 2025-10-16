import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int low = 1;
        int high = 0;
        for (int diff : diffs) {
            high = Math.max(high, diff);
        }
        
        int answer = high; 
        int cnt = diffs.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long time = times[0];
            for (int i = 1; i < cnt; i++) {
                int levelDiff = Math.max(0, diffs[i] - mid);
                time += (long) levelDiff * (times[i] + times[i - 1]) + times[i];
            }

            if (time <= limit) {
                // 시간이 남거나 딱 맞음: 현재 level(mid)은 가능한 답이다.
                // 더 낮은 level도 가능한지 확인하기 위해 범위를 왼쪽으로 좁힌다.
                answer = mid;
                high = mid - 1;
            } else {
                // 시간이 초과됨: 현재 level(mid)이 너무 낮다.
                // level을 높여야 하므로 범위를 오른쪽으로 좁힌다.
                low = mid + 1;
            }
        }
        
        return answer;
    }
}