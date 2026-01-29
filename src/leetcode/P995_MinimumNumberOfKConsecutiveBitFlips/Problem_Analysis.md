# 995. Minimum Number of K Consecutive Bit Flips / Số lượng lật Bit K liên tiếp tối thiểu

## Problem Description / Mô tả bài toán
You are given a binary array `nums` and an integer `k`. A **k-bit flip** is choosing a subarray of length `k` and flipping all the bits.
Cho một mảng nhị phân `nums` và một số nguyên `k`. Một **phép lật bit k** là việc chọn một mảng con độ dài `k` và lật tất cả các bit đó.

Return the minimum number of k-bit flips required so that there is no `0` in the array. If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Difference Array or Sliding Window / Tham lam với Mảng hiệu hoặc Cửa sổ trượt
Algorithm:
1. Iterate from left to right.
2. If `nums[i]` is currently `0` (after considering previous flips):
   - We MUST flip `nums[i...i+k-1]`.
   - If `i + k > n`, return -1.
   - Use a `Queue` or a counter `curFlips` to track how many active flips affect `nums[i]`.
3. The parity of `curFlips` determines the "flipped" state of `nums[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(K) or O(N).

---

## Analysis / Phân tích

### Approach: Sliding Flips tracking
Apply a greedy strategy by always flipping when a '0' is encountered at the leading edge. To avoid the $O(NK)$ cost of actual array updates, we track of the net flip effect using a sliding window or a difference array, determining the "real" value of each bit dynamically.
Áp dụng chiến lược tham lam bằng cách luôn lật khi gặp số '0' ở cạnh dẫn đầu. Để tránh chi phí $O(NK)$ của việc cập nhật mảng thực tế, chúng ta theo dõi hiệu ứng lật ròng bằng cách sử dụng cửa sổ trượt hoặc mảng hiệu, xác định giá trị "thực" của mỗi bit một cách linh hoạt.

---
