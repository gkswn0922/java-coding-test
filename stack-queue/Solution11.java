import java.util.*;

public class Solution11 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1. 스택이 비어 있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 2. 스택의 맨 위 문자 제거
            }
            else {
                stack.push(c); // 3. 스택에 현재 문자 추가
            }
        }

        return stack.isEmpty() ? 1 : 0; // 4. 스택이 비어 있으면 1, 그렇지 않으면 0 반환
    }
}

// 1. 문자열 자체를 for 문으로 돌릴거임
// 2. 스택에 문자열 하나씩 넣는다고 생각하면서, 넣기전 최근에 넣은 문자열과 비교했을 때
// 3. 그 문자열이랑 같으면 pop 때림
// 4. 주의할것은 stack 이 비어있으면 안된다는거..