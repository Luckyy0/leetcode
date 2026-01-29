# 970. Powerful Integers / Số nguyên Mạnh mẽ

## Problem Description / Mô tả bài toán
Given three integers `x`, `y`, and `bound`, return a list of all **powerful integers** that have a value less than or equal to `bound`.
Cho ba số nguyên `x`, `y` và `bound`, hãy trả về danh sách tất cả các **số nguyên mạnh mẽ** có giá trị nhỏ hơn hoặc bằng `bound`.

A powerful integer is an integer that can be represented as `x^i + y^j` for some integers `i >= 0` and `j >= 0`.
Một số nguyên mạnh mẽ là số nguyên có thể được biểu diễn dưới dạng `x^i + y^j` với các số nguyên `i >= 0` và `j >= 0`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force with Exponential Bounds / Duyệt trâu với Giới hạn Lũy thừa
Since `x^i + y^j <= bound`, `i` and `j` can't be very large (at most `log(bound)`).
Vì `x^i + y^j <= bound`, nên `i` và `j` không thể rất lớn (tối đa là `log(bound)`).

Algorithm:
1. Iterate `i` from 0, calculating `v1 = x^i`. Stop if `v1 > bound`.
2. Inside, iterate `j` from 0, calculating `v2 = y^j`. Stop if `v1 + v2 > bound`.
3. Add `v1 + v2` to a `Set`.
4. Handle edge cases: if `x=1` or `y=1`, the exponent doesn't change the value, so stop loop after one iteration.

### Complexity / Độ phức tạp
- **Time**: O(log_{x}(Bound) * log_{y}(Bound)).
- **Space**: O(Number of results).

---

## Analysis / Phân tích

### Approach: Finite Combinatorial Exploration
Explore all possible power pairs $(x^i, y^j)$ whose sum remains within the boundary. By handling cases where the base is 1 to avoid infinite loops, we can comprehensively collect all valid candidates into a set to ensure uniqueness.
Khám phá tất cả các cặp lũy thừa có thể $(x^i, y^j)$ mà tổng của chúng vẫn nằm trong ranh giới. Bằng cách xử lý các trường hợp cơ số bằng 1 để tránh vòng lặp vô hạn, chúng ta có thể thu thập toàn diện tất cả các ứng viên hợp lệ vào một tập hợp để đảm bảo tính duy nhất.

---
