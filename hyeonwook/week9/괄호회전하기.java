package prgmrs;

import java.util.ArrayDeque;

public class 괄호회전하기 {

    public static void main(String[] args) {
        String s1 = "[](){}";
        System.out.println(solution(s1)); // 3
        String s2 = "}]()[{";
        System.out.println(solution(s2)); // 2
        String s3 = "[)(]";
        System.out.println(solution(s3)); // 0
        String s4 = "}}}";
        System.out.println(solution(s4)); // 0
    }

    static public int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> dq = new ArrayDeque<>();
        ArrayDeque<Character> stack;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dq.addLast(c);
        }

        for (int i = 0; i < dq.size(); i++) {
            stack = new ArrayDeque<>();
            boolean isValid = true;

            for (Character brks : dq) {
                if (brks == '(' || brks == '{' || brks == '[') {
                    stack.addLast(brks);
                } else {
                    if (stack.size() == 0) {
                        isValid = false;
                        break;
                    }
                    char close = stack.pollLast();

                    if (brks == ')' && close != '(') {
                        isValid = false;
                        break;
                    } else if (brks == '}' && close != '{') {
                        isValid = false;
                        break;
                    } else if (brks == ']' && close != '[') {
                        isValid = false;
                        break;
                    }
                }
            }

            if (stack.size() == 0 && isValid) {
                answer += 1;
            }

            dq.addLast(dq.pollFirst());
        }
        return answer;
    }
}
