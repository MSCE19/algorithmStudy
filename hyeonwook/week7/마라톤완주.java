package prgmrs;

import java.util.HashMap;

public class marathonComplete {
    public static void main(String[] args) {
        String []participant = {"leo", "kiki", "eden"};
        String []completion = {"eden", "kiki"};
        solution(participant,completion);
    }
        public static String solution(String[] participant, String[] completion) {
            HashMap<String,Integer> status = new HashMap<>();
            String answer = "";

            for (String p : participant) {
                status.put(p, status.getOrDefault(p, 0)+1);
            }

            for (String c : completion) {
                status.put(c, status.get(c) - 1);
            }

            for (String key : status.keySet()) {
                if (status.get(key) != 0) {
                    answer = key;
                    break;
                }
            }
            return answer;
        }

}
