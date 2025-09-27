package com.example.algos;

public class Metrics {
    public long comparisons = 0;
    public long swaps = 0;
    public long allocations = 0;
    private int depth = 0;
    public int maxDepth = 0;

    public void incCompare() { comparisons++; }
    public void incSwap() { swaps++; }
    public void alloc(long n) { allocations += n; }

    public void enter() { depth++; if (depth > maxDepth) maxDepth = depth; }
    public void exit() { depth--; if (depth < 0) depth = 0; }

    public void reset() {
        comparisons = swaps = allocations = 0;
        depth = maxDepth = 0;
    }
}
