# Analysis for Perfect Number
# *Phân tích cho bài toán Số Hoàn hảo*

## 1. Problem Essence & Divisor Sum
## *1. Bản chất vấn đề & Tổng Ước số*

### The Challenge
### *Thách thức*
Checking if sum of proper divisors equals the number.
- Naïve loop up to `num` is $O(N)$ -> TLE for $10^8$.
- Optimized loop up to $\sqrt{N}$ is $O(\sqrt{N})$ -> Fast.

### Strategy: Iterate to Square Root
### *Chiến lược: Duyệt đến Căn bậc hai*

1.  **Iteration:** Loop $i$ from 1 to $\sqrt{num}$.
2.  **Logic:** If `num % i == 0`:
    - Add `i` to sum.
    - If `i * i != num`, add `num / i` also.
    - **Exception:** For `i=1`, `num/i` is `num` itself. The definition says *excluding the number itself*.
    - So treat `1` specially or subtract `num` at end.
    - Safer: Start sum = 1 (since 1 is always divisor for num > 1). Iterate $i=2$ to $\sqrt{num}$. Add `i` and `num/i`.

---

## 2. Approach: Math Sqrt
## *2. Hướng tiếp cận: Toán học Căn bậc hai*

### Logic
### *Logic*
(See above). Edge case `num = 1`: Divisors excluding self is empty sum 0. `1 != 0`. False.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(sqrt N):** Efficient for large inputs.
    *O(sqrt N): Hiệu quả cho đầu vào lớn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sqrt{N})$.
    *Độ phức tạp thời gian: $O(\sqrt{N})$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `28`
1. Sum = 1.
2. Loop `i=2`. `28 % 2 == 0`. Add `2` and `14`. Sum = 17.
3. Loop `i=3`. No.
4. Loop `i=4`. `28 % 4 == 0`. Add `4` and `7`. Sum = 17 + 11 = 28.
5. Loop `i=5`. No.
6. Loop `i=5.xxx`. End.
7. Sum 28 == Num 28. True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Accumulate divisors up to square root.
*Tích lũy các ước số đến căn bậc hai.*
---
*Sự hoàn hảo (perfect number) không đến từ việc giữ lại tất cả cho mình, mà đến từ tổng hòa của những gì đã chia sẻ (divisors). Khi tổng của những phần bạn cho đi (proper divisors) bằng chính con người bạn, đó là lúc bạn đạt đến trạng thái cân bằng tuyệt đối.*
Perfection (Perfect Number) does not come from keeping everything for itself, but comes from the harmony of what has been shared (Divisors). When the sum of the parts you give (Proper Divisors) is equal to who you are, that's when you reach the absolute balance.
