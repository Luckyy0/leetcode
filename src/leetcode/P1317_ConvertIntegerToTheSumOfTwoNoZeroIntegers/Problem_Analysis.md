# 1317. Convert Integer to the Sum of Two No-Zero Integers / Chuyển đổi Số nguyên thành Tổng của Hai Số nguyên Không phải Số không

## Problem Description / Mô tả bài toán
Input `n`. Return `[A, B]` such that `A + B = n` and both A, B contain no zero digit.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force
Iterate `A` from 1 to `n/2`. `B = n - A`.
Check if `A` has no zeros and `B` has no zeros.
First one found is valid.

### Complexity / Độ phức tạp
- **Time**: O(N * log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Incremental Search
Iterate `A` from 1 upwards. Calculate `B = n - A`. Check if `A` contains '0' or `B` contains '0' (simplest is `String.valueOf(x).contains("0")` or iterative modulo). The valid range is small enough that we will find a solution quickly.
Lặp lại `A` từ 1 trở lên. Tính `B = n - A`. Kiểm tra xem `A` có chứa '0' hay `B` có chứa '0' hay không (đơn giản nhất là `String.valueOf(x).contains("0")` hoặc modulo lặp lại). Phạm vi hợp lệ đủ nhỏ để chúng ta sẽ tìm thấy giải pháp nhanh chóng.

---
