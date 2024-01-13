package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.P1546Average;

public class P1546AverageTest {
    @Test
    public void testSolution() {
        int[] arr = {10, 20, 30};
        float result = P1546Average.solution(3, arr);
        assertEquals(66.66667, result, 1e-2);
    }
}
