import java.util.*;

// 1. 배열의 첫지점부터 다음, 다다음.. 의 숫자들을 더한 값들을 배열에 담는다.
// 2. 다음숫자에서 또 더하는 과정을 반복해서 마지막 - 1 까지 반복
// 3. 더한 값들이 모두 구해지면, 중복제거 후 오름차순으로 정렬함

public class Solution3 {
    public static void main(String[] args) {
        int[] numbers = {6, 6, 5, 5, 3, 2, 3, 1, 4, 2};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] numbers) {
        // 중복값 제거를 위한 해시셋 생성
        HashSet<Integer> set = new HashSet<>();

        // 두수를 선택하는 모든 경우의 수를 반복문으로 구함
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 두 수를 더한 결과를 해시셋에 추가
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 해시셋의 값을 오름차순 정렬하고 int[] 형태의 배열로 변환하여 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}