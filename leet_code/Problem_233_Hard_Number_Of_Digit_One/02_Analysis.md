# Analysis for Number of Digit One
# *Phân tích cho bài toán Số lượng chữ số một*

## 1. Problem Essence & Digit DP
## *1. Bản chất vấn đề & Quy hoạch động chữ số*

### The Naive Approach
### *Cách ngây thơ*
Iterate from 1 to `n`, convert to string, count '1's.
Complexity: $O(N \log N)$.
With $N=10^9$, this is $10^9 \times 9$ operations -> **TLE**.
*Vét cạn chắc chắn bị TLE.*

### The Digit-by-Digit Counting
### *Đếm theo từng hàng*
We can count the occurrences of `1` at each position (ones, tens, hundreds place...) separately.
Let `i` be the current position (1, 10, 100...).
We divide `n` into three parts relative to `i`:
- `high = n / (i * 10)`
- `current = (n / i) % 10`
- `low = n % i`

*Chúng ta đếm số lần xuất hiện của `1` tại mỗi vị trí (hàng đơn vị, hàng chục...). Chia `n` thành ba phần: cao, hiện tại, thấp.*

---

## 2. Approach: Mathematical Counting (Iterative)
## *2. Hướng tiếp cận: Đếm toán học (Lặp)*

### Logic
### *Logic*
For position `i` (e.g., hundreds place, $i=100$):
The number of times '1' appears depends on `current` digit:

1.  **If `current == 0`**:
    - The '1' at this position appears determined strictly by higher digits.
    - Example: `n=305`, i=10 (tens). `high=3, cur=0, low=5`.
    - Ranges: 010-019, 110-119, 210-219. (Total 3 blocks of 10).
    - Formula: `high * i`.

2.  **If `current == 1`**:
    - It includes the `high` full blocks, plus a partial block determined by `low`.
    - Example: `n=315`, i=10.
    - Ranges: 010-019, 110-119, 210-219 (from high) PLUS 310-315.
    - Formula: `high * i + (low + 1)`.

3.  **If `current > 1`**:
    - It includes `high + 1` full blocks.
    - Example: `n=325`, i=10.
    - Ranges: 010-019... 310-319. (Total 4 blocks).
    - Formula: `(high + 1) * i`.

Loop `i` from 1, 10, 100... while `i <= n`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Complexity:** The loop runs $\log_{10} N$ times (number of digits). For $10^9$, that's just 10 iterations.
    *Độ phức tạp Logarithm: Vòng lặp chạy số lượng chữ số lần. Cực nhanh.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_{10} N)$.
    *Độ phức tạp thời gian: $O(\log_{10} N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `13`

1.  **i = 1 (Ones place):**
    - `high = 1`, `cur = 3`, `low = 0`.
    - `cur > 1`: count += `(1 + 1) * 1` = 2. (Numbers: 1, 11 - ones place).
    - Real check: 1, 11. (Correct).
2.  **i = 10 (Tens place):**
    - `high = 0`, `cur = 1`, `low = 3`.
    - `cur == 1`: count += `0 * 10 + (3 + 1)` = 4. (Numbers: 10, 11, 12, 13).
    - Real check: 10, 11, 12, 13. (Correct).

Total: 2 + 4 = 6. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic digitization problem. The trick is cleanly separating `high`, `cur`, `low` and handling the `0`, `1`, `>1` cases. Note that `n` fits in `int`, but intermediate calculations like `i*10` might overflow if not careful (use `long` for loop variable).
*Đây là bài toán số hóa kinh điển. Mẹo là tách biệt `high`, `cur`, `low`. Lưu ý biến vòng lặp `i` nên dùng `long` để tránh tràn số.*
---
*Đếm số 1 giống như đếm những cột mốc. Bạn không cần đi bộ qua từng km, chỉ cần nhìn bản đồ và đếm xem có bao nhiêu cột mốc nằm trong hành trình.*
Counting 1s is like counting milestones. You don't need to walk every km, just look at the map and count how many milestones are within the journey.
