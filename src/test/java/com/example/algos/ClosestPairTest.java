package com.example.algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class ClosestPairTest {

    // brute force helper
    private double brute(ClosestPair.Point[] p) {
        double best = Double.POSITIVE_INFINITY;
        for (int i=0;i<p.length;i++) for (int j=i+1;j<p.length;j++) {
            double dx = p[i].x - p[j].x;
            double dy = p[i].y - p[j].y;
            best = Math.min(best, Math.hypot(dx,dy));
        }
        return best;
    }

    @Test
    public void testRandomSmall() {
        Random r = new Random(123);
        for (int t=0;t<20;t++) {
            int n = 50;
            ClosestPair.Point[] p = new ClosestPair.Point[n];
            for (int i=0;i<n;i++) p[i] = new ClosestPair.Point(r.nextDouble()*1000, r.nextDouble()*1000);
            double d1 = ClosestPair.closestDistance(p);
            double d2 = brute(p);
            assertEquals(d2, d1, 1e-8);
        }
    }
}
