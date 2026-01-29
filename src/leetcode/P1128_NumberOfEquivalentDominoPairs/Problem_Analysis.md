# 1128. Number of Equivalent Domino Pairs / Số lượng Cặp Domino Tương đương

## Problem Description / Mô tả bài toán
Given a list of `dominoes`, return the number of pairs `(i, j)` for which `0 <= i < j < dominoes.length`, and `dominoes[i]` is equivalent to `dominoes[j]`.
Dominoes `[a, b]` and `[c, d]` are equivalent if `(a==c and b==d)` or `(a==d and b==c)`.
Cho danh sách `dominoes`, hãy trả về số lượng cặp `(i, j)` sao cho `0 <= i < j < dominoes.length`, và `dominoes[i]` tương đương với `dominoes[j]`.
Domino `[a, b]` và `[c, d]` tương đương nếu `(a==c và b==d)` hoặc `(a==d và b==c)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Canonical Form Hash Map / Bản đồ Băm Dạng Chính tắc
Normalize each domino `[a, b]` to `[min(a,b), max(a,b)]`.
Convert to a unique key (e.g., `val = min*10 + max` since max val is 9).
Count frequencies.
Ans = Sum(count * (count - 1) / 2).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(100) since max val is small.

---

## Analysis / Phân tích

### Approach: Normalized Counting
Normalize every domino to a standard form where the first number is less than or equal to the second (e.g., `[min, max]`). This handles the rotation equivalence. Store the frequency of each normalized form in a hash map or array. The number of pairs for any form appearing $k$ times is $\frac{k(k-1)}{2}$. Sum these pair counts for the total.
Chuẩn hóa mọi domino sang dạng tiêu chuẩn trong đó số đầu tiên nhỏ hơn hoặc bằng số thứ hai (ví dụ: `[min, max]`). Điều này xử lý sự tương đương về phép xoay. Lưu trữ tần suất của mỗi dạng đã chuẩn hóa trong bản đồ băm hoặc mảng. Số lượng cặp cho bất kỳ dạng nào xuất hiện $k$ lần là $\frac{k(k-1)}{2}$. Cộng tổng số cặp này để có kết quả cuối cùng.

---
