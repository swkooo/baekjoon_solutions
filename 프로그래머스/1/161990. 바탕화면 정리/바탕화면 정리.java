class Solution {
    public int[] solution(String[] wallpaper) {
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            char[] line = wallpaper[i].toCharArray();
            
            for(int j = 0; j < line.length; j++) {
                if(line[j] == '#') {
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
                    
            }
        }
        
        int[] answer = {minY, minX, maxY + 1, maxX + 1};
        return answer;
    }
}