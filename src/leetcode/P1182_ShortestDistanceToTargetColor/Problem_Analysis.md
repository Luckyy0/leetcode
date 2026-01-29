# 1182. Shortest Distance to Target Color / Khoảng cách Ngắn nhất đến Màu Mục tiêu

## Problem Description / Mô tả bài toán
You are given an array `colors`, which values are 1, 2, or 3.
You are also given some `queries`. Each query consists of `[index, target_color]`.
Find shortest distance between `index` and a color `target_color`.
Distance is `|i - j|`. Return -1 if no such color.
Bạn được cho một mảng `colors`, các giá trị là 1, 2 hoặc 3.
Bạn cũng được một số `queries`. Mỗi truy vấn bao gồm `[index, target_color]`.
Tìm khoảng cách ngắn nhất giữa `index` và một màu `target_color`.
Khoảng cách là `|i - j|`. Trả về -1 nếu không có màu như vậy.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Precomputed Arrays (Left/Right Passes) / Mảng Tính toán trước (Duyệt Trái/Phải)
Since only 3 colors.
We can compute `left[i][c]` and `right[i][c]` for all `i` and `c in {1,2,3}`.
`left[i][c]`: nearest index of color `c` at or before `i`.
`right[i][c]`: nearest index of color `c` at or after `i`.
Dist = `min(|i - left|, |i - right|)`.

### Complexity / Độ phức tạp
- **Time**: O(N + Q).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Bidirectional Precomputation
Since there are only 3 distinct colors, we can precompute the nearest occurrence of each color for every index. Create two 2D arrays (size $N \times 4$): `left_dist` and `right_dist`. Iterate one pass from left to right to fill `left_dist` (distance to nearest color to the left), and one pass from right to left for `right_dist`. For each query, simply return the minimum of the left and right distances in O(1).
Vì chỉ có 3 màu phân biệt, chúng ta có thể tính toán trước lần xuất hiện gần nhất của mỗi màu cho mọi chỉ số. Tạo hai mảng 2D (kích thước $N \times 4$): `left_dist` và `right_dist`. Lặp một lần từ trái sang phải để điền vào `left_dist` (khoảng cách đến màu gần nhất bên trái) và một lần từ phải sang trái cho `right_dist`. Đối với mỗi truy vấn, chỉ cần trả về giá trị nhỏ nhất của khoảng cách trái và phải trong O(1).

---
