package com.example.algos;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static class Point {
        public final double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closestDistance(Point[] pts) {
        if (pts == null || pts.length < 2) return Double.POSITIVE_INFINITY;
        Point[] px = pts.clone();
        Arrays.sort(px, Comparator.comparingDouble(p -> p.x));
        return rec(px);
    }

    private static double rec(Point[] px) {
        int n = px.length;
        if (n <= 3) {
            double best = Double.POSITIVE_INFINITY;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    best = Math.min(best, dist(px[i], px[j]));
                }
            }
            return best;
        }

        int mid = n / 2;
        Point midPoint = px[mid];

        Point[] left = Arrays.copyOfRange(px, 0, mid);
        Point[] right = Arrays.copyOfRange(px, mid, n);

        double dl = rec(left);
        double dr = rec(right);
        double d = Math.min(dl, dr);

        Point[] stripTemp = new Point[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(px[i].x - midPoint.x) < d) {
                stripTemp[s++] = px[i];
            }
        }

        if (s == 0) return d;

        Point[] strip = Arrays.copyOf(stripTemp, s);
        Arrays.sort(strip, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s && (strip[j].y - strip[i].y) < d; j++) {
                d = Math.min(d, dist(strip[i], strip[j]));
            }
        }
        return d;
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.hypot(dx, dy);
    }
}
