# 1537. Get the Maximum Score / Nhận Điểm Tối đa

## Problem Description / Mô tả bài toán
Two sorted arrays `nums1`, `nums2`.
Valid path: Start at beginning of either. Move right.
Switch between arrays ONLY at common values.
Max sum. Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Dynamic Programming
Path consists of segments between common values.
Between two common values (or start/end), we can choose sum from `nums1` segment OR `nums2` segment.
Algorithm:
Identify "checkpoints" (common values).
For each segment between checkpoints, calculate sum1 and sum2.
Add `max(sum1, sum2)` to accumulating total.
Add checkpoint value itself.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers
Iterate `i` (nums1) and `j` (nums2).
Accumulate `sum1`, `sum2`.
If `nums1[i] < nums2[j]`: `sum1 += nums1[i]`. `i++`.
If `nums1[i] > nums2[j]`: `sum2 += nums2[j]`. `j++`.
If `nums1[i] == nums2[j]`: `res += max(sum1, sum2) + nums1[i]`. Reset sums. `i++, j++`.
After loop, add remaining sums.
Lặp lại `i` (nums1) và `j` (nums2).
Tích lũy `sum1`, `sum2`.
Nếu bằng nhau: `res += max(sum1, sum2) + nums1[i]`. Đặt lại sums.

---
