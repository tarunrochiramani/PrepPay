package com.tr;

import java.util.*;

public class RateLimiter {
    private int rateLimit;
    private Map<String, List<Long>> tracker = new HashMap<>();


    public RateLimiter(int limit) {
        rateLimit = limit;
    }


    public void request(String requestIp, String requestPayload) throws InvalidInputException {
        if (requestIp == null || requestIp.isEmpty() || requestPayload == null) {
            throw new InvalidInputException();
        }

        Date now = new Date();
        long timestamp = now.getTime();

        if (!tracker.containsKey(requestIp)) {
            List<Long> timestampsUnderASec = new ArrayList<>();
            timestampsUnderASec.add(timestamp);
            tracker.put(requestIp, timestampsUnderASec);
        } else {
            List<Long> previousTimestamps = tracker.get(requestIp);
            if (timestamp - previousTimestamps.get(0) < 1000) {
                if (previousTimestamps.size() == rateLimit) {
                    System.out.println("RateLimited Exception for request: " + requestIp + " and payload: " + requestPayload);
                    return;
                }
                previousTimestamps.add(timestamp);
            } else {
                previousTimestamps.clear();
                previousTimestamps.add(timestamp);
            }
        }

        System.out.println(requestPayload);
    }
// 1 second window
// [1    2 3 4         5]


    public static void main(String args[]) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3); // max of 2 requests in 1 second by one ip
        try {
            limiter.request("192.168.1.5", "test1");
            limiter.request("192.168.1.5", "test2");
            Thread.sleep(500);
//        limiter.request("192.168.1.22", "test1");
            limiter.request("192.168.1.5", "test3");
            Thread.sleep(200);
            limiter.request("192.168.1.5", "test4");
            limiter.request("192.168.1.5", "test5");
            limiter.request("192.168.1.5", "test6");
            limiter.request("192.168.1.5", "test7");
            Thread.sleep(250);
            limiter.request("192.168.1.5", "test8");
            limiter.request("192.168.1.5", "test9");
            Thread.sleep(200);
            limiter.request("192.168.1.5", "test10");
        } catch (InvalidInputException e) {
            System.err.println(e);
        }
    }

}

class InvalidInputException extends Exception {
    private int error_code = 400;
    private String message = "Invalid Input received";

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return error_code;
    }
}