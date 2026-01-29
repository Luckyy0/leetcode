# 835. Image Overlap / Sự Trùng lặp Hình ảnh

## Problem Description / Mô tả bài toán
You are given two binary matrices `img1` and `img2` of same size `n x n`.
Bạn được cấp hai ma trận nhị phân `img1` và `img2` có cùng kích thước `n x n`.

We can translate `img1` by sliding it any number of units left, right, up, or down.
Chúng ta có thể dịch chuyển `img1` bằng cách trượt nó một số đơn vị bất kỳ sang trái, phải, lên hoặc xuống.

Return the maximum possible overlap (number of cells that have 1 in both matrices) after translation.
Trả về sự trùng lặp tối đa có thể (số lượng ô có giá trị 1 trong cả hai ma trận) sau khi dịch chuyển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Vector Difference / Hiệu Vector
Every pair of `1` bits (one from `img1` and one from `img2`) implies a specific translation vector that would align them.
Mỗi cặp bit `1` (một từ `img1` và một từ `img2`) gợi ý một vector dịch chuyển cụ thể để căn chỉnh chúng.

Algorithm:
1. List all coordinates of `1` bits in `img1` and `img2`.
2. For every bit `(r1, c1)` in `img1` and every bit `(r2, c2)` in `img2`:
   - Calculate the distance vector `(r2 - r1, c2 - c1)`.
   - Use a `Map<Vector, Integer>` to count how many pairs share the same distance vector.
3. The maximum count in the map is the result.

### Complexity / Độ phức tạp
- **Time**: O(N^4) in worst case (if all are 1s), but usually $O(B_1 \cdot B_2)$ where $B$ is the number of 1 bits.
- **Space**: O(B_1 \cdot B_2).

---

## Analysis / Phân tích

### Approach: Vector Alignment count
Focus only on the set bits. By calculating the relative distance between every possible pair of bits, we identify which translation vector aligns the most bits simultaneously.
Chỉ tập trung vào các bit được thiết lập. Bằng cách tính toán khoảng cách tương đối giữa mọi cặp bit có thể, chúng ta xác định vector dịch chuyển nào căn chỉnh được nhiều bit nhất đồng thời.

---
