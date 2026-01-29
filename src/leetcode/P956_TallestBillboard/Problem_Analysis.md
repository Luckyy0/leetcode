# 956. Tallest Billboard / Bảng quảng cáo Cao nhất

## Problem Description / Mô tả bài toán
You have a set of `rods` of different lengths. You want to build a billboard such that it has two support steel rods of equal height.
Bạn có một bộ các thanh `rods` với độ dài khác nhau. Bạn muốn xây dựng một bảng quảng cáo sao cho nó có hai thanh thép đỡ có cùng độ cao.

Return the largest possible height of your billboard.
Hãy trả về độ cao lớn nhất có thể của bảng quảng cáo.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Difference-based DP / Quy hoạch Động / DP dựa trên hiệu số
This is a variation of the subset sum problem.
Đây là một biến thể của bài toán tổng tập con.

Algorithm:
1. `dp[d]` = maximum possible height of the shorter rod when the difference between two rods is `d`.
2. For each rod `r`:
   - We can:
     1. Add to taller rod: new diff `d + r`, height of shorter rod remains same.
     2. Add to shorter rod:
        - If `r < d`: new diff `d - r`, shorter rod height becomes `dp[d] + r`.
        - If `r >= d`: new diff `r - d`, shorter rod height becomes `dp[d] + d`.
     3. Not use at all.

### Complexity / Độ phức tạp
- **Time**: O(N * Sum).
- **Space**: O(Sum).

---

## Analysis / Phân tích

### Approach: Differential State Tracking
Maintain a mapping from the difference between two sides to the maximum height of the smaller side. By updating this map for each rod, we explore all combinations of addition and subtraction, finally identifying the maximum height where the difference is zero.
Duy trì một giá trị ánh xạ từ sự chênh lệch giữa hai bên đến chiều cao tối đa của bên nhỏ hơn. Bằng cách cập nhật bản đồ này cho mỗi thanh, chúng ta khám phá tất cả các tổ hợp cộng và trừ, cuối cùng xác định chiều cao tối đa khi sự chênh lệch bằng không.

---
