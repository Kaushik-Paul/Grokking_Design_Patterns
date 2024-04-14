package com.example.modifiedbinarysearch;

public class FirstBadVersion {

    public static void main(String[] args) {
        int[] testCaseVersions = new int[]{38, 13, 29, 40, 23};
        int[] firstBadVersions = new int[]{28, 10, 10, 28, 19};
        for (int i = 0; i < testCaseVersions.length; i++) {
            int firstBadVersion = firstBadVersions[i];

            if (i > 0) {
                System.out.println();
            }

            System.out.println(i + 1 + ".\tNumber of versions: " + testCaseVersions[i]);
            int[] result = firstBadVersion(testCaseVersions[i], firstBadVersion);
            System.out.println("\n\tFirst bad version: " + result[0] + ". Found in " + result[1] + " API calls.");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static boolean isBadVersion(int s, int v) {
        return s >= v;
    }

    // O(log n) time and O(1) space
    private static int[] firstBadVersion(int testCaseVersion, int firstBadVersion) {
        int left = 1;
        int right = testCaseVersion;
        int calls = 0;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (isBadVersion(middle, firstBadVersion)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            calls++;
        }

        return new int[]{firstBadVersion, calls};
    }
}
