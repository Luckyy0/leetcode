# 673. Number of Longest Increasing Subsequence / Số lượng Dãy con Tăng Dài nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the number of longest increasing subsequences.
Cho một mảng số nguyên `nums`, hãy trả về số lượng các dãy con tăng dài nhất.

Notice that the sequence has to be **strictly** increasing.
Lưu ý rằng dãy phải tăng **nghiêm ngặt**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
We use two DP arrays:
- `lengths[i]`: Length of the longest increasing subsequence ending at index `i`.
- `counts[i]`: Number of longest increasing subsequences ending at index `i`.

For each `j < i`:
- If `nums[j] < nums[i]`:
  - If `lengths[j] + 1 > lengths[i]`: Update `lengths[i]` and set `counts[i] = counts[j]`.
  - If `lengths[j] + 1 == lengths[i]`: Add `counts[j]` to `counts[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) where N is the length of `nums`.
- **Space**: O(N) for DP arrays.

---

## Analysis / Phân tích

### Approach: DP with Length and Count
Iterate through the array and build the DP tables. Finally, sum the `counts[i]` for all `i` where `lengths[i]` is the global maximum length.
Lặp qua mảng và xây dựng các bảng DP. Cuối cùng, tính tổng `counts[i]` cho tất cả `i` mà `lengths[i]` là độ dài cực đại toàn cục.

---
