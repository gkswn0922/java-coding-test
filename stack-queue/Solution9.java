import java.util.*;

class Solution9 {

    public static void main(String[] args) {

        String result = solution(50);
        System.out.println(result);
    }

    public static String solution(int decimal){
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        // String의 + 연산은 시간 복잡도 측면에서 성능이 좋지 않음
        // 따라서 StringBuilder를 사용했음
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}