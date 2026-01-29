# 1063. Number of Valid Subarrays / Số lượng Mảng con Hợp lệ

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the number of subarrays `nums[i..j]` satisfying:
Cho một mảng số nguyên `nums`, hãy trả về số lượng các mảng con `nums[i..j]` thỏa mãn:
`nums[i]` is the leftmost element of the subarray, and it is the minimum element in the subarray.
`nums[i]` là phần tử ngoài cùng bên trái của mảng con, và nó là phần tử nhỏ nhất trong mảng con.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Next Smaller Element
For each `i`, we want to find the furthest `j` such that for all `k` in `[i, j]`, `nums[k] >= nums[i]`.
Actually, the condition is `nums[i]` is minimum.
So range `[i, j]` is valid if `min(nums[i...j]) == nums[i]`.
This is true until we hit the first element smaller than `nums[i]` to the right.
The count of valid subarrays starting at `i` is `(NextSmallerIndex - i)`.

Algorithm:
1. Use a Monotonic Stack to find Next Smaller Element index for each element.
2. Sum up distances.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Right-Bound Discovery
Identify the "span of dominance" for each element. An element $val$ at index $i$ remains the minimum of a subarray starting at $i$ as long as no subsequent element is smaller than $val$. Using a monotonic stack (Next Lower Element), we find the right boundary $R$ where this condition breaks. The number of valid subarrays starting at $i$ is simply $R - i$.
Xác định "khoảng thống trị" cho mỗi phần tử. Một phần tử $val$ tại chỉ số $i$ vẫn là giá trị nhỏ nhất của một mảng con bắt đầu tại $i$ miễn là không có phần tử tiếp theo nào nhỏ hơn $val$. Sử dụng ngăn xếp đơn điệu (Phần tử Thấp hơn Tiếp theo), chúng ta tìm thấy ranh giới bên phải $R$ nơi điều kiện này bị phá vỡ. Số lượng mảng con hợp lệ bắt đầu tại $i$ chỉ đơn giản là $R - i$.

---
