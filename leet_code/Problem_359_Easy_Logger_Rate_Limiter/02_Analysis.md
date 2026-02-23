# Analysis for Logger Rate Limiter
# *Phân tích cho bài toán Bộ giới hạn Tốc độ Ghi nhật ký*

## 1. Problem Essence & Hash Mapping
## *1. Bản chất vấn đề & Ánh xạ Băm*

### The Challenge
### *Thách thức*
Controlling the frequency of messages based on their content. We need to store the "last printed time" or "next allowed time" for each unique message.

### Strategy: HashMap
### *Chiến lược: HashMap*
Use a `HashMap<String, Integer>` where:
-   **Key:** The unique message string.
-   **Value:** The next timestamp at which this message is allowed to be printed again.

### Logic:
### *Logic:*
When a message `msg` arrives at `timestamp`:
1.  Check if `msg` exists in the map.
2.  If not exists OR `timestamp >= map.get(msg)`:
    -   It is allowed to print.
    -   Update the map with `map.put(msg, timestamp + 10)`.
    -   Return `true`.
3.  Otherwise:
    -   Return `false`.

---

## 2. Approach: Hash Map Tracking
## *2. Hướng tiếp cận: Theo dõi bằng Bản đồ Băm*

### Logic
### *Logic*
(See above). Since timestamps are provided in chronological order, we don't need to worry about past messages arriving late.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Check:** Hash map lookup and insertion are amortized $O(1)$.
    *Kiểm tra O(1): Tra cứu và chèn vào bản đồ băm là O(1).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ per `shouldPrintMessage()` call.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(M)$ where $M$ is the number of **unique** messages seen.
    *Độ phức tạp không gian: $O(M)$ với M là số lượng tin nhắn duy nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Operation:** `shouldPrintMessage(1, "foo")`
- Map: Empty.
- Action: Allowed. Update Map: `{"foo": 11}`. Return `true`.

**Operation:** `shouldPrintMessage(3, "foo")`
- Map: `{"foo": 11}`.
- Check: `3 < 11`.
- Action: Denied. Return `false`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap is the most straightforward and efficient solution.
*HashMap là giải pháp đơn giản và hiệu quả nhất.*
---
*Cuộc sống đôi khi quá ồn ào. Để những lời nói thực sự có giá trị, chúng ta cần biết cách giới hạn tần suất (rate limiting) và chỉ lên tiếng khi thời điểm thực sự chín muồi (timestamp + 10).*
Life is sometimes too noisy. For words to truly have value, we need to know how to limit frequency (rate limiting) and only speak when the time is truly ripe (timestamp + 10).
