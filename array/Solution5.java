import java.util.*;

// 1. 수학의 행렬곱셈을 하면 된다는데 그게 뭔지 일단 모름.
// 2. 행은 가로, 열은 세로
// 3. arr1 의 열을 첫번째 for 문으로
// 4. arr2 의 행을 두번째 for 문으로
// 5. arr1 의 행을 세번째 for 문으로
// 6. answer[i][j] += arr1[i][k] * arr2[k][j] 이거로 행 곱셈값들을 차근차근 구해서 answer 를 return 하는..
// 

public class Solution5 {
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬 arr1과 arr2의 행과 열의 수
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 결과를 저장할 2차원 배열 초기화
        int[][] answer = new int[r1][c2];

        // 첫 번째 행렬 arr1의 각 행과 두 번째 행렬 arr2의 각 열에 대해
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                // 두 행렬의 데이터를 곱해 결과 리스트에 더함
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

}