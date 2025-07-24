package RateLimiterAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucketAlgorithm {
    public static void main(String[] args) throws InterruptedException {
        LeakyBucket bucket = new LeakyBucket(10, 2); // capacity 10, leak 2 requests per second

        for (int i = 0; i < 20; i++) {
            if (bucket.allowRequest("Request-" + i)) {
                System.out.println("Accepted: Request-" + i);
            } else {
                System.out.println("Dropped: Request-" + i);
            }
            Thread.sleep(200); // simulate request arrival
        }
    }
}

class LeakyBucket {
    private final int capacity;
    private final int outflowRatePerSec;
    private final Queue<String> queue;
    private long lastLeakTime;

    public LeakyBucket(int capacity, int outflowRatePerSec) {
        this.capacity = capacity;
        this.outflowRatePerSec = outflowRatePerSec;
        this.queue = new LinkedList<>();
        this.lastLeakTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest(String request) {
        leak();

        if (queue.size() < capacity) {
            queue.offer(request);
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.currentTimeMillis();
        long elapsedMillis = now - lastLeakTime;
        int leaks = (int) (elapsedMillis / 1000.0 * outflowRatePerSec);

        for (int i = 0; i < leaks && !queue.isEmpty(); i++) {
            queue.poll(); // leak (process) one request
        }

        if (leaks > 0) {
            lastLeakTime = now;
        }
    }
}

