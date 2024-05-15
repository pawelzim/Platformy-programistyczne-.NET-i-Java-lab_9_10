package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {
    @Test
    public void returnNotEmptyList_test() {
        Problem problem = new Problem(10, 1, 1, 3);
        Result result = problem.solve(3);
        assertFalse(result.items.isEmpty());
    }

    @Test
    public void returnEmptyList_test() {
        Problem problem = new Problem(10, 1, 5, 10);
        Result result = problem.solve(2);
        assertNull(result);
    }

    @Test
    public void weightAndValueCorrect_test() {
        Problem problem = new Problem(10, 1, 5, 10);
        for (var item : problem.items) {
            assertTrue((item.value >= 5 && item.value <= 10) && (item.weight >= 5 && item.weight <= 10));
        }
    }

    @Test
    public void correctResult_test() {
        Problem problem = new Problem(3, 1, 1, 3);
        List<Item> testItems = new ArrayList<>();
        testItems.add(new Item(1, 1));
        testItems.add(new Item(2, 3));
        testItems.add(new Item(4, 8));
        problem.items = testItems;
        Result result = problem.solve(11);
        assertEquals(11, result.sumWeight);
        assertEquals(20, result.sumValue);
    }
}