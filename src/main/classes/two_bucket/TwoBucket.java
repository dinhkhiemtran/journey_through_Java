package main.classes.two_bucket;

public class TwoBucket {

    private int totalMove;

    private String finalBucket;

    private int otherBucket;

    public TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        Bucket[] buckets = new Bucket[]{new Bucket("one", bucketOneCap), new Bucket("two", bucketTwoCap)};
        if ("two".equals(startBucket)) {
            Bucket temp = buckets[0];
            buckets[0] = buckets[1];
            buckets[1] = temp;
        }
        totalMove = 0;
        while (true) {
            totalMove++;
            if (buckets[0].liter == 0) {
                buckets[0].liter = buckets[0].cap;
            } else if (buckets[1].cap == desiredLiters) {
                buckets[1].liter = buckets[1].cap;
            } else if (buckets[1].liter == buckets[1].cap) {
                buckets[1].liter = 0;
            } else {
                int transfer = Math.min(buckets[0].liter, buckets[1].cap - buckets[1].liter);
                buckets[0].liter -= transfer;
                buckets[1].liter += transfer;
            }
            if (buckets[0].liter == desiredLiters) {
                finalBucket = buckets[0].label;
                otherBucket = buckets[1].liter;
                break;
            }
            if (buckets[1].liter == desiredLiters) {
                finalBucket = buckets[1].label;
                otherBucket = buckets[0].liter;
                break;
            }
        }
    }

    public int getTotalMoves() {
        return this.totalMove;
    }

    public String getFinalBucket() {
        return this.finalBucket;
    }

    public int getOtherBucket() {
        return this.otherBucket;
    }
}
