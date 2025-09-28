package com.example.algos;

import java.util.Random;

public class QuickSort {
    private static final int INSERTION_CUTOFF = 16;
    private static final Random RNG = new Random(42);

    public static void sort(int[] a) { sort(a, null); }

    public static void sort(int[] a, Metrics m) {
        if (a == null || a.length <= 1) return;
        for (int i = a.length - 1; i > 0; i--) {
            int j = RNG.nextInt(i + 1);
            Utils.swap(a, i, j, m);
        }
        quicksort(a, 0, a.length, m);
    }

    private static void quicksort(int[] a, int lo, int hi, Metrics m) {
        while (hi - lo > 1) {
            if (hi - lo <= INSERTION_CUTOFF) {
                Utils.insertionSort(a, lo, hi, m);
                return;
            }
            if (m != null) m.enter();
            int pivotIndex = lo + RNG.nextInt(hi - lo);
            Utils.swap(a, lo, pivotIndex, m);
            int pivot = a[lo];
            int lt = lo, i = lo + 1, gt = hi - 1;
            while (i <= gt) {
                if (m != null) m.incCompare();
                if (a[i] < pivot) {
                    Utils.swap(a, lt++, i++, m);
                } else if (a[i] > pivot) {
                    Utils.swap(a, i, gt--, m);
                } else {
                    i++;
                }
            }
            int leftSize = lt - lo;
            int rightSize = hi - (gt + 1);
            if (leftSize < rightSize) {
                quicksort(a, lo, lt, m);
                lo = gt + 1;
            } else {
                quicksort(a, gt + 1, hi, m);
                hi = lt;
            }
            if (m != null) m.exit();
        }
    }
}
