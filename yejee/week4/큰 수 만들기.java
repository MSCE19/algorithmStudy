class Solution {
    public String solution(String number, int k) {
        int num_len = number.length(); 
        char max_num;
        int max_i = 0;
        int erasen = 0; //현재까지 지워진 숫자의 개수 
        
        StringBuilder answer = new StringBuilder();
        
        for(int j = 0; j < num_len && answer.length() < num_len - k ; j++){
            max_num = number.charAt(j);
            for(int i = j ; i < j + k - erasen && i < num_len - 1 ; i++){
                if(max_num < number.charAt(i+1)){
                    max_num = number.charAt(i+1);
                    max_i = i+1;
                }
            }
            answer.append(String.valueOf(max_num));
            erasen += max_i - j;
            j = max_i;
            max_i ++;
        }
        return answer.toString();
    }
}