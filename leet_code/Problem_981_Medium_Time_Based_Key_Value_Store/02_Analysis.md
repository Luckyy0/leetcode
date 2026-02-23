# Analysis for Time Based Key-Value Store
# *Phân tích cho bài toán Kho lưu trữ Key-Value dựa trên Thời gian*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Store (key, value, time). Query max time $t_{prev} \le t$.
*Lưu trữ bộ ba. Truy vấn thời gian lớn nhất nhỏ hơn hoặc bằng t.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- `set` timestamps are strictly increasing. This means we append to the end.
- `get` needs to search for `timestamp`.
- Searching in a sorted list: Binary Search (`upper_bound` or `floor`).
- Map: `Key -> List<Pair<Time, Value>>`.
- Since list is sorted by time, we can binary search the list.
- Alternatively, use `TreeMap<Integer, String>`. `floorEntry(timestamp)`.
- TreeMap is $O(\log N)$ for both set and get, but `set` here is $O(1)$ with List (append). `get` is also $O(\log N)$.
- List is more memory efficient and slightly faster due to locality if implemented correctly. But TreeMap is much easier to write.
- Given constraints $2 \cdot 10^5$ calls, $O(\log N)$ is fine.
- Let's use `HashMap<String, TreeMap<Integer, String>>` for simplicity and correctness.
*Sử dụng HashMap ánh xạ tới TreeMap. TreeMap hỗ trợ tìm floorEntry trong O(log N).*

---

## 2. Strategy: HashMap + TreeMap
## *2. Chiến lược: HashMap + TreeMap*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Data Structure:** `Map<String, TreeMap<Integer, String>>`.
    *   **Cấu trúc dữ liệu:** Map lồng Map.*

2.  **Set(key, value, timestamp):**
    - `map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value)`.
    *   **Set:** Thêm vào TreeMap.*

3.  **Get(key, timestamp):**
    - Order map by key. If absent return "".
    - `entry = treeMap.floorEntry(timestamp)`.
    - If entry null (all timestamps > target), return "".
    - Else return `entry.getValue()`.
    *   **Get:** Tìm phần tử nhỏ hơn hoặc bằng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        TreeMap<Integer, String> timeMap = map.get(key);
        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
        
        if (entry == null) {
            return "";
        }
        return entry.getValue();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** `set`: $O(\log N)$ (TreeMap put), `get`: $O(\log N)$ (TreeMap search). total operations $M \log N$.
    *   **Độ phức tạp thời gian:** $O(\log N)$.*
*   **Space Complexity:** $O(N)$.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

TreeMap handles the floor logic perfectly.
*TreeMap xử lý logic tìm cận dưới một cách hoàn hảo.*
