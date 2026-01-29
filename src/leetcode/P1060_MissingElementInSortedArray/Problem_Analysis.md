# 1060. Missing Element in Sorted Array / Phần tử Còn thiếu trong Mảng đã sắp xếp

## Problem Description / Mô tả bài toán
Given an integer array `nums` which is sorted in **ascending order** and all of its elements are **unique** and given also an integer `k`, return the `k-th` missing number starting from the leftmost number of the array.
Cho một mảng số nguyên `nums` được sắp xếp theo **thứ tự tăng dần** và tất cả các phần tử của nó là **duy nhất** và cũng cho một số nguyên `k`, hãy trả về số còn thiếu thứ `k` bắt đầu từ số ngoài cùng bên trái của mảng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search / Tìm kiếm Nhị phân
Function `missing(idx)` returns count of missing numbers in `nums[0...idx]`.
`missing(idx) = (nums[idx] - nums[0]) - idx`.

We want to find index `i` such that `missing(i) < k` and `missing(i+1) >= k`.
Then result is `nums[i] + k - missing(i)`.

Algorithm:
1. If `k > missing(n-1)`, result is `nums[n-1] + k - missing(n-1)`.
2. Binary search `left = 0, right = n-1`.
3. Find split point.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Gap Calculation Search
Calculate the number of missing elements up to any index $i$ using the formula $(nums[i] - nums[0]) - i$. Use binary search to locate the specific interval between indices where the $k$-th missing number resides, then compute its value relative to the interval start.
Tính toán số lượng phần tử bị thiếu cho đến bất kỳ chỉ số $i$ nào bằng cách sử dụng công thức $(nums[i] - nums[0]) - i$. Sử dụng tìm kiếm nhị phân để định vị khoảng cụ thể giữa các chỉ số nơi số bị thiếu thứ $k$ cư trú, sau đó tính toán giá trị của nó so với phần bắt đầu khoảng.

---
