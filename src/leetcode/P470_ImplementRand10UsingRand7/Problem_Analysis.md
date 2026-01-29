# 470. Implement Rand10() Using Rand7() / Triển Khai Rand10() Bằng Rand7()

## Problem Description / Mô tả bài toán
Given the API `rand7()` that generates a uniform random integer in the range `[1, 7]`, write a function `rand10()` that generates a uniform random integer in the range `[1, 10]`.
Cho API `rand7()` tạo ra một số nguyên ngẫu nhiên phân phối đều trong khoảng `[1, 7]`, hãy viết hàm `rand10()` tạo ra một số nguyên ngẫu nhiên phân phối đều trong khoảng `[1, 10]`.

You can only call `rand7()` and you **cannot** use any other random generation functions.
Bạn chỉ được gọi `rand7()` và **không được** sử dụng bất kỳ hàm tạo số ngẫu nhiên nào khác.

### Constraints / Ràng buộc
- `rand7()` is pre-defined.
- Each call to `rand7()` returns an integer in the range `[1, 7]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Rejection Sampling / Lấy mẫu loại bỏ
To generate a range `[1, 10]` using `[1, 7]`, we can first generate a larger uniform range and then map a portion of it to 1-10.
Combining two `rand7()` calls gives a range of $7 \times 7 = 49$ possible outcomes.

Algorithm:
1. Generate `val = (rand7() - 1) * 7 + rand7()`. This gives a uniform number in `[1, 49]`.
2. Map the first 40 outcomes to 1-10:
   - If `val <= 40`, return `(val - 1) % 10 + 1`.
3. If `val > 40`, it's an "out-of-bounds" outcome. **Reject** it and repeat the process.
4. (Optional Optimization) Instead of immediately rejecting `val > 40`, we can use the remaining 9 states and another `rand7()` to try again.

### Complexity / Độ phức tạp
- **Time**: Expected O(1) calls (approximately 2.45 calls on average).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: 2-D Rejection Sampling

**Algorithm**:
1.  Nested `rand7` calls to produce 1..49.
2.  Modulo 10 if within range 1..40.
3.  Resample otherwise.

---
