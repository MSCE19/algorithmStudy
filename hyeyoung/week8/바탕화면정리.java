class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lastX = wallpaper[0].length();
        int lastY = wallpaper.length;
        int maxX = 0;
        int maxY = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[0].length(); j++){
                int currentX = j;
                int currentY = i;
                if(wallpaper[i].charAt(j) == '#'){
                    if(lastX > currentX){
                        lastX = currentX;
                    }
                    if(lastY > currentY){
                        lastY = currentY;
                    }
                    if(maxX < currentX){
                        maxX = currentX;
                    }
                    if(maxY < currentY){
                        maxY = currentY;
                    }
                }                
            }
        }
        answer[0] = lastY;
        answer[1] = lastX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;
        return answer;
    }
}
