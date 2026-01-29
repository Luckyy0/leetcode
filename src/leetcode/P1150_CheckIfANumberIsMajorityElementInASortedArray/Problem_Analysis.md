# 1150. Check If a Number Is Majority Element in a Sorted Array / Kiểm tra xem Số có phải là Phần tử Đa số trong Mảng đã Sắp xếp không

## Problem Description / Mô tả bài toán
Given an integer array `nums` sorted in non-decreasing order and an integer `target`, return `true` if `target` is a majority element, or `false` otherwise.
A majority element is an element that appears more than `N/2` times.
Cho một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm và một số nguyên `target`, hãy trả về `true` nếu `target` là phần tử đa số, hoặc `false` nếu ngược lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search Bounds / Phạm vi Tìm kiếm Nhị phân
Find first occurrence of a number.
If `target` is majority, it must span at least `N/2 + 1` length.
Let `first` be the index of the first occurrence of `target`.
If `first == -1`, return false.
Check `nums[first + N/2]`. If this matches `target`, then count is sufficient?
Wait, `first + len - 1`.
If `count > N/2`, then `first + N/2` must be `target` because `target` occupies `first` to `first + count - 1`.
So just check if `nums[first + N/2] == target`.
Also check `first < N` and `nums[first] == target`.

Algorithm:
1. `first = lower_bound(target)`.
2. If `first` out of bounds or `nums[first] != target`: return false.
3. Check `first + N/2` index within bounds and equals `target`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search Check
Exploit the sorted nature of the array using Binary Search. Find the first occurrence (insertion point) of `target`. Check if the element at index `first_occurrence + N/2` is also `target`. If it is, `target` must appear at least `N/2 + 1` times (spanning from `first_occurrence` to `first_occurrence + N/2` inclusive), making it a majority element.
Khai thác tính chất đã sắp xếp của mảng bằng cách sử dụng Tìm kiếm Nhị phân. Tìm lần xuất hiện đầu tiên (điểm chèn) của `target`. Kiểm tra xem phần tử tại chỉ số `first_occurrence + N/2` có phải là `target` hay không. Nếu có, `target` phải xuất hiện ít nhất `N/2 + 1` lần (trải dài từ `first_occurrence` đến `first_occurrence + N/2`), khiến nó trở thành phần tử đa số.

---
