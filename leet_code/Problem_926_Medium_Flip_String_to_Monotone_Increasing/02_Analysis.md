# Analysis for Flip String to Monotone Increasing
# *Phân tích cho bài toán Lật chuỗi để thành Tăng đơn điệu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Minimize flips to make string look like `00...0011...11`.
*Tối thiểu hóa số lần lật để chuỗi có dạng `00...0011...11`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A monotone increasing string has a split point where all to left are `0` and all to right are `1`.
- We can iterate through all possible split points.
- Or better, use **Dynamic Programming** or simply track the count.
- Let `count1` be the number of `1`s seen so far.
- Let `flips` be the minimum flips to make the string monotone increasing ending at the current position.
- When we see a `1`: `count1++`. No flip needed if we keep it as `1` (assuming previous part is valid). The "current state" of minimum flips doesn't change because adding a `1` to a valid monotone increasing string keeps it valid.
- When we see a `0`:
  - Option 1: Flip this `0` to `1`. Cost = `flips + 1`. This assumes we keep the previous optimal flips.
  - Option 2: Keep this `0` as `0`. This means ALL previous ones must be `0`. But wait, that's not quite right.
  - Correct Logic:
    - If we encounter a `0`, we have two choices to maintain monotonicity:
      1. Flip this `0` to `1`. The cost increases by 1 relative to the previous state. `new_flips = current_flips + 1`.
      2. Keep this `0`. But for this to be valid, all preceding characters must effectively be `0` (or flipped to `0`). That corresponds to flipping all previous `1`s to `0`s. The cost is `count1`.
    - We take the minimum: `current_flips = min(current_flips + 1, count1)`.
    - Wait, let's re-verify. `current_flips` stores min flips for prefix `s[0...i]`.
    - Initially `flips = 0`, `count1 = 0`.
    - Iterate:
      - If char is `1`: `count1++`. `flips` stays same? Yes, because appending `1` to optimal solution for `s[0...i-1]` is always valid and costs 0 extra flips.
      - If char is `0`: `flips` could be `flips + 1` (flip this 0->1) OR `count1` (flip all previous 1->0 and keep this 0).
      - `flips = min(flips + 1, count1)`.
*Chuỗi tăng đơn điệu có điểm chia `0` bên trái, `1` bên phải. Dùng DP: `count1` đếm số `1` đã gặp. `flips` là số lần lật tối thiểu. Gặp `1`: tăng `count1`. Gặp `0`: có thể lật `0` thành `1` (tăng `flips` lên 1) hoặc lật tất cả `1` trước đó thành `0` (chi phí là `count1`). Lấy min.*

---

## 2. Strategy: One Pass DP
## *2. Chiến lược: QP Một Lượt*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `count1 = 0`, `flips = 0`.
    *   **Khởi tạo:** `count1 = 0`, `flips = 0`.*

2.  **Iterate:** `char c` in `s`.
    - If `c == '1'`: `count1++`.
    - If `c == '0'`: `flips = min(flips + 1, count1)`.
    *   **Duyệt:** Nếu `1`, tăng đếm. Nếu `0`, `flips` = min(lật số 0 này, lật tất cả số 1 trước đó).*

3.  **Return:** `flips`.
    *   **Trả về:** `flips`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int minFlipsMonoIncr(String s) {
    int count1 = 0;
    int flips = 0;
    
    for (char c : s.toCharArray()) {
        if (c == '1') {
            count1++;
        } else {
            // Either flip this '0' to '1' (cost: flips + 1)
            // Or flip all previous '1's to '0's (cost: count1)
            // Wait, the logic flips = min(flips + 1, count1) works because:
            // flips represents the cost to make prefix monotone ending with a '1' (or '0's then '1's)
            // If we flip 0->1, we extend the current best sequence.
            // If we don't, we effectively reset to "all zeros" strategy if it's cheaper.
            flips = Math.min(flips + 1, count1);
        }
    }
    
    return flips;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Very elegant DP solution reducing to 2 variables. The key is realizing that encountering a `0` offers a choice between extending the current pattern (by flipping `0`) or switching to an "all zeros" pattern (by flipping `1`s).
*Giải pháp DP rất thanh lịch rút gọn còn 2 biến. Chìa khóa là nhận ra rằng gặp số `0` đưa ra lựa chọn giữa việc mở rộng mẫu hiện tại (lật `0`) hoặc chuyển sang mẫu "tất cả số 0" (lật các số `1`).*
