import java.util.*;

// 1. N 이 스테이지갯수, N 번을 반복하면 된다
// 2. N번 반복한다고 치면...각 스테이지의 실패율 = 해당단계의 인원 / 그 스테이지까지 총 인원
// 3. 그 스테이지까지 총 인원을 계속 줄여나가면서 실패율을 배열에 담고
// 4. 그 배열을 내림차순 정렬하면 됨. 추가로, 같은 실패율일 경우는 스테이지 번호가 낮은순서대로 정렬되도록 하면 되겠지. 

public class Solution6 {

    public int[] solution(int N, int[] stages) {
        // 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }

        // 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) { // 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total); // 실패율 구한
                total -= challenger[i]; // 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        // 실패율이 높은 스테이지부터 내림차순 정렬 (실패율이 같으면 스테이지 번호 낮은 순)
        return fails.entrySet().stream()
                .sorted((o1, o2) -> o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey())
                        : Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();
    }
}