# 768. Max Chunks To Make Sorted II / Số lượng Mảng con tối đa để Sắp xếp II

## Problem Description / Mô tả bài toán
This is a more general version of "Max Chunks To Make Sorted". The elements in the array `arr` are not necessarily in range `[0, n-1]` and can have duplicates.
Đây là phiên bản tổng quát hơn của bài toán "Số lượng mảng con tối đa để sắp xếp". Các phần tử trong mảng `arr` không nhất thiết phải nằm trong phạm vi `[0, n-1]` và có thể có các giá trị trùng lặp.

We split `arr` into some number of chunks. If we sort each chunk and concatenate them, the resulting array should be sorted.
Chúng ta chia `arr` thành một số mảng con (chunk). Nếu chúng ta sắp xếp từng mảng con và nối chúng lại, mảng kết quả phải được sắp xếp.

Return the maximum number of chunks we can make.
Trả về số lượng mảng con tối đa chúng ta có thể tạo ra.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Max and Suffix Min / Cực đại Tiền tố và Cực tiểu Hậu tố
We can split between `i` and `i+1` if the maximum of the prefix `arr[0...i]` is less than or equal to the minimum of the suffix `arr[i+1...n-1]`.
Chúng ta có thể chia giữa `i` và `i+1` nếu giá trị lớn nhất của tiền tố `arr[0...i]` nhỏ hơn hoặc bằng giá trị nhỏ nhất của hậu tố `arr[i+1...n-1]`.

Algorithm:
1. Compute `rightMin[i]` which is the minimum value in `arr[i...n-1]`.
2. Iterate `i` from 0 to `n-2`:
   - Keep track of `leftMax`.
   - if `leftMax <= rightMin[i+1]`, we can cut.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) to store suffix minimums.

---

## Analysis / Phân tích

### Approach: Boundary Check via Min/Max
A split is valid if every element to the left is smaller than every element to the right. precomputing suffix minimums allows for an O(N) check at every potential split point.
Một điểm chia là hợp lệ nếu mọi phần tử bên trái đều nhỏ hơn mọi phần tử bên phải. Việc tính toán trước các giá trị cực tiểu của hậu tố cho phép kiểm tra O(N) tại mọi điểm chia tiềm năng.

---
