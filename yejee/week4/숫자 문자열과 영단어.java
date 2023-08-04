class Solution {
    public int solution(String s) {
        String answer = "";
        String[] numbers = {"zero", "one", "two", "three", "four",
                           "five", "six", "seven", "eight", "nine"};
        for(int i = 0 ; i < s.length() ; i++){
            if(Character.isDigit(s.charAt(i))){
                answer += s.charAt(i);
            }
            else{
                for(int j = 0; j < 10 ; j++){
                    if(numbers[j].startsWith(s.substring(i, i+2))){
                        answer += Integer.toString(j);
                        i += numbers[j].length() - 1 ;
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(answer);
    }
}