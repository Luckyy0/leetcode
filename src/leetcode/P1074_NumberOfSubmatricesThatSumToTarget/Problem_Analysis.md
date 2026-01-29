# 1074. Number of Submatrices That Sum to Target / Số lượng Ma trận con có Tổng bằng Target

## Problem Description / Mô tả bài toán
Given a `matrix` and a `target`, return the number of non-empty submatrices that sum to `target`.
Cho một `matrix` và một `target`, hãy trả về số lượng ma trận con không rỗng có tổng bằng `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### 2D Prefix Sum + 1D Subarray Sum (Hash Map) / Tổng Tiền tố 2D + Tổng Mảng con 1D (Bản đồ Băm)
Reduce 2D problem to 1D problem.
Fix two rows `r1` and `r2`.
Calculate column sums for this band `r1...r2`.
`colSum[c] = prefixSum[r2][c] - prefixSum[r1-1][c]`. (Or precompute column accumulated sums).
Now we have a 1D array `colSums`. We want to find subarrays of `colSums` that sum to `target`.
This is exactly "Subarray Sum Equals K" (P560).
Use HashMap to store prefix sums of the 1D array.

Algorithm:
1. Calculate 2D prefix sums or accumulate rows.
   Let's just accumulate rows. `matrix[i][j] += matrix[i][j-1]` (Row prefix sum).
2. Loop `c1` from 0 to `cols`.
3. Loop `c2` from `c1` to `cols`.
   - Now we have a vertical strip width `c2-c1+1`.
   - Iterate rows `r` from 0 to `rows`.
   - Compute sum of row `r` between `c1` and `c2`: `rowSum = matrix[r][c2] - matrix[r][c1-1]`.
   - Now we have a 1D stream of row sums. Find subarray sum equals target.
   - Use `Map<Integer, Integer>`. `currSum += rowSum`. `res += map.get(currSum - target)`.

Correction:
Usually better to fix two rows `r1, r2` and iterating columns is O(R^2 C). Or fix columns and iterate rows O(C^2 R). If R, C <= 100, either is fine. Since usually R=C=300? 100?
Constraints: m, n <= 100.
O(N^3) is acceptable. $100^3 = 10^6$.

### Complexity / Độ phức tạp
- **Time**: O(R * R * C) or O(C * C * R). Let's assume R=C=N, so O(N^3).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: 2D Dimensional Reduction
Reduce the 2D submatrix sum problem to the 1D "Subarray Sum Equals K" problem. Fix two row boundaries (top and bottom), which flattens the matrix into a single 1D array representing column sums within those rows. Then, use the standard HashMap prefix-sum technique to count valid column ranges. Iterate through all possible row pairs to cover every submatrix.
Giảm bài toán tổng ma trận con 2D thành bài toán "Tổng mảng con bằng K" 1D. Cố định hai ranh giới hàng (trên và dưới), làm phẳng ma trận thành một mảng 1D duy nhất đại diện cho tổng cột trong các hàng đó. Sau đó, sử dụng kỹ thuật tổng tiền tố HashMap tiêu chuẩn để đếm các phạm vi cột hợp lệ. Lặp qua tất cả các cặp hàng có thể để bao phủ mọi ma trận con.

---
