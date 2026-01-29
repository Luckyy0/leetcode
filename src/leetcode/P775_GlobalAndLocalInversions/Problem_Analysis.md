# 775. Global and Local Inversions / Nghịch thế Toàn cục và Cục bộ

## Problem Description / Mô tả bài toán
You are given an integer array `nums` of length `n` which is a permutation of `[0, 1, ..., n - 1]`.
Bạn được cho một mảng số nguyên `nums` có độ dài `n` là một hoán vị của `[0, 1, ..., n - 1]`.

A **global inversion** is a pair `(i, j)` with `0 <= i < j < n` and `nums[i] > nums[j]`.
**Nghịch thế toàn cục** là một cặp `(i, j)` với `0 <= i < j < n` và `nums[i] > nums[j]`.

A **local inversion** is a pair `(i, i + 1)` with `0 <= i < n - 1` and `nums[i] > nums[i + 1]`.
**Nghịch thế cục bộ** là một cặp `(i, i + 1)` với `0 <= i < n - 1` và `nums[i] > nums[i + 1]`.

Return `true` if the number of global inversions is equal to the number of local inversions.
Trả về `true` nếu số lượng nghịch thế toàn cục bằng số lượng nghịch thế cục bộ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Property Deduction / Suy luận Thuộc tính
Note that every local inversion is also a global inversion.
Lưu ý rằng mọi nghịch thế cục bộ cũng là một nghịch thế toàn cục.

If the counts are equal, it means there are **no** global inversions that are not local.
Nếu các số lượng này bằng nhau, điều đó có nghĩa là **không có** nghịch thế toàn cục nào mà không phải là nghịch thế cục bộ.

A global-but-not-local inversion exists if `nums[i] > nums[j]` where `j > i + 1`.
Một nghịch thế toàn cục nhưng không cục bộ tồn tại nếu `nums[i] > nums[j]` trong đó `j > i + 1`.

Condition for equal counts:
Each `nums[i]` must be strictly smaller than every `nums[j]` where `j >= i + 2`.
Equivalently: `Math.abs(nums[i] - i) <= 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Distance Check
A simple check on the displacement of each number from its ideal sorted position. If any number moves more than 1 step from its index, it must have jumped over at least one neighbor, creating a global non-local inversion.
Một kiểm tra đơn giản về sự dịch chuyển của mỗi số so với vị trí đã sắp xếp lý tưởng của nó. Nếu bất kỳ số nào di chuyển nhiều hơn 1 bước so với chỉ số của nó, nó phải vượt qua ít nhất một láng giềng, tạo ra một nghịch thế toàn cục không cục bộ.

---
