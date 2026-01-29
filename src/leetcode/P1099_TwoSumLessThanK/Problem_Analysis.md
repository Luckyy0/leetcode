# 1099. Two Sum Less Than K / Hai Tổng Nhỏ hơn K

## Problem Description / Mô tả bài toán
Given an array `nums` of integers and an integer `k`, return the maximum sum such that there exists `i < j` with `nums[i] + nums[j] = sum` and `sum < k`. If no `i, j` exist satisfying this equation, return -1.
Cho một mảng `nums` các số nguyên và một số nguyên `k`, hãy trả về tổng lớn nhất sao cho tồn tại `i < j` với `nums[i] + nums[j] = sum` và `sum < k`. Nếu không tồn tại `i, j` thỏa mãn phương trình này, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers with Sorting / Hai con trỏ với Sắp xếp
1. Sort `nums`.
2. Initialize `left = 0`, `right = n - 1`.
3. While `left < right`:
   - `sum = nums[left] + nums[right]`.
   - If `sum < k`:
     - This is a valid candidate. Update `maxSum`.
     - Try to increase sum by `left++`.
   - If `sum >= k`:
     - Decrease sum by `right--`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N) or O(1).

---

## Analysis / Phân tích

### Approach: Two-Pointer Convergence
Sort the array to facilitate directional search. Use two pointers starting at both ends. If the current sum is less than `k`, record it as a potential maximum and move the left pointer to seek a larger sum. If the sum is too large (`>= k`), move the right pointer to reduce it.
Sắp xếp mảng để tạo điều kiện thuận lợi cho việc tìm kiếm có hướng. Sử dụng hai con trỏ bắt đầu ở cả hai đầu. Nếu tổng hiện tại nhỏ hơn `k`, hãy ghi lại nó như một mức tối đa tiềm năng và di chuyển con trỏ bên trái để tìm tổng lớn hơn. Nếu tổng quá lớn (`>= k`), hãy di chuyển con trỏ bên phải để giảm nó.

---
