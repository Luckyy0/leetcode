package leet_code.Problem_933_Easy_Number_of_Recent_Calls;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 933: Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class RecentCounter {

    /**
     * Queue to store the timestamps of recent pings.
     * Guaranteed to be sorted since t is strictly increasing.
     */
    private Queue<Integer> q;

    /**
     * Initializes the RecentCounter.
     */
    public RecentCounter() {
        q = new LinkedList<>();
    }

    /**
     * Adds a new request at time t and returns the number of recent requests.
     * Strategy: Sliding Window using Queue.
     * 
     * @param t Current timestamp.
     * @return Number of requests in [t - 3000, t].
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng một hàng đợi (Queue) để lưu trữ các mốc thời gian `ping`.
     *         2. Khi có một `ping(t)` mới, thêm `t` vào cuối hàng đợi.
     *         3. Kiểm tra phần tử đầu hàng đợi (`q.peek()`).
     *         Nếu `q.peek() < t - 3000` (nghĩa là cuộc gọi đã quá cũ so với cửa sổ
     *         3000ms),
     *         thì loại bỏ nó khỏi hàng đợi (`q.poll()`). Lặp lại cho đến khi phần
     *         tử đầu nằm trong khoảng hợp lệ.
     *         4. Số lượng phần tử còn lại trong hàng đợi chính là số lượng cuộc gọi
     *         gần đây.
     */
    public int ping(int t) {
        // Add the new ping timestamp
        q.add(t);

        // Remove pings that are older than t - 3000
        while (q.peek() < t - 3000) {
            q.poll();
        }

        // Return the size of the queue, representing the number of recent calls
        return q.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println("Ping 1: " + recentCounter.ping(1)); // returns 1
        System.out.println("Ping 100: " + recentCounter.ping(100)); // returns 2
        System.out.println("Ping 3001: " + recentCounter.ping(3001)); // returns 3
        System.out.println("Ping 3002: " + recentCounter.ping(3002)); // returns 3
    }
}
