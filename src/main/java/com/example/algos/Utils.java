package com.example.algos;

import java.util.Random;

public class Utils {
    private static final Random RNG = new Random(123456);

    public static void swap(int[] a, int i, int j, Metrics m) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        if (m != null) m.incSwap();
    }

    public static int[] randomArray(int n, int maxVal, long seed) {
        Random r = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(maxVal);
        return a;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }

    public static void insertionSort(int[] a, int lo, int hi, Metrics m) {
        for (int i = lo + 1; i < hi; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= lo) {
                if (m != null) m.incCompare();
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    if (m != null) m.incSwap();
                    j--;
                } else break;
            }
            a[j + 1] = key;
        }
    }
}
