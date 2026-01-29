# 873. Length of Longest Fibonacci Subsequence / Độ dài của Dãy con Fibonacci Dài nhất

## Problem Description / Mô tả bài toán
Given a strictly increasing array `arr`, return the length of the longest Fibonacci-like subsequence.
Cho một mảng tăng nghiêm ngặt `arr`, hãy trả về độ dài của dãy con giống Fibonacci dài nhất.

A sequence is Fibonacci-like if `x_i + x_{i+1} = x_{i+2}` for all `i`.
Một dãy giống Fibonacci nếu `x_i + x_{i+1} = x_{i+2}` với mọi `i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with HashMap / Quy hoạch Động với HashMap
A Fibonacci sequence is defined by its last two terms `(A, B)`.
Một dãy Fibonacci được xác định bởi hai số hạng cuối cùng `(A, B)`.

Algorithm:
1. `dp[i][j]` = length of Fibonacci-like sequence ending with `arr[i]` and `arr[j]`.
2. For each `j` (second to last) and `k` (last):
   - Target first element: `i_val = arr[k] - arr[j]`.
   - If `i_val < arr[j]` and `i_val` exists in the array at index `i`:
     - `dp[j][k] = dp[i][j] + 1` (or `3` if it's the first triplet).

Use a `Map` of `Value -> Index` for fast lookup.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Two-Term State Mapping
Every pair of integers in the array can potentially be the tail of a Fibonacci chain. Using DP, we propagate the length of such chains by looking backward for the existence of the required third term.
Mỗi cặp số nguyên trong mảng đều có khả năng là phần đuôi của một chuỗi Fibonacci. Sử dụng DP, chúng ta lan truyền độ dài của các chuỗi đó bằng cách nhìn ngược lại sự tồn tại của số hạng thứ ba được yêu cầu.

---
