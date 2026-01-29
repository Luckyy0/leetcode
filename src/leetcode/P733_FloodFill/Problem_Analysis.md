# 733. Flood Fill / Thuật toán Loang (Flood Fill)

## Problem Description / Mô tả bài toán
An image is represented by an `m x n` integer grid `image` where `image[i][j]` represents the pixel value of the image.
Một hình ảnh được biểu diễn bằng một lưới số nguyên `m x n` `image` trong đó `image[i][j]` biểu thị giá trị pixel của hình ảnh.

You are also given three integers `sr`, `sc`, and `color`. You should perform a **flood fill** on the image starting from the pixel `image[sr][sc]`.
Bạn cũng được cho ba số nguyên `sr`, `sc` và `color`. Bạn nên thực hiện một **loang màu (flood fill)** trên hình ảnh bắt đầu từ pixel `image[sr][sc]`.

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, and so on. Replace the color of all of the aforementioned pixels with `color`.
Để thực hiện loang màu, hãy xem xét pixel bắt đầu, cộng với bất kỳ pixel nào được kết nối theo 4 hướng với pixel bắt đầu có cùng màu với pixel bắt đầu, v.v. Thay thế màu của tất cả các pixel nói trên bằng `color`.

Return the modified image.
Trả về hình ảnh đã được sửa đổi.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) / Tìm kiếm theo Chiều sâu
This is a standard connectivity problem.
Đây là một bài toán kết nối tiêu chuẩn.

1. Note the `originalColor` of the starting pixel.
2. If `originalColor == color`, immediately return (nothing to change).
3. Recursively visit all neighbors with `originalColor` and change them to `newColor`.

### Complexity / Độ phức tạp
- **Time**: O(N * M) where N and M are dimensions.
- **Space**: O(N * M) recursion stack.

---

## Analysis / Phân tích

### Approach: Recursive Connection Traversal
Simple flood fill logic. Important: check if the target color is the same as the start color to avoid infinite recursion.
Logic loang màu đơn giản. Quan trọng: kiểm tra xem màu mục tiêu có giống màu bắt đầu không để tránh đệ quy vô hạn.

---
