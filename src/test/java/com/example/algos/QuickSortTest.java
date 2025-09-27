package com.example.algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void testRandomArray() {
        int[] a = Utils.randomArray(1000, 10000, 7L);
        int[] copy = a.clone();
        QuickSort.sort(a);
        Arrays.sort(copy);
        assertArrayEquals(copy, a);
    }

    @Test
    public void testSmall() {
        int[] a = {5,2,9,1,3};
        QuickSort.sort(a);
        assertArrayEquals(new int[]{1,2,3,5,9}, a);
    }
}
