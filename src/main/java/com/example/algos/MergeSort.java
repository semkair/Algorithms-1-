package com.example.algos;

public class MergeSort {
    private static final int INSERTION_CUTOFF = 16;

    public static void sort(int[] a) {
        sort(a, null);
    }

    public static void sort(int[] a, Metrics m) {
        if (a == null || a.length <= 1) return;
        int[] aux = new int[a.length];
        if (m != null) m.alloc(aux.length);
        mergeSort(a, aux, 0, a.length, m);
    }

    private static void mergeSort(int[] a, int[] aux, int lo, int hi, Metrics m) {
        if (hi - lo <= INSERTION_CUTOFF) {
            Utils.insertionSort(a, lo, hi, m);
            return;
        }
        int mid = (lo + hi) >>> 1;
        if (m != null) m.enter();
        mergeSort(a, aux, lo, mid, m);
        if (m != null) m.exit();
        if (m != null) m.enter();
        mergeSort(a, aux, mid, hi, m);
        if (m != null) m.exit();

        if (a[mid - 1] <= a[mid]) return;

        int i = lo, j = mid, k = lo;
        while (i < mid && j < hi) {
            if (m != null) m.incCompare();
            if (a[i] <= a[j]) aux[k++] = a[i++];
            else aux[k++] = a[j++];
        }
        while (i < mid) aux[k++] = a[i++];
        while (j < hi) aux[k++] = a[j++];
        System.arraycopy(aux, lo, a, lo, hi - lo);
    }
}
