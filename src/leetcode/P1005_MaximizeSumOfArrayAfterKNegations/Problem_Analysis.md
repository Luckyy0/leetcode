# 1005. Maximize Sum Of Array After K Negations / Tối đa hóa Tổng của Mảng sau K lần Phủ định

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, modify the array by choosing an index `i` and replacing `nums[i]` with `-nums[i]`, `k` times. You want to maximize the sum of the array.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy sửa đổi mảng bằng cách chọn một chỉ số `i` và thay thế `nums[i]` bằng `-nums[i]`, `k` lần. Bạn muốn tối đa hóa tổng của mảng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Sorting / Sắp xếp Tham lam
Algorithm:
1. Sort `nums` in increasing order.
2. Flip negative numbers starting from the smallest (most negative) to increase the sum the most.
   - For `i` from 0 to `n-1`: if `nums[i] < 0` and `k > 0`, flip `nums[i]`, `k--`.
3. If `k` is still positive and odd:
   - We must perform one net flip. To minimize damage, flip the element with the smallest absolute value.
   - Sort again or track the minimum absolute value during step 2.
4. Calculate sum.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(1) or O(log N) for sort stack.

---

## Analysis / Phân tích

### Approach: Mitigation of Negativity
Prioritize negating the most negative numbers to turn them into large positive gains. Once all negatives are exhausted, if flips remain, sacrifice the smallest absolute value (whether positive or formerly negative) to minimize the reduction in total sum.
Ưu tiên phủ định các số âm nhất để biến chúng thành các khoản tăng dương lớn. Khi tất cả các số âm đã hết, nếu vẫn còn lượt lật, hãy hy sinh giá trị tuyệt đối nhỏ nhất (dù là dương hay trước đây là âm) để giảm thiểu mức giảm trong tổng số.

---
