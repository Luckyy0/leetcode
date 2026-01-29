# 1390. Four Divisors / Bốn Ước số

## Problem Description / Mô tả bài toán
Array `nums`.
Sum of divisors of integers in `nums` that have exactly 4 divisors.
Return total sum.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divisor Counting
Iterate `nums`. For each `x`:
Count divisors up to `sqrt(x)`.
- If `i` divides `x`:
  - `div1 = i`, `div2 = x/i`.
  - If `div1 == div2`, only 1 divisor (total odd).
  - Else 2 divisors.
Keep total count and sum.
If count == 4, add sum to result.
For efficiency, break if count > 4.

### Complexity / Độ phức tạp
- **Time**: O(N * sqrt(Val)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iteration and Factorization
For each number `num` in the array, find its divisors by iterating from 1 to `sqrt(num)`.
Track count and sum of divisors.
If `num % i == 0`:
- If `i * i == num`, increment count by 1, add `i` to sum.
- Else, increment count by 2, add `i` and `num/i` to sum.
Stop if count > 4.
After loop: if count == 4, add current sum to global total.
Đối với mỗi số `num` trong mảng, tìm các ước số của nó bằng cách lặp từ 1 đến `sqrt(num)`.
Theo dõi số lượng và tổng các ước số.
Nếu `num % i == 0`:
- Nếu `i * i == num`, tăng số lượng lên 1, cộng `i` vào tổng.
- Ngược lại, tăng số lượng lên 2, cộng `i` và `num/i` vào tổng.
Dừng nếu số lượng > 4.
Sau vòng lặp: nếu số lượng == 4, cộng tổng hiện tại vào tổng toàn cục.

---
