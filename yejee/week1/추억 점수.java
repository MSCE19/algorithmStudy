import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        for(int i = 0 ; i < photo.length ; i++){ // 총 사진 개수만큼 
            for(int j = 0 ; j < name.length ; j++){ // 해당 사진에 name에서 주어진 사람이 있는지 확인
                if(Arrays.asList(photo[i]).contains(name[j])){ // photo[i] 배열에 name[j]이 있는지 확인
                    answer[i] += yearning[j];
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}