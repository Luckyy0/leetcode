# 48. Rotate Image / Xoay Ảnh

## Problem Description / Mô tả bài toán
You are given an `n x n` 2D matrix representing an image, rotate the image by **90 degrees (clockwise)**.
Bạn được cho một ma trận 2D `n x n` đại diện cho một hình ảnh, hãy xoay hình ảnh **90 độ (theo chiều kim đồng hồ)**.

You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.
Bạn phải xoay hình ảnh **tại chỗ**, nghĩa là bạn phải sửa đổi ma trận 2D đầu vào trực tiếp. **KHÔNG** cấp phát ma trận 2D khác và thực hiện xoay.

### Example 1:
```text
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```

### Example 2:
```text
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```

## Constraints / Ràng buộc
- `n == matrix.length == matrix[i].length`
- `1 <= n <= 20`
- `-1000 <= matrix[i][j] <= 1000`

---

## Analysis / Phân tích

### Approach 1: Transpose + Reverse / Chuyển Vị + Đảo Ngược
- **Idea**: Rotating 90 degrees clockwise can be achieved by two steps:
    1.  **Transpose**: Swap `matrix[i][j]` with `matrix[j][i]`. (Mirror along main diagonal).
    2.  **Reverse Rows**: Reverse each row `matrix[i]`.
- **Logic**:
    - Original: Row `i`.
    - Transposed: Row `i` becomes Col `i`.
    - Reversed: Col `i` is flipped horizontally.
    - Result: `matrix[i][j]` moves to `matrix[j][n-1-i]`.
- **Time Complexity**: O(N^2).
- **Space Complexity**: O(1).

### Approach 2: Rotate Four Rectangles / Xoay Bốn Hình Chữ Nhật
- **Idea**: Perform 4-way swaps for each cell in the top-left quadrant.
- **Complexity**: Same O(N^2).

---

## Edge Cases / Các trường hợp biên
1.  **1x1 Matrix**: No change.
