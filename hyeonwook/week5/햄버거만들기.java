package PS.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        solution(ingredient);
    }

    public static int solution(int[] ingredient) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);


            if(stack.size()>3) {
                if (stack.get(stack.size()-4) == 1 && stack.get(stack.size() - 3) == 2 &&
                        stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;

    }
}
