package leet_code.Problem_981_Medium_Time_Based_Key_Value_Store;

import java.util.*;

/**
 * Problem 981: Time Based Key-Value Store
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {

    // Map key to a TreeMap (timestamp -> value)
    // TreeMap allows efficient floor entry lookup.
    private Map<String, TreeMap<Integer, String>> store;

    /**
     * Initializes the TimeMap.
     */
    public TimeMap() {
        store = new HashMap<>();
    }

    /**
     * Stores key-value with timestamp.
     * Strategy: Store in nested TreeMap.
     * 
     * @param key       Key string.
     * @param value     Value string.
     * @param timestamp Timestamp value.
     * 
     *                  Tóm tắt chiến lược:
     *                  1. Sử dụng HashMap để ánh xạ `key` tới một cấu trúc dữ liệu
     *                  lưu trữ các cặp `(timestamp, value)`.
     *                  2. Cấu trúc dữ liệu bên trong cần hỗ trợ tìm kiếm giá trị có
     *                  `timestamp_prev <= timestamp` lớn nhất.
     *                  Đây chính là thao tác tìm `floor` (cận dưới) trong cây tìm
     *                  kiếm nhị phân.
     *                  3. `TreeMap` trong Java là lựa chọn hoàn hảo vì nó lưu các
     *                  key (ở đây là timestamp) theo thứ tự sắp xếp và cung cấp
     *                  phương thức `floorEntry`.
     *                  4. `set`: Thêm cặp `(timestamp, value)` vào TreeMap tương
     *                  ứng với `key`. Nếu `key` chưa có, tạo mới TreeMap.
     *                  Độ phức tạp: O(log N) cho mỗi lần set (với N là số lượng
     *                  timestamp của key đó).
     */
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    /**
     * Retrieves value for key at timestamp.
     * Strategy: Binary Search (via TreeMap floorEntry).
     * 
     * @param key       Key string.
     * @param timestamp Search timestamp.
     * @return Value or empty string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Kiểm tra xem `key` có tồn tại trong `store` không. Nếu không ->
     *         trả về "".
     *         2. Lấy `TreeMap` tương ứng với `key`.
     *         3. Sử dụng `floorEntry(timestamp)`:
     *         - Phương thức này trả về Entry có key lớn nhất nhỏ hơn hoặc bằng
     *         `timestamp`.
     *         - Nếu không tìm thấy (tức là tất cả timestamp trong map đều lớn hơn
     *         `timestamp` truy vấn) -> trả về null.
     *         4. Nếu `entry` là null -> trả về "".
     *         5. Ngược lại -> trả về `entry.getValue()`.
     *         Độ phức tạp: O(log N).
     */
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timeMap = store.get(key);
        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);

        if (entry == null) {
            return "";
        }

        return entry.getValue();
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println("Get(foo, 1): " + timeMap.get("foo", 1)); // bar
        System.out.println("Get(foo, 3): " + timeMap.get("foo", 3)); // bar

        timeMap.set("foo", "bar2", 4);
        System.out.println("Get(foo, 4): " + timeMap.get("foo", 4)); // bar2
        System.out.println("Get(foo, 5): " + timeMap.get("foo", 5)); // bar2
    }
}
