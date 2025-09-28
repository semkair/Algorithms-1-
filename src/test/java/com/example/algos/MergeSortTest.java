package com.example.algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void testRandomArray() {
        int[] a = Utils.randomArray(1000, 10000, 123L);
        int[] copy = a.clone();
        MergeSort.sort(a);
        Arrays.sort(copy);
        assertArrayEquals(copy, a);
    }

    @Test
    public void testSortedAndDuplicates() {
        int[] a = {1,1,1,2,2,3,3,3};
        MergeSort.sort(a);
        assertArrayEquals(new int[]{1,1,1,2,2,3,3,3}, a);
    }

    @Test
    public void testEmpty() {
        int[] a = {};
        MergeSort.sort(a);
        assertArrayEquals(new int[]{}, a);
    }
}
