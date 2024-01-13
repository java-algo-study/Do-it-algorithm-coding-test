package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import src.P11659_PartialSum;

import java.util.Random;

public class P11659_PartialSumTest {

    @Test
    public void testCalculatePartialSum() {
        // 테스트할 부분합 계산 메서드의 예시
        int N = 5;
        int[] sum_input = {1, 2, 3, 4, 5};
        P11659_PartialSum partialSum = new P11659_PartialSum();

        // src=1, dst=3에 대한 테스트
        int result1 = partialSum.calculatePartialSum(N, sum_input, 1, 3);
        assertEquals(3, result1);

        // src=2, dst=4에 대한 테스트
        int result2 = partialSum.calculatePartialSum(N, sum_input, 2, 4);
        assertEquals(3, result2);

        // src=3, dst=5에 대한 테스트
        int result3 = partialSum.calculatePartialSum(N, sum_input, 3, 5);
        assertEquals(3, result3);

    }
        @Test(timeout = 1000) // 1초(1000 밀리초) 이내에 수행되어야 함
        public void testPerformance() {
            P11659_PartialSum partialSum = new P11659_PartialSum();

            int N = 100000; // 예제 입력 크기
            int[] stressInput = new int[N];

            int M = 100000;

            // stressInput 배열에 랜덤 데이터 채우기
            for (int i = 0; i < M; i++) {
                stressInput[i] = (int) (Math.random() * 1000); // 0에서 99 사이의 랜덤 값으로 채웁니다.
            }

            int src = 1;
            int dst = N;

            // calculatePartialSum 메서드 호출
            for (int i = 0; i < 100000; i++) {
                partialSum.calculatePartialSum(N, stressInput, src, dst);
            }
        }
    }


