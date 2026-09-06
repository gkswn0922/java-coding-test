import java.util.Arrays;
import java.util.Collections;

public class RemoveDuplicatesAndSortDescending {
    public static void main(String[] args) {
        int[] arr = {6, 6, 5, 5, 3, 2, 3, 1, 4, 2};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
