package RateLimiterAlgo;

public class TokenBucketAlgorithm {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(5, 2); // 5 tokens max, 2 per second

        for (int i = 0; i < 20; i++) {
            if (bucket.allowRequest()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " throttled");
            }
            Thread.sleep(100); // simulate time between requests
        }
    }
}

class TokenBucket {
    private final int capacity;
    private final double refillRate; // tokens per second
    private double tokens;
    private long lastRefillTimestamp;

    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens -= 1;
            return true; // request allowed
        } else {
            return false; // request denied
        }
    }

    private void refill() {
        long now = System.nanoTime();
        double secondsSinceLastRefill = (now - lastRefillTimestamp) / 1_000_000_000.0;
        double tokensToAdd = secondsSinceLastRefill * refillRate;

        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd); // to handle overflow.
            lastRefillTimestamp = now;
        }
    }
}
