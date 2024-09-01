package com.example.greedytechniques;

import java.util.*;

public class OptimalFreelancing {

    // O(n * log(n)) time and O(1) space
    private static int getMaxProfit(List<Map<Integer, Integer>> jobs) {
        int LENGTH_OF_WEEK = 7;

        Collections.sort(jobs, (o1, o2) -> o1.keySet().stream().findFirst().get().compareTo(o2.keySet().stream().findFirst().get()));

        boolean[] timeline = new boolean[LENGTH_OF_WEEK];
        int maxProfit = 0;

        for (Map<Integer, Integer> job : jobs) {
            Map.Entry<Integer, Integer> firstEntry = job.entrySet().iterator().next();
            int maxTime = Math.min(firstEntry.getValue(), LENGTH_OF_WEEK) - 1;
            int payment = firstEntry.getKey();

            for (int i = maxTime; i >= 0; i--) {
                if (!timeline[i]) {
                    timeline[i] = true;
                    maxProfit += payment;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        List<Map<Integer, Integer>> jobs = new ArrayList<>();
        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(1, 1);

        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(2, 2);

        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(2, 2);

        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(1, 7);

        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(3, 4);

        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(5, 4);

        jobs.add(new HashMap<>());
        jobs.get(jobs.size() - 1).put(1, 3);

        int maxProfit = getMaxProfit(jobs);
        System.out.println("The max profit for the job is: " + maxProfit);
    }
}
