package leet_code.Problem_362_Medium_Design_Hit_Counter;

public class HitCounter {

    private int[] times;
    private int[] hits;

    /**
     * Design Hit Counter.
     * Uses a Circular Buffer (Bucketing by second).
     * Time: O(1) for hit, O(300) for getHits.
     * Space: O(300).
     * 
     * Thiết kế Bộ đếm Truy cập.
     * Sử dụng Bộ đệm Vòng (Phân nhóm theo giây).
     */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /**
     * Record a hit at timestamp.
     */
    public void hit(int timestamp) {
        int idx = timestamp % 300;
        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            hits[idx] = 1;
        } else {
            hits[idx]++;
        }
    }

    /**
     * Return hits in the last 5 minutes.
     */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println("Hits at 4: " + counter.getHits(4)); // 3
        counter.hit(300);
        System.out.println("Hits at 300: " + counter.getHits(300)); // 4
        System.out.println("Hits at 301: " + counter.getHits(301)); // 3
    }
}
