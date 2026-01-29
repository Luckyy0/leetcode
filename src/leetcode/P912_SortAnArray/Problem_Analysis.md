# 912. Sort an Array / Sắp xếp một Mảng

## Problem Description / Mô tả bài toán
Given an array of integers `nums`, sort the array in ascending order and return it.
Cho một mảng các số nguyên `nums`, hãy sắp xếp mảng theo thứ tự tăng dần và trả về.

Constraints: Use a built-in function or implement an efficient algorithm like Merge Sort or Heap Sort.
Ràng buộc: Sử dụng một hàm có sẵn hoặc triển khai một thuật toán hiệu quả như Merge Sort hoặc Heap Sort.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Efficient Sorting Algorithms / Các thuật toán Sắp xếp Hiệu quả
1. **Merge Sort**: Divide and conquer, O(N log N) time, O(N) space. Stable.
2. **Quick Sort**: Partitioning, O(N log N) average, O(N^2) worst. Unstable.
3. **Heap Sort**: Using a heap structure, O(N log N) time, O(1) space. Unstable.

In Java, `Arrays.sort()` uses Dual-Pivot Quicksort for primitives and TimSort for objects.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) for Merge Sort or O(log N) for Quick Sort.

---

## Analysis / Phân tích

### Approach: Recursive Decomposition (Merge Sort)
Divide the dataset into two halves, sort them independently, and reintegrate them through a linear merging process. This approach guarantees logarithmic depth and linear work per level, ensuring optimal asymptotic time.
Chia tập dữ liệu thành hai nửa, sắp xếp chúng độc lập và tái hợp chúng thông qua quá trình hợp nhất tuyến tính. Cách tiếp cận này đảm bảo độ sâu logarit và công việc tuyến tính trên mỗi cấp độ, đảm bảo thời gian tiệm cận tối ưu.

---
