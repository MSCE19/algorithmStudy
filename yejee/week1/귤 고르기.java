class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int max = 1; 
        for (int i = 0; i < tangerine.length; i++) {
            if (tangerine[i] > max) {
                max = tangerine[i]; // 현재 요소가 최댓값보다 크면 최댓값 업데이트
            }
        }
        int[] count = new int[max + 1]; // 크기가 i인 귤의 개수는 count[i]
        
        for (int i = 0; i < count.length; i++) { //count 배열 초기화
            count[i] = 0;
        }
            
        for( int i : tangerine){
            count[i]++;
        }
        for(int i = 0; i < count.length;i++){
            
        }
        
        
        return answer;
    }
}