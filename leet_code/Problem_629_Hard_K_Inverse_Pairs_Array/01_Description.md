# Result for K Inverse Pairs Array
# *Kết quả cho bài toán Mảng có K Cặp Nghịch thế*

## Description
## *Mô tả*

For an integer array `nums`, an **inverse pair** is a pair of integers `(i, j)` where `0 <= i < j < nums.length` and `nums[i] > nums[j]`.
*Đối với một mảng số nguyên `nums`, một **cặp nghịch thế** là một cặp số nguyên `(i, j)` sao cho `0 <= i < j < nums.length` và `nums[i] > nums[j]`.*

Given two integers `n` and `k`, return the number of different arrays consisting of numbers from `1` to `n` such that there are exactly `k` **inverse pairs**. Since the answer can be huge, return it **modulo** `10^9 + 7`.
*Cho hai số nguyên `n` và `k`, hãy trả về số lượng các mảng khác nhau bao gồm các số từ `1` đến `n` sao cho có chính xác `k` **cặp nghịch thế**. Vì câu trả lời có thể rất lớn, hãy trả về kết quả theo **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, k = 0
**Output:** 1
**Explanation:** Only the array [1,2,3] which is in ascending order has 0 inverse pairs.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3, k = 1
**Output:** 2
**Explanation:** The arrays [1,3,2] and [2,1,3] have exactly 1 inverse pair.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`
*   `0 <= k <= 1000`
