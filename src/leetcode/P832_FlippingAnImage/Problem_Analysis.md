# 832. Flipping an Image / Lật Hình ảnh

## Problem Description / Mô tả bài toán
Given an `n x n` binary matrix `image`, flip the image horizontally, then invert it, and return the resulting image.
Cho một ma trận nhị phân `n x n` `image`, hãy lật hình ảnh theo chiều ngang, sau đó đảo ngược nó và trả về hình ảnh kết quả.

- Flip horizontally: reverse each row.
- Invert: replace 0 with 1 and 1 with 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Swapping and Bitwise Operations / Hoán đổi và Thao tác Bit
Algorithm:
1. For each row:
   - Use two pointers `left` and `right`.
   - Swap `row[left]` and `row[right]`, and simultaneously invert them.
   - If `left == right`, just invert the center element.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1) in-place.

---

## Analysis / Phân tích

### Approach: Optimized Row Reversal
Modify each row by processing symmetry points. By performing the horizontal swap and the bitwise inversion in a single pass over half the row width, the operation is maximally efficient.
Sửa đổi từng hàng bằng cách xử lý các điểm đối xứng. Bằng cách thực hiện hoán đổi theo chiều ngang và đảo ngược bit trong một lần duyệt qua một nửa chiều rộng hàng, thao tác đạt hiệu quả tối đa.

---
