# 769. Max Chunks To Make Sorted / Số lượng Mảng con tối đa để Sắp xếp

## Problem Description / Mô tả bài toán
You are given an integer array `arr` of length `n` that is a permutation of the integers in the range `[0, n - 1]`.
Bạn được cho một mảng số nguyên `arr` có độ dài `n` là một hoán vị của các số nguyên trong phạm vi `[0, n - 1]`.

We split `arr` into some number of chunks. If we sort each chunk and concatenate them, the resulting array should be sorted. Return the maximum number of chunks we can make.
Chúng ta chia `arr` thành một số mảng con. Nếu chúng ta sắp xếp từng mảng con và nối chúng lại, mảng kết quả phải được sắp xếp. Trả về số lượng mảng con tối đa chúng ta có thể tạo ra.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Target Tracking / Theo dõi Mục tiêu
Since the array is a permutation of `0...n-1`, the sorted version of the array is simply `0, 1, 2, ..., n-1`.
Vì mảng là một hoán vị của `0...n-1`, phiên bản đã sắp xếp của mảng chỉ đơn giản là `0, 1, 2, ..., n-1`.

A chunk `[start, end]` can be sorted and substituted correctly if the maximum value in that chunk is equal to the index `end`.
Một mảng con `[start, end]` có thể được sắp xếp và thay thế chính xác nếu giá trị lớn nhất trong mảng con đó bằng chỉ số `end`.

Algorithm:
- Iterate `i` from 0 to `n-1`.
- `max_val = max(max_val, arr[i])`.
- If `max_val == i`, we can form a chunk ending at `i`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Running Maximum logic
Because the values are bound to `[0, i]`, having `max(arr[0...i]) == i` implies all values from 0 to `i` are contained within the first `i+1` elements.
Bởi vì các giá trị bị ràng buộc trong `[0, i]`, việc có `max(arr[0...i]) == i` ngụ ý rằng tất cả các giá trị từ 0 đến `i` đều nằm trong `i+1` phần tử đầu tiên.

---
