# Analysis for Jewels and Stones
# *Phân tích cho bài toán Đá quý và Đá thường*

## 1. Problem Essence & Hashing
## *1. Bản chất vấn đề & Băm (Hashing)*

### The Challenge
### *Thách thức*
We need to check for each character in `stones` if it exists in the set of `jewels`.
*Chúng ta cần kiểm tra với mỗi ký tự trong `stones` xem nó có tồn tại trong tập hợp `jewels` hay không.*

Since checks are frequent, we need checks to be $O(1)$.
*Vì việc kiểm tra diễn ra thường xuyên, ta cần thao tác kiểm tra tốn $O(1)$.*

---

## 2. Strategy: Hash Set
## *2. Chiến lược: Tập hợp Băm (Hash Set)*

### Algorithm
### *Thuật toán*

1.  **Build Set:** Insert all characters from `jewels` into a `HashSet`.
    *   **Xây dựng Tập hợp:** Chèn tất cả các ký tự từ `jewels` vào một `HashSet`.*

2.  **Iterate & Count:**
    - Loop through each character `s` in `stones`.
    - If `set.contains(s)`, increment count.
    *   **Duyệt & Đếm:** Duyệt qua từng ký tự `s` trong `stones`. Nếu `set` chứa `s`, tăng biến đếm.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int numJewelsInStones(String jewels, String stones) {
    Set<Character> jewelSet = new HashSet<>();
    for (char c : jewels.toCharArray()) {
        jewelSet.add(c);
    }
    
    int count = 0;
    for (char c : stones.toCharArray()) {
        if (jewelSet.contains(c)) {
            count++;
        }
    }
    return count;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(J + S)$, where $J$ is length of `jewels` and $S$ is length of `stones`.
    *   **Độ phức tạp thời gian:** $O(J + S)$.*
*   **Space Complexity:** $O(J)$ to store the set of jewels.
    *   **Độ phức tạp không gian:** $O(J)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**In:** `jewels="aA"`, `stones="aAAbbbb"`
1. Set: `{a, A}`.
2. Scan `a`: in set? Yes. Count=1.
3. Scan `A`: in set? Yes. Count=2.
4. Scan `A`: in set? Yes. Count=3.
5. Scan `b`: in set? No.
...
**Result:** 3.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple HashSet usage. Since characters are limited (ASCII), a boolean array or `int[128]` could be faster and lighter than `HashSet`.
*Sử dụng HashSet đơn giản. Vì các ký tự bị giới hạn (ASCII), mảng boolean hoặc `int[128]` có thể nhanh hơn và nhẹ hơn `HashSet`.*
