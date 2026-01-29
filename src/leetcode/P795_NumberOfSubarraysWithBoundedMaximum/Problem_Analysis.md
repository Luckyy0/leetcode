# 795. Number of Subarrays with Bounded Maximum / Số lượng Mảng con có Cực đại trong Khoảng

## Problem Description / Mô tả bài toán
Given an integer array `nums` and two integers `left` and `right`, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range `[left, right]`.
Cho một mảng số nguyên `nums` và hai số nguyên `left` và `right`, hãy trả về số lượng mảng con liên tiếp không rỗng sao cho giá trị của phần tử lớn nhất trong mảng con đó nằm trong phạm vi `[left, right]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subtraction logic / Logic Phép trừ
Let `count(K)` be the number of subarrays whose maximum element is `<= K`.
The answer is `count(right) - count(left - 1)`.

How to calculate `count(K)`?
- Iterate through the array.
- If an element is `<= K`, it can extend the current "valid" range of elements.
- If an element is `> K`, the current range is broken.

If a contiguous segment has length `L` where all elements are `<= K`, the number of subarrays it forms is `L * (L + 1) / 2`.
Nếu một đoạn liên tiếp có độ dài `L` trong đó tất cả các phần tử `<= K`, số lượng mảng con mà nó tạo ra là `L * (L + 1) / 2`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Range-based counting
The total number of subarrays satisfies the condition if they fall under the 'upper' limit but not entirely under the 'lower' limit.
Tổng số mảng con thỏa mãn điều kiện nếu chúng nằm dưới giới hạn 'trên' nhưng không nằm hoàn toàn dưới giới hạn 'dưới'.

---
