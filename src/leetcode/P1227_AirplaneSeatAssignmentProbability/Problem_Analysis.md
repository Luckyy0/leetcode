# 1227. Airplane Seat Assignment Probability / Xác suất Phân công Chỗ ngồi Máy bay

## Problem Description / Mô tả bài toán
`n` passengers board an airplane with `n` seats.
Passenger 1 lost his ticket and sits in a random seat.
Subsequent passengers:
- If their seat is available, take it.
- If not, pick a random available seat.
Return probability that `n-th` person sits in his own seat.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Induction / Symmetry
Consider state where `1st` passenger takes seat `i`.
- If `i == 1` (correct seat): Everyone else gets correct seat. P(n in n) = 1.
- If `i == n`: `n-th` seat taken. P(n in n) = 0.
- If `1 < i < n`: Passenger `i` finds their seat taken. They become the new "Passenger 1" for the remaining subproblem of size `n-i`.
The problem is recursive.
Base case n=1: Prob = 1.
For n > 1:
P(n) = (1/n) * 1  (Takes seat 1)
     + (1/n) * 0  (Takes seat n)
     + (1/n) * P(n-1) + ... + (1/n) * P(2)  (Takes seat i, effectively reduces to smaller problem).
Actually, simpler view:
The moment any passenger takes seat 1, the cycle breaks and everyone else (including n) gets their seat.
The moment any passenger takes seat n, the cycle breaks and n loses their seat.
Seat 1 and Seat n are symmetric from the perspective of the random chooser.
The chooser picks a random available seat. At any step `k` (where seat 1 and n are still available), if chooser picks 1, success; if n, fail; if other, defer.
Since 1 and n have equal probability of being picked eventually among the available set (until one is picked), the prob is 0.5.
Exception: n=1, prob is 1.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Mathematical Derivation
If $n=1$, the probability is 1.0 (the passenger takes the only seat). For $n > 1$, the probability is always 0.5. This is because the fate of the $n$-th passenger is decided the moment someone (either the 1st passenger or a displaced passenger) picks either the 1st seat (resolving the conflict, allowing everyone else including $n$ to sit correctly) or the $n$-th seat (dooming $n$). Since the 1st seat and the $n$-th seat are equally likely to be picked first among the "non-intermediate" seats, the probability is 0.5.
Nếu $n=1$, xác suất là 1.0 (hành khách ngồi vào ghế duy nhất). Đối với $n > 1$, xác suất luôn là 0.5. Điều này là do số phận của hành khách thứ $n$ được quyết định ngay khi ai đó (hành khách thứ nhất hoặc hành khách bị chiếm chỗ) chọn ghế thứ nhất (giải quyết xung đột, cho phép mọi người khác bao gồm cả $n$ ngồi đúng chỗ) hoặc ghế thứ $n$ (khiến $n$ mất chỗ). Vì ghế thứ nhất và ghế thứ $n$ có khả năng được chọn đầu tiên ngang nhau trong số các ghế "không trung gian", xác suất là 0.5.

---
