# 790. Domino and Tromino Tiling / Lát gạch Domino và Tromino

## Problem Description / Mô tả bài toán
You have two types of tiles: a `2 x 1` domino shape and a tromino shape (an L-shape covering 3 squares).
Bạn có hai loại gạch: hình domino `2 x 1` và hình tromino (hình chữ L bao phủ 3 ô).

Given an integer `n`, return the number of ways to tile a `2 x n` board. Since the answer may be very large, return it **modulo 10^9 + 7**.
Cho một số nguyên `n`, hãy trả về số cách để lát một bảng `2 x n`. Vì câu trả lời có thể rất lớn, hãy trả về theo **modulo 10^9 + 7**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Recurrence / Quy hoạch Động
Let `dp[i]` be the number of ways to tile a `2 x i` board.
Gọi `dp[i]` là số cách để lát một bảng `2 x i`.

Recurrence:
`dp[i] = 2 * dp[i-1] + dp[i-3]` for `i > 3`.
Base cases:
- `dp[1] = 1`
- `dp[2] = 2`
- `dp[3] = 5`

This simplified recurrence is derived from considering all possible tiles (vertical domino, two horizontal dominoes, and various tromino pairs).
Công thức truy hồi đơn giản hóa này được rút ra từ việc xem xét tất cả các loại gạch có thể có (domino dọc, hai domino ngang và các cặp tromino khác nhau).

Detailed logic includes states like "fully covered" and "one square missing".
Logic chi tiết bao gồm các trạng thái như "đã bao phủ hoàn toàn" và "thiếu một ô".

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Linear DP
The number of ways to tile follows a pattern which can be reduced to a recurrence relation. We use an iterative approach to compute subsequent values while applying the modulo.
Số cách lát gạch tuân theo một mẫu có thể được rút gọn thành một quan hệ truy hồi. Chúng ta sử dụng cách tiếp cận lặp để tính toán các giá trị tiếp theo đồng thời áp dụng modulo.

---
