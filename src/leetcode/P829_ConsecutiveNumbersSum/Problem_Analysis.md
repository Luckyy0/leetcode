# 829. Consecutive Numbers Sum / Tổng các Số liên tiếp

## Problem Description / Mô tả bài toán
Given an integer `n`, return the number of ways you can write `n` as the sum of consecutive positive integers.
Cho một số nguyên `n`, hãy trả về số cách bạn có thể viết `n` dưới dạng tổng của các số nguyên dương liên tiếp.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Arithmetic Progression / Cấp số cộng
Let the sequence be `x, x+1, x+2, ..., x+k-1` (length `k`).
The sum is $S = kx + \frac{k(k-1)}{2} = n$.
$kx = n - \frac{k(k-1)}{2}$

For a valid positive integer `x`:
1. $n - \frac{k(k-1)}{2}$ must be positive.
2. $(n - \frac{k(k-1)}{2})$ must be divisible by $k$.

Algorithm:
- Iterate $k$ starting from 1.
- Continue as long as $k(k-1)/2 < n$.
- Check if $(n - k(k-1)/2) \% k == 0$.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(N)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Length-wise Search
Since the sum of the first $k$ integers $1 + 2 + ... + k$ grows quadratically, we only need to test $k$ up to approximately $\sqrt{2N}$. For each $k$, we determine if a valid starting integer $x$ exists.
Vì tổng của $k$ số nguyên đầu tiên tăng theo cấp số mũ, chúng ta chỉ cần kiểm tra $k$ lên đến khoảng $\sqrt{2N}$. Đối với mỗi $k$, chúng ta xác định xem có tồn tại một số nguyên bắt đầu $x$ hợp lệ hay không.

---
