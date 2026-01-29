# 910. Smallest Range II / Khoảng cách Nhỏ nhất II

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`. For each index `i`, you must either add `k` to `nums[i]` or subtract `k` from `nums[i]`.
Cho một mảng số nguyên `nums` và một số nguyên `k`. Đối với mỗi chỉ số `i`, bạn phải cộng `k` vào `nums[i]` hoặc trừ `k` từ `nums[i]`.

Return the minimum possible difference between the maximum and minimum elements of the resulting array.
Trả về hiệu số nhỏ nhất có thể giữa các phần tử lớn nhất và nhỏ nhất của mảng kết quả.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting and Greedy Split / Sắp xếp và Chia tách Tham lam
To minimize the gap, we want smaller elements to increase and larger elements to decrease.
Để giảm thiểu khoảng cách, chúng ta muốn các phần tử nhỏ hơn tăng lên và các phần tử lớn hơn giảm đi.

Algorithm:
1. Sort `nums`.
2. Initial result = `nums[n-1] - nums[0]`.
3. Try splitting the array at every index `i` into two parts:
   - Part 1: `nums[0...i]`. Increase these: `nums[j] + k`.
   - Part 2: `nums[i+1...n-1]`. Decrease these: `nums[j] - k`.
4. After split at `i`:
   - New minimum could be `min(nums[0] + k, nums[i+1] - k)`.
   - New maximum could be `max(nums[i] + k, nums[n-1] - k)`.
5. Update result with `max - min`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Pivotal Shift
The optimal arrangement always involves raising a prefix of the sorted array and lowering the corresponding suffix. By testing every possible pivot point where this shift occurs, we find the balance that yields the tightest distribution.
Sự sắp xếp tối ưu luôn liên quan đến việc tăng một tiền tố của mảng đã sắp xếp và giảm hậu tố tương ứng. Bằng cách thử mọi điểm trục có thể xảy ra sự dịch chuyển này, chúng ta tìm thấy sự cân bằng mang lại sự phân bổ hẹp nhất.

---
