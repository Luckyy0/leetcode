# 908. Smallest Range I / Khoảng cách Nhỏ nhất I

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`. For each index `i`, you can choose an integer `x` such that `-k <= x <= k`, and add `x` to `nums[i]`.
Cho một mảng số nguyên `nums` và một số nguyên `k`. Đối với mỗi chỉ số `i`, bạn có thể chọn một số nguyên `x` sao cho `-k <= x <= k` và cộng `x` vào `nums[i]`.

Return the minimum possible difference between the maximum and minimum elements of the resulting array.
Trả về hiệu số nhỏ nhất có thể giữa các phần tử lớn nhất và nhỏ nhất của mảng kết quả.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Range Compression / Nén Khoảng cách
To minimize the gap between max and min:
1. We should try to decrease the maximum: `new_max = max(nums) - k`.
2. We should try to increase the minimum: `new_min = min(nums) + k`.

If `new_max <= new_min`, we can make all elements equal, so the difference is 0.
Else, the difference is `new_max - new_min`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Boundary Convergence
Focus only on the global extremes. By moving the maximum downward and the minimum upward as much as possible, we determine the narrowest possible band that the entire dataset can inhabit.
Chỉ tập trung vào các giá trị cực biên toàn cục. Bằng cách di chuyển giá trị lớn nhất xuống dưới và giá trị nhỏ nhất lên trên nhiều nhất có thể, chúng ta xác định dải hẹp nhất có thể mà toàn bộ tập dữ liệu có thể nằm trong đó.

---
