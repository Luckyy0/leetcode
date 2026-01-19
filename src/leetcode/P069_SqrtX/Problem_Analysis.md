# 69. Sqrt(x) / Căn Bậc Hai của x

## Problem Description / Mô tả bài toán
Given a non-negative integer `x`, calculate the square root of `x` while truncating any decimal part and return the result as an integer.
Cho một số nguyên không âm `x`, hãy tính căn bậc hai của `x` trong khi cắt bớt phần thập phân và trả về kết quả dưới dạng số nguyên.

**Note**: You are not allowed to use any built-in exponent function or operator, such as `pow(x, 0.5)` or `x ** 0.5`.
**Lưu ý**: Bạn không được phép sử dụng bất kỳ hàm hoặc toán tử lũy thừa có sẵn nào, chẳng hạn như `pow(x, 0.5)` hoặc `x ** 0.5`.

### Example 1:
```text
Input: x = 4
Output: 2
```

### Example 2:
```text
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we truncate the decimal part, 2 is returned.
```

## Constraints / Ràng buộc
- `0 <= x <= 2^31 - 1`

---

## Analysis / Phân tích

### Approach: Binary Search / Tìm Kiếm Nhị Phân
- **Idea**: Find the largest integer `k` such that `k * k <= x`.
- **Ý tưởng**: Tìm số nguyên `k` lớn nhất sao cho `k * k <= x`.
- **Algorithm**:
    - Bin search range `[0, x]`.
    - `mid = lo + (hi - lo) / 2`.
    - If `mid * mid <= x`: `ans = mid`, `lo = mid + 1`.
    - Else: `hi = mid - 1`.
    - **Optimization**: `mid * mid` might overflow `int`. Use `long` or division `mid <= x / mid`.
- **Time Complexity**: O(log x).
- **Space Complexity**: O(1).

### Approach: Newton's Method / Phương Pháp Newton
- **Formula**: `x_new = (x_old + target / x_old) / 2`.

---

## Edge Cases / Các trường hợp biên
1.  **x = 0**: 0.
2.  **x = 1**: 1.
3.  **x = 2^31 - 1**: Works with `long` or proper checks.
