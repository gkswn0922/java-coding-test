import java.util.*;

class Solution8 {

    private boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) // 닫는 괄호인데 짝이 될 여는 괄호가 없음
                    return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
    
}