# 1287. Element Appearing More Than 25% In Sorted Array / Phần tử Xuất hiện Nhiều hơn 25% Trong Mảng đã Sắp xếp

## Problem Description / Mô tả bài toán
Given sorted array. Find integer that occurs more than 25% of time.
Exact one answer.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Property of Sorted Array
If an element appears > 25% (N/4 times), it must appear at one of the indices: `N/4`, `N/2`, `3N/4`.
Wait. Not necessarily EXACTLY at those indices, but it must span a length > N/4.
If we check elements at `i = 0, N/4, N/2, 3N/4, N`, one of them MUST be the majority candidate.
For each candidate, find first and last occurrence using Binary Search to confirm count.
Actually, simplest check:
Candidates: `arr[N/4]`, `arr[N/2]`, `arr[3N/4]`.
Check count > N/4.
Or just iterate with sliding window of size `N/4`. But linear scan is O(N), checking candidates is O(log N).
Checking candidates is better.
Or even simpler:
Iterate with skip?
Only check `arr[i]` where `i` are `n/4`, `n/2`, `3n/4`.
For a candidate `x`, find `first` and `last`. `count = last - first + 1`.
Since only 3 candidates, O(log N).

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Check Candidates
Since the array is sorted and the target element appears more than 25% of the time, it must occupy at least one position in the set $\{ \text{arr}[n/4], \text{arr}[n/2], \text{arr}[3n/4] \}$. Identify these candidates. For each candidate, use binary search (specifically `lower_bound` and `upper_bound`) to find its frequency. If frequency $> n/4$, return that element.
Vì mảng được sắp xếp và phần tử mục tiêu xuất hiện nhiều hơn 25% thời gian, nó phải chiếm ít nhất một vị trí trong tập hợp $\{ \text{arr}[n/4], \text{arr}[n/2], \text{arr}[3n/4] \}$. Xác định các ứng viên này. Đối với mỗi ứng viên, sử dụng tìm kiếm nhị phân (cụ thể là `lower_bound` và `upper_bound`) để tìm tần suất của nó. Nếu tần suất $> n/4$, trả về phần tử đó.

---
