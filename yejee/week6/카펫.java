class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int w = 3, h = 3;
        
        for(h = 3 ; h < brown / 2 - 1 ; h++){
            w = brown/2 - h + 2;
            if((h-2) * (w-2) == yellow){
                break;
            }
        }
        
        answer[0] = w;
        answer[1] = h;
        
        return answer;
    }
}