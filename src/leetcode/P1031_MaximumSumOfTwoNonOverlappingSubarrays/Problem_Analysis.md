# 1031. Maximum Sum of Two Non-Overlapping Subarrays / Tổng Lớn nhất của Hai Mảng con Không Chồng chéo

## Problem Description / Mô tả bài toán
Given an integer array `nums` and two integers `firstLen` and `secondLen`, return the maximum sum of two non-overlapping subarrays with lengths `firstLen` and `secondLen`.
Cho một mảng số nguyên `nums` và hai số nguyên `firstLen` và `secondLen`, hãy trả về tổng lớn nhất của hai mảng con không chồng chéo nhau với độ dài là `firstLen` và `secondLen`.

The array with length `firstLen` could occur before or after the array with length `secondLen`, but they must not overlap.
Mảng có độ dài `firstLen` có thể xuất hiện trước hoặc sau mảng có độ dài `secondLen`, nhưng chúng không được chồng chéo.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum and Linear Scan / Tổng Tiền tố và Quét Tuyến tính
Let `L` be `firstLen` and `M` be `secondLen`.
We need to maximize `sum(L) + sum(M)` where ranges don't overlap.

Two cases:
1. `L` appears before `M`.
   - At index `i` (end of `M`), we need `sum(current M) + max(sum of L ending before i-M)`.
2. `M` appears before `L`.
   - At index `i` (end of `L`), we need `sum(current L) + max(sum of M ending before i-L)`.

Algorithm:
1. Compute prefix sums for O(1) range sum.
2. Iterate `i` from `L+M` to `N`.
3. Maintenance `maxL` (max sum of length L seen so far) and `maxM`.
4. Update `res` with `maxL + currentM` and `maxM + currentL`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for prefix sum.

---

## Analysis / Phân tích

### Approach: Dynamic Partition Optimization
This problem reduces to finding the optimal split point or configuration for two fixed-length windows. By iterating through the array and maintaining the historical maximum sum for the "first" interval (either L or M), we can optimally combine it with the current "second" interval to find the peak total sum. We explicitly check both ordering possibilities (L then M, and M then L).
Bài toán này quy về việc tìm điểm phân chia hoặc cấu hình tối ưu cho hai cửa sổ có độ dài cố định. Bằng cách lặp qua mảng và duy trì tổng tối đa lịch sử cho khoảng "đầu tiên" (L hoặc M), chúng ta có thể kết hợp tối ưu nó với khoảng "thứ hai" hiện tại để tìm tổng đỉnh. Chúng ta kiểm tra rõ ràng cả hai khả năng sắp xếp (L rồi M, và M rồi L).

---
