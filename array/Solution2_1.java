import java.util.Arrays;

// 1. 배열의 중복값을 제거
// 2. 제거한 배열을 내림차순으로 정렬
public class Solution2_1 {
    public static void main(String[] args) {
        int[] arr = {6, 6, 5, 5, 3, 2, 3, 1, 4, 2};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr) {
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();

        int[] result = new int[sorted.length];
        for (int i = 0; i < sorted.length; i++) {
            result[i] = sorted[sorted.length - 1 - i];
        }
        return result;
    }
}
