# 974. Subarray Sums Divisible by K / Tổng các Mảng con Chia hết cho K

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return the number of non-empty subarrays that have a sum divisible by `k`.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về số lượng các mảng con không rỗng có tổng chia hết cho `k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum and Modulo / Tổng tiền tố và Modulo
A subarray sum `sum(i...j)` is divisible by `k` if `prefixSum[j] % k == prefixSum[i-1] % k`.
Tổng mảng con `sum(i...j)` chia hết cho `k` nếu `prefixSum[j] % k == prefixSum[i-1] % k`.

Algorithm:
1. Maintain `currentSum`.
2. Count frequencies of `currentSum % k`.
   - Important: Handle negative sums by using `(sum % k + k) % k`.
3. If a remainder `R` has appeared `f` times, we found `f` new subarrays ending at current index.
4. Total += `f`.
5. Increment `f` for remainder `R`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Congruence Class counting
Categorize every prefix sum by its remainder when divided by $K$. By applying the Pigeonhole Principle concept, any two prefixes sharing the same remainder bound a subarray whose total sum is a multiple of $K$.
Phân loại mọi tổng tiền tố theo số dư của nó khi chia cho $K$. Bằng cách áp dụng khái niệm Nguyên lý chuồng bồ câu, bất kỳ hai tiền tố nào có chung số dư sẽ đóng khung một mảng con mà tổng của nó là một bội số của $K$.

---
