# 363. Max Sum of Rectangle No Larger Than K / Tổng Lớn Nhất Của Hình Chữ Nhật Không Lớn Hơn K

## Problem Description / Mô tả bài toán
Given an `m x n` matrix `matrix` and an integer `k`, return the max sum of a rectangle in the matrix such that its sum is no larger than `k`.
Cho một ma trận `m x n` `matrix` và một số nguyên `k`, trả về tổng lớn nhất của một hình chữ nhật trong ma trận sao cho tổng của nó không lớn hơn `k`.

It is guaranteed that there will be a rectangle with a sum no larger than `k`.

### Example 1:
```text
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
```

### Example 2:
```text
Input: matrix = [[2,2,-1]], k = 3
Output: 3
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 100`
- `-100 <= matrix[i][j] <= 100`
- `-10^5 <= k <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### 2D Prefix Sum + 1D Subarray Sum / Tổng Tiền Tố 2D + Tổng Mảng Con 1D
Fix left column `L` and right column `R`.
Compress 2D array between `L` and `R` into a 1D array `rowSums`.
`rowSums[i]` = sum of `matrix[i][L...R]`.
Now Find max subarray sum in `rowSums` no larger than `k`.
Let `current_sum` be prefix sum of `rowSums`. We want `curr - prev <= k` => `prev >= curr - k`.
We want smallest `prev` such that `prev >= curr - k` to maximize `curr - prev`.
Use `TreeSet` to store prefix sums. `ceiling(curr - k)` gives the smallest valid `prev`.

### Complexity / Độ phức tạp
- **Time**: `O(N^2 * M log M)` (if N is smaller dim). Or `O(min(M,N)^2 * max(M,N) log max(M,N))`.
- **Space**: O(M) or O(N).

---

## Analysis / Phân tích

### Approach: Compressed 2D to 1D with TreeSet

**Algorithm**:
1.  Assume M rows, N cols. Better to iterate over smaller dimension as outer loops (pair of cols or pair of rows). Let's assume M > N, iterate cols pairs `L, R`.
2.  `rowSums` array size M.
3.  Inside inner loop (R):
    - Update `rowSums[i] += matrix[i][R]`.
    - Handle 1D problem: Max subarray sum <= k.
    - `TreeSet` add 0. `currSum = 0`.
    - Loop `s` in `rowSums`:
        - `currSum += s`.
        - `target = currSum - k`.
        - `ceil = set.ceiling(target)`.
        - if `ceil != null`: `ans = max(ans, currSum - ceil)`.
        - `set.add(currSum)`.

---
