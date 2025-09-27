package com.example.algos;

public class Main {
    public static void main(String[] args) {
        int[] a = Utils.randomArray(20, 1000, 1L);
        System.out.print("input: ");
        for (int v : a) System.out.print(v + " ");
        System.out.println();

        MergeSort.sort(a);
        System.out.print("merge sorted: ");
        for (int v : a) System.out.print(v + " ");
        System.out.println();

        int[] b = Utils.randomArray(15, 1000, 2L);
        System.out.print("input2: ");
        for (int v : b) System.out.print(v + " ");
        System.out.println();
        QuickSort.sort(b);
        System.out.print("quick sorted: ");
        for (int v : b) System.out.print(v + " ");
        System.out.println();
    }
}
