# 992. Subarrays with K Different Integers / Mảng con có K số nguyên khác nhau

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return the number of **good subarrays** of `nums`.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về số lượng **mảng con tốt** của `nums`.

A good subarray is a subarray that has exactly `k` different integers.
Một mảng con tốt là một mảng con có đúng `k` số nguyên khác nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window (atMostK - atMostK-1) / Cửa sổ trượt (Tối đa K - Tối đa K-1)
"Exactly K" is hard to count directly with sliding window because the window is not monotonic.
"Chính xác K" rất khó đếm trực tiếp bằng cửa sổ trượt vì cửa sổ này không đơn điệu.

Algorithm:
1. `count(exactly K) = count(at most K) - count(at most K - 1)`.
2. `atMost(k)`:
   - Use a sliding window with a frequency map.
   - Expand `right` pointer.
   - If `map.size() > k`, shrink `left`.
   - Number of subarrays ending at `right` is `right - left + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Boundary Difference Decomposition
Transform the non-monotonic "Exactly K" problem into two monotonic "At Most K" sub-problems. This allows for an efficient linear scan using sliding windows, where the difference between the two inclusive results yields the count for the specific target density.
Chuyển đổi bài toán "Chính xác K" không đơn điệu thành hai bài toán con "Tối đa K" đơn điệu. Điều này cho phép thực hiện quét tuyến tính hiệu quả bằng cách sử dụng các cửa sổ trượt, trong đó sự khác biệt giữa hai kết quả bao hàm sẽ mang lại số lượng cho mật độ mục tiêu cụ thể.

---
