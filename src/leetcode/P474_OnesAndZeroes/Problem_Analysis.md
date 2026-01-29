# 474. Ones and Zeroes / Số Không và Số Một

## Problem Description / Mô tả bài toán
You are given an array of binary strings `strs` and two integers `m` and `n`.
Cho một mảng các chuỗi nhị phân `strs` và hai số nguyên `m`, `n`.

Return the size of the largest subset of `strs` such that there are **at most** `m` `0`'s and `n` `1`'s in the subset.
Hãy trả về kích thước của tập con lớn nhất từ `strs` sao cho có **tối đa** `m` số `0` và `n` số `1` trong tập con đó.

A set `x` is a **subset** of a set `y` if all elements of `x` are also elements of `y`.
Một tập hợp `x` là **tập con** của tập hợp `y` nếu tất cả các phần tử của `x` cũng là phần tử của `y`.

### Example 1:
```text
Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid subsets are {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is invalid because it has 4 '1's, which is greater than n = 3.
```

### Example 2:
```text
Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
```

## Constraints / Ràng buộc
- `1 <= strs.length <= 600`
- `1 <= strs[i].length <= 100`
- `1 <= m, n <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### 0/1 Knapsack (2D capacity) / Bài toán Cái túi 0/1 (Công suất 2 chiều)
This is a classic variation of the 0/1 knapsack problem where we have two capacity constraints: `m` (zeros) and `n` (ones).

Algorithm:
1. Define `dp[i][j]` as the maximum number of strings we can pick using exactly `i` zeros and `j` ones.
2. Initialize `dp` with size `(m + 1) x (n + 1)` filled with 0.
3. For each string `s` in `strs`:
   - Count the number of zeros (`z`) and ones (`o`) in `s`.
   - Update the `dp` table from **right to left** (to avoid using the same string multiple times, typical of 0/1 knapsack):
     - For `i` from `m` down to `z`:
       - For `j` from `n` down to `o`:
         - `dp[i][j] = max(dp[i][j], 1 + dp[i-z][j-o])`.
4. Return `dp[m][n]`.

### Complexity / Độ phức tạp
- **Time**: O(L * m * n) where L is the number of strings.
- **Space**: O(m * n) using the space-optimized 1D (2D in this case) array approach.

---

## Analysis / Phân tích

### Approach: 2-Dimensional DP Table

**Algorithm**:
1.  Iterate through each word.
2.  Count character types.
3.  Reverse update the DP grid to ensure unique selection.

---
