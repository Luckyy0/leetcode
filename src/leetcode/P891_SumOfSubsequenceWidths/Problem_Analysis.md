# 891. Sum of Subsequence Widths / Tổng Chiều rộng các Dãy con

## Problem Description / Mô tả bài toán
The width of a sequence is the difference between its maximum and minimum elements.
Chiều rộng của một dãy là hiệu số giữa phần tử lớn nhất và nhỏ nhất của nó.

Given an integer array `nums`, return the sum of the widths of all its non-empty subsequences. Modulo 10^9 + 7.
Cho một mảng số nguyên `nums`, hãy trả về tổng chiều rộng của tất cả các dãy con không rỗng của nó. Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting and Contribution Logic / Sắp xếp và Logic Đóng góp
Subsequences do not care about order, so we can sort `nums` first.
Các dãy con không quan tâm đến thứ tự, vì vậy chúng ta có thể sắp xếp `nums` trước.

If `nums` is sorted:
- `nums[i]` is the maximum of all subsequences where it's the largest. These are formed using any subset of elements from `nums[0...i-1]`. Count = $2^i$.
- `nums[i]` is the minimum of all subsequences where it's the smallest. These are formed using any subset of elements from `nums[i+1...n-1]`. Count = $2^{n-1-i}$.

Contribution of `nums[i]` to total sum:
$nums[i] \cdot 2^i - nums[i] \cdot 2^{n-1-i}$.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) to precompute powers of 2 (or O(1) if computed on the fly).

---

## Analysis / Phân tích

### Approach: Elements as Extremes
Sort the array to simplify the identification of minimums and maximums. For each element, calculate how many times it acts as the upper bound versus the lower bound across all possible subsequences.
Sắp xếp mảng để đơn giản hóa việc xác định các giá trị nhỏ nhất và lớn nhất. Đối với mỗi phần tử, hãy tính số lần nó đóng vai trò là giới hạn trên so với giới hạn dưới trên tất cả các dãy con có thể.

---
