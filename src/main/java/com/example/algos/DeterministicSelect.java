package com.example.algos;

public class DeterministicSelect {

    public static int selectKth(int[] a, int k) {
        return selectKth(a, k, null);
    }

    public static int selectKth(int[] a, int k, Metrics m) {
        if (a == null || k < 0 || k >= a.length) throw new IllegalArgumentException("k out of range");
        return select(a, 0, a.length, k, m);
    }

    private static int select(int[] a, int lo, int hi, int k, Metrics m) {
        while (true) {
            int len = hi - lo;
            if (len <= 10) {
                Utils.insertionSort(a, lo, hi, m);
                return a[k];
            }
            int groups = (len + 4) / 5;
            int[] med = new int[groups];
            if (m != null) m.alloc(groups);
            for (int g = 0; g < groups; g++) {
                int gLo = lo + g * 5;
                int gHi = Math.min(gLo + 5, hi);
                Utils.insertionSort(a, gLo, gHi, m);
                med[g] = a[gLo + (gHi - gLo) / 2];
            }
            int pivot = select(med, 0, med.length, med.length / 2, m);

            // 3-way partition on pivot
            int lt = lo, i = lo, gt = hi - 1;
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
            if (k < lt) {
                hi = lt;
            } else if (k <= gt) {
                return a[k];
            } else {
                lo = gt + 1;
            }
        }
    }
}
