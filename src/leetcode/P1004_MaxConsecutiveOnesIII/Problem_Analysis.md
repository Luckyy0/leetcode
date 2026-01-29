# 1004. Max Consecutive Ones III / Số lượng số 1 Liên tiếp Tối đa III

## Problem Description / Mô tả bài toán
Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` `0`s.
Cho một mảng nhị phân `nums` và một số nguyên `k`, hãy trả về số lượng số `1` liên tiếp tối đa trong mảng nếu bạn có thể lật tối đa `k` số `0`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
The problem is equivalent to finding the longest subarray with at most `k` zeros.
Bài toán tương đương với việc tìm mảng con dài nhất có tối đa `k` số không.

Algorithm:
1. `left = 0`, `zeros = 0`.
2. Iterate `right` from 0 to `n-1`.
3. If `nums[right] == 0`, `zeros++`.
4. While `zeros > k`:
   - If `nums[left] == 0`, `zeros--`.
   - `left++`.
5. Update `maxLen = max(maxLen, right - left + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Elastic Window Resizing
Maintain a dynamic window that expands to include new elements and contracts from the left only when the "budget" of K flips is exceeded. The width of this window naturally converges to the maximum satisfiable length.
Duy trì một cửa sổ động mở rộng để bao gồm các phần tử mới và thu hẹp từ bên trái chỉ khi "ngân sách" của K lần lật bị vượt quá. Chiều rộng của cửa sổ này hội tụ tự nhiên đến độ dài thỏa mãn tối đa.

---
