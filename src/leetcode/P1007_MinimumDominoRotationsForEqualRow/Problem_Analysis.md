# 1007. Minimum Domino Rotations For Equal Row / Số lần Xoay Domino Tối thiểu để Hàng bằng nhau

## Problem Description / Mô tả bài toán
In a row of dominoes, `tops[i]` and `bottoms[i]` represent the top and bottom halves of the `i-th` domino.
Trong một hàng domino, `tops[i]` và `bottoms[i]` đại diện cho nửa trên và nửa dưới của quân domino thứ `i`.

We may rotate the `i-th` domino, so that `tops[i]` and `bottoms[i]` swap values.
Chúng ta có thể xoay quân domino thứ `i`, để `tops[i]` và `bottoms[i]` hoán đổi giá trị.

Return the minimum number of rotations so that all the values in `tops` are the same, or all the values in `bottoms` are the same. If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Target Value Identification / Xác định Giá trị Mục tiêu
If a solution exists, the target number *must* be present in every domino.
Nếu tồn tại một giải pháp, số mục tiêu *phải* có mặt trong mọi quân domino.
Therefore, the target must be either `tops[0]` or `bottoms[0]`.

Algorithm:
1. Try to make all tops equal to `tops[0]`.
2. Try to make all bottoms equal to `tops[0]`.
3. Try to make all tops equal to `bottoms[0]`.
4. Try to make all bottoms equal to `bottoms[0]`.
5. If any succeeds, take the minimum rotations.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Candidate Testing
Identify potential target values by examining the first domino. Any valid uniform row must consist of one of the values from this first piece. Test these candidates against the entire array to calculate the cost (swaps) required for uniformity, selecting the minimal valid cost.
Xác định các giá trị mục tiêu tiềm năng bằng cách kiểm tra quân domino đầu tiên. Bất kỳ hàng đồng nhất hợp lệ nào cũng phải bao gồm một trong các giá trị từ quân cờ đầu tiên này. Kiểm tra các ứng cử viên này trên toàn bộ mảng để tính toán chi phí (số lần hoán đổi) cần thiết cho sự đồng nhất, chọn chi phí hợp lệ tối thiểu.

---
