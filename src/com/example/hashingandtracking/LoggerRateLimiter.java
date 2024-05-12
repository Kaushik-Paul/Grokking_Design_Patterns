
package com.example.hashingandtracking;

import java.util.HashMap;

public class LoggerRateLimiter {

    // initailization of requests hash map
    private HashMap<String, Integer> requests;
    int limit;

    public LoggerRateLimiter(int timeLimit) {
        requests = new HashMap<String, Integer>();
        limit = timeLimit;
    }

    // O(1) time and O(n) space
    private boolean messageRequestDecision(int timestamp, String message) {
        if (!this.requests.containsKey(message)) {
            this.requests.put(message, timestamp);
            return true;
        } else if (timestamp - this.requests.get(message) >= this.limit) {
            this.requests.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Driver code
        int[] times = { 1, 5, 6, 7, 15 };
        String[] messages = {
                "good morning",
                "hello world",
                "good morning",
                "good morning",
                "hello world"
        };
        LoggerRateLimiter obj = new LoggerRateLimiter(7);
        for (int i = 0; i<messages.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tTime, message: {" + times[i] + ", '" + messages[i] + "'}");
            System.out.println("\tMessage request decision: " + obj.messageRequestDecision(times[i], messages[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
