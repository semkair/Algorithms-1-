package com.example.algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;

public class DeterministicSelectTest {

    @Test
    public void testSelectRandomMany() {
        Random r = new Random(42);
        for (int t = 0; t < 50; t++) {
            int n = 200 + r.nextInt(200);
            int[] a = new int[n];
            for (int i=0;i<n;i++) a[i]=r.nextInt(10000);
            int k = r.nextInt(n);
            int[] copy = a.clone();
            Arrays.sort(copy);
            int want = copy[k];
            int got = DeterministicSelect.selectKth(a.clone(), k);
            assertEquals(want, got);
        }
    }

    @Test
    public void testSelectSmall() {
        int[] a = {9,1,5,3,7};
        assertEquals(5, DeterministicSelect.selectKth(a.clone(), 2));
    }
}
