package com.example.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointFromOrigin {

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }

    // O(nlog(k)) time and O(k) space
    private static List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }

        if (maxHeap.isEmpty()) {
            return new ArrayList<>();
        }

        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] pointsOne = new Point[] {
                new Point(1, 3), new Point(3, 4), new Point(2, -1)
        };
        Point[] pointsTwo = new Point[] {
                new Point(1, 3), new Point(2, 4), new Point(2, -1), new Point(-2, 2), new Point(5, 3), new Point(3, -2)
        };
        Point[] pointsThree = new Point[] {
                new Point(1, 3), new Point(5, 3), new Point(3, -2), new Point(-2, 2)
        };
        Point[] pointsFour = new Point[] {
                new Point(2, -1), new Point(-2, 2), new Point(1, 3), new Point(2, 4)
        };
        Point[] pointsFive = new Point[] {
                new Point(1, 3), new Point(2, 4), new Point(2, -1), new Point(-2, 2), new Point(5, 3), new Point(3, -2), new Point(5, 3), new Point(3, -2)
        };
        Point[][] points = {pointsOne, pointsTwo, pointsThree, pointsFour, pointsFive};
        int[] kList = {2, 3, 1, 4, 5};
        for (int i = 0; i < points.length; i++) {

            System.out.print((i + 1) + ".\tSet of points: ");
            for (Point p: points[i])
                System.out.print("[" + p.x + " , " + p.y + "] ");
            System.out.println("\n\tK: " + kList[i]);
            List<Point> result = KClosestPointFromOrigin.kClosest(points[i], kList[i]);
            System.out.print("\tHere are the k = " + kList[i] + " points closest to the origin(0, 0): ");
            for (Point p: result)
                System.out.print("[" + p.x + " , " + p.y + "] ");
            System.out.println("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
