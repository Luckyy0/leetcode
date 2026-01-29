# 1187. Make Array Strictly Increasing / Làm Mảng Tăng Nghiêm ngặt

## Problem Description / Mô tả bài toán
Given two integer arrays `arr1` and `arr2`, return the minimum number of operations (possibly zero) needed to make `arr1` strictly increasing.
In one operation, you can choose two indices `0 <= i < arr1.length` and `0 <= j < arr2.length` and do the assignment `arr1[i] = arr2[j]`.
If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Sorting / Binary Search
`dp[i][val]` = min operations to make `arr1[0..i]` increasing, with `arr1[i] == val`. `val` is potentially huge, so this state is bad.
Better State: `dp[i][ops]` = minimum ending value of `arr1[0..i]` using exactly `ops` operations.
`arr1` length up to 2000. `ops` can be up to 2000. Value: integer.
Is `dp[i]` a map `ops -> minValue`? Yes.
Or `dp[i][length]`: min ending value for increasing sequence of length `i`?
Let's iterate `i`. `Map<Integer, Integer> dp` (lastVal -> minOps).
Actually `dp[i]` = map `endVal -> ops`.
Transitions at `i`:
For each `(prevVal, ops)` in `dp[i-1]`:
1. Keep `arr1[i]`: if `arr1[i] > prevVal`, new state `(arr1[i], ops)`.
2. Swap `arr1[i]` with some `arr2[k]`: if `arr2[k] > prevVal`, new state `(arr2[k], ops + 1)`.
   To minimize `arr2[k]`, pick smallest `arr2[k] > prevVal` (Binary search on sorted `arr2`).
Filter states: if multiple states have same `endVal`, keep min `ops`. If multiple states have same `ops`, keep min `endVal`?
Actually, if we have states `(v1, op1)` and `(v2, op2)`:
If `v1 <= v2` and `op1 <= op2`, then `(v2, op2)` is suboptimal. Dominance check.

### Complexity / Độ phức tạp
- **Time**: O(N * min(N, M) * log M). Or O(N^2 log M).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: DP with State Compression
Sort `arr2` to facilitate efficient replacement selection. Use DP where `dp[val] = ops` stores the minimum operations needed to reach an strictly increasing prefix ending with value `val` at the current index. At step `i`, generate new states based on the previous states: either by keeping `arr1[i]` (if valid) or replacing it with the smallest element from `arr2` that is greater than the previous end value (found via binary search). Pruning suboptimal states (larger end value with more or equal ops) keeps the map size small.
Sắp xếp `arr2` để tạo điều kiện thuận lợi cho việc lựa chọn thay thế hiệu quả. Sử dụng DP trong đó `dp[val] = ops` lưu trữ số lượng thao tác tối thiểu cần thiết để đạt được tiền tố tăng nghiêm ngặt kết thúc bằng giá trị `val` tại chỉ mục hiện tại. Ở bước `i`, tạo các trạng thái mới dựa trên các trạng thái trước đó: bằng cách giữ lại `arr1[i]` (nếu hợp lệ) hoặc thay thế nó bằng phần tử nhỏ nhất từ `arr2` lớn hơn giá trị kết thúc trước đó (được tìm thấy thông qua tìm kiếm nhị phân). Việc cắt tỉa các trạng thái không tối ưu (giá trị cuối lớn hơn với nhiều hoặc bằng ops) giúp giữ kích thước bản đồ nhỏ.

---
