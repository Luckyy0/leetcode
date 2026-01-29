# 704. Binary Search / Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.
Cho một mảng các số nguyên `nums` được sắp xếp theo thứ tự tăng dần và một số nguyên `target`, hãy viết một hàm để tìm kiếm `target` trong `nums`. Nếu `target` tồn tại, hãy trả về chỉ số của nó. Ngược lại, trả về `-1`.

You must write an algorithm with `O(log n)` runtime complexity.
Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divide and Conquer / Chia để trị
Binary Search works by repeatedly dividing the search interval in half.
Tìm kiếm nhị phân hoạt động bằng cách chia đôi khoảng tìm kiếm liên tiếp.

Initialize `left = 0`, `right = n - 1`.
In each step:
- `mid = left + (right - left) / 2`.
- If `nums[mid] == target`, return `mid`.
- If `nums[mid] < target`, discard left half: `left = mid + 1`.
- If `nums[mid] > target`, discard right half: `right = mid - 1`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Classic Binary Search
A fundamental search algorithm on sorted data. Using `left + (right - left) / 2` avoids potential integer overflow.
Một thuật toán tìm kiếm cơ bản trên dữ liệu đã sắp xếp. Sử dụng `left + (right - left) / 2` để tránh tràn số nguyên tiềm ẩn.

---
