package leet_code.Problem_359_Easy_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

public class Logger {

    private Map<String, Integer> nextAllowed;

    /**
     * Logger Rate Limiter.
     * Uses HashMap to store the next allowed timestamp for each message.
     * Time: O(1), Space: O(M).
     * 
     * Bộ giới hạn Tốc độ Ghi nhật ký.
     * Sử dụng HashMap để lưu trữ dấu thời gian cho phép tiếp theo cho mỗi tin nhắn.
     */
    public Logger() {
        nextAllowed = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!nextAllowed.containsKey(message) || timestamp >= nextAllowed.get(message)) {
            nextAllowed.put(message, timestamp + 10);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println("1, foo: " + logger.shouldPrintMessage(1, "foo")); // true
        System.out.println("2, bar: " + logger.shouldPrintMessage(2, "bar")); // true
        System.out.println("3, foo: " + logger.shouldPrintMessage(3, "foo")); // false
        System.out.println("8, bar: " + logger.shouldPrintMessage(8, "bar")); // false
        System.out.println("10, foo: " + logger.shouldPrintMessage(10, "foo")); // false
        System.out.println("11, foo: " + logger.shouldPrintMessage(11, "foo")); // true
    }
}
