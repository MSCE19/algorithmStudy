class Solution {
    public int[] solution(int n, String[] words) {
        // n = 인수, words = 문자열 전체
        int[] answer = {0,0};
        
        for(int i = 1 ; i < words.length ; i++){
            if(!same_char(words[i-1], words[i]) || !no_repeat(words, words[i], i)){
                answer[0] = (int)(i % n) + 1;
                answer[1] = (int)(i / n) + 1;
                break;
            }
        }
        return answer;
    }
    // 앞사람이 말한 단어의 마지막 문자로 시작하는 단어인지 확인.
    public boolean same_char(String str1, String str2){
        if(str1.charAt(str1.length()-1) == str2.charAt(0))
            return true;
        else
            return false;
    }
    
    // 이전에 등장했던 단어인지 확인. 
    public boolean no_repeat(String[] words, String str, int n){
        for(int i = 0 ; i < n ; i++){
            if(str.equals(words[i])){
                return false; 
            }
        }
        return true;
    }
}
