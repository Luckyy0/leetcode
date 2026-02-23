# Analysis for Bulb Switcher
# *Phân tích cho bài toán Công tắc Bóng đèn*

## 1. Problem Essence & Factors
## *1. Bản chất vấn đề & Thừa số*

### The Pattern
### *Mẫu*
Bulb `i` is toggled in round `k` if `k` divides `i`.
Total toggles for bulb `i` = Number of divisors of `i`.
Initially OFF.
Odd toggles -> ON.
Even toggles -> OFF.
We need to count how many numbers in `1...n` have an odd number of divisors.

### Math Property
### *Tính chất Toán học*
Divisors come in pairs `(a, b)` such that `a * b = i`.
If `a != b`, divisors are even.
If `a == b`, i.e., `i = a * a` (Perfect Square), then `a` is counted once. Total divisors is Odd.
So, bulb `i` is ON iff `i` is a Perfect Square.

### Counting Perfect Squares
### *Đếm số chính phương*
How many squares `<= n`?
$1^2, 2^2, 3^2, ..., k^2 \le n$.
$k \le \sqrt{n}$.
So there are $\lfloor \sqrt{n} \rfloor$ perfect squares.

---

## 2. Approach: Math
## *2. Hướng tiếp cận: Toán học*

### Logic
### *Logic*
Return `(int) sqrt(n)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Solution:** No iteration needed.
    *Giải pháp O(1): Không cần lặp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n=3`.
Squares: 1. (4 is > 3). Answer 1.
Trace:
Bulb 1: Divisors [1] -> 1 toggle -> ON.
Bulb 2: Divisors [1, 2] -> 2 toggles -> OFF.
Bulb 3: Divisors [1, 3] -> 2 toggles -> OFF.
On: 1.

**Input:** `n=5`.
Squares: 1, 4. Answer 2.
Bulb 4: [1, 2, 4] -> 3 toggles -> ON.
Bulb 5: [1, 5] -> 2 toggles -> OFF.
On: 1, 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Math trick: Perfect squares have odd divisors.
*Thủ thuật toán học: Số chính phương có số lượng ước số lẻ.*
---
*Chỉ những ai dám đối diện với chính mình (perfect square root) mới giữ được ánh sáng (on) sau vô vàn biến động (toggles).*
Only those who dare to face themselves (perfect square root) can keep the light (on) after countless changes (toggles).
