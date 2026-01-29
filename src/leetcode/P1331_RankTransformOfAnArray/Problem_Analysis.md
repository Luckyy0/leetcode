# 1331. Rank Transform of an Array / Chuyển đổi Xếp hạng của Mảng

## Problem Description / Mô tả bài toán
Input array `arr`. Replace each element with its rank.
Rank represents the order.
Unique elements sorted: `v1 < v2 < v3 ...`.
Rank of `v1` is 1, `v2` is 2, etc.
Identical elements share same rank.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting + Hashing
Sort unique elements. Assign rank 1, 2, ...
Use a Map to store `value -> rank`.
Iterate original `arr`, replace with `map[val]`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Clone, Sort, Map
Create a copy of the array and sort it. Iterate through the sorted array to assign ranks to unique elements using a HashMap (or just iterating and skipping duplicates). Then, replace each element in the original array with its rank from the map.
Tạo một bản sao của mảng và sắp xếp nó. Lặp lại qua mảng đã sắp xếp để gán xếp hạng cho các phần tử duy nhất bằng một HashMap (hoặc chỉ lặp lại và bỏ qua các bản sao). Sau đó, thay thế từng phần tử trong mảng ban đầu bằng xếp hạng của nó từ bản đồ.

---
