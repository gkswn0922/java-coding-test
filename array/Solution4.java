import java.util.*;

// 1. 반복되는 답의 패턴을 구함
// 2. 해당 패턴과 답을 비교, 답의 길이가 패턴길이보다 클경우, 다시 첫번째부터 매칭
// 3*. 비교하여 계산된 score 를 max 함수로 비교해서 가장 큰 점수의 수포자 순서대로 정렬

public class Solution4 {

    public static int[] solution(int[] answers) {

        // 수포자들의 패턴
        int[][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };

        // 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                // i % pattern[j].length -> 패턴의 처음으로 돌아가게 만들어주는 연산자임 %
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);

            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }

}