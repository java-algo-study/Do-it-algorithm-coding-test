package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.P11720_숫자의합;

public class P11720_숫자의합Test {
    @Test
    public void testSolution() {
        int result = P11720_숫자의합.solution(1, "3");
        assertEquals(3, result);
    }
}
