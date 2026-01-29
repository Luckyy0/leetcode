# 888. Fair Candy Swap / Trao đổi Kẹo Công bằng

## Problem Description / Mô tả bài toán
Alice and Bob have different total numbers of candies. They want to swap one candy each so that they both have the same total number of candies.
Alice và Bob có tổng số kẹo khác nhau. Họ muốn mỗi người đổi một cái kẹo cho nhau sao cho sau đó cả hai có cùng tổng số kẹo.

Return an array `[aliceSize, bobSize]`.
Trả về một mảng `[aliceSize, bobSize]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Algebraic Balance / Cân bằng Đại số
Let $S_A$ and $S_B$ be the initial sums.
Suppose Alice gives $x$ and Bob gives $y$.
New totals: $S_A - x + y = S_B - y + x$
$2y - 2x = S_B - S_A$
$y = x + (S_B - S_A) / 2$.

Algorithm:
1. Calculate sums of both arrays.
2. Put Bob's candy sizes in a `HashSet`.
3. For each candy $x$ of Alice, check if $y$ exists in Bob's set.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(M).

---

## Analysis / Phân tích

### Approach: Target Search
Calculate the required net change for each person. For every candy in Alice's possession, calculate the specific sized candy Bob must provide to reach equilibrium, then use a hash set for an efficient lookup.
Tính toán mức thay đổi ròng cần thiết cho mỗi người. Đối với mỗi chiếc kẹo Alice sở hữu, hãy tính kích thước kẹo cụ thể mà Bob phải cung cấp để đạt được trạng thái cân bằng, sau đó sử dụng một hash set để tra cứu hiệu quả.

---
