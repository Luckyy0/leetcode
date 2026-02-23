# Analysis for Peeking Iterator
# *Phân tích cho bài toán Iterator Nhìn trộm*

## 1. Problem Essence & Lookahead
## *1. Bản chất vấn đề & Nhìn trước*

### The Limitation
### *Giới hạn*
Standard `Iterator` only has `next()`. Once you call it, the element is consumed.
`peek()` needs to check the element *without* consuming it.

### Strategy: One-Item Cache
### *Chiến lược: Bộ đệm một phần tử*
We need to "store" the next element so we can show it in `peek()` without losing it.
State:
- `iterator`: The underlying iterator.
- `nextVal`: Cache for the next value (Integer, nullable).
- `hasPeaked`: Boolean flag to know if `nextVal` is valid. (Or just rely on null if nulls aren't allowed values, but safe to use a separate flag or pre-fetch strategy).

### Design Choice: Pre-fetch vs Lazy-fetch
### *Lựa chọn thiết kế: Lấy trước vs Lấy sau*
**Pre-fetch:**
- Constructor calls `iterator.next()` immediately and stores it in `cache`.
- `peek()` returns `cache`.
- `next()` returns `cache`, then updates `cache` from `iterator`.
- `hasNext()` checks if `cache` is not null.
Issue: What if `iterator` can contain `null`? We need a flag. Or since constraints say `1 <= nums[i]`, null is safe sentinel.

**Lazy-fetch (Better for general case):**
- Constructor does nothing.
- `peek()`: If `cache` empty, fetch from `iter` and save to `cache`. Return `cache`.
- `next()`: If `cache` empty, fetch from `iter`. Else return `cache` and clear `cache`.

Actually, Pre-fetch (maintain `nextElement` always populated if available) is cleaner logic for `hasNext`.
Let's use `Integer next = null`.
If `iterator.hasNext()`, `next = iterator.next()`.

---

## 2. Approach: Caching
## *2. Hướng tiếp cận: Bộ nhớ đệm*

### Logic
### *Logic*
1.  **Constructor**: Store iterator. Call `advance()`.
2.  **advance()**: If `iter.hasNext()`, `nextVal = iter.next()`. Else `nextVal = null`.
3.  **peek()**: Return `nextVal`.
4.  **next()**:
    - `res = nextVal`.
    - `advance()`.
    - Return `res`.
5.  **hasNext()**: Return `nextVal != null`.

Wait, what if the input list contains `null`?
Design generic: Use a `noSuchElement` flag or boolean `hasCached`.
Since constraints say `nums[i] >= 1`, `null` is fine sentinel.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Wrapper:** Decorator pattern. Adds functionality without modifying underlying class.
    *Wrapper: Mẫu Decorator. Thêm chức năng mà không sửa đổi lớp cơ bản.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for all ops.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$ (one var).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 3]`
1.  Init: `nextVal = 1`.
2.  `next()`: Ret 1. `nextVal` becomes 2.
3.  `peek()`: Ret 2. `nextVal` stays 2.
4.  `next()`: Ret 2. `nextVal` becomes 3.
5.  `next()`: Ret 3. `nextVal` becomes null.
6.  `hasNext()`: False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Pre-fetching simplifies logic significantly.
*Việc lấy trước (pre-fetching) đơn giản hóa logic đáng kể.*
---
*Đôi khi cần phải nhìn trước một bước (peek) để chuẩn bị, nhưng đừng để việc đó làm bạn chậm lại. Giữ giá trị tương lai trong tầm tay.*
Sometimes you need to look ahead (peek) to prepare, but don't let it slow you down. Keep the future value within reach.
