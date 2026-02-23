# Result for Triples with Bitwise AND Equal To Zero
# *Kết quả cho bài toán Bộ ba có AND Bitwise Bằng Không*

## Description
## *Mô tả*

Given an integer array `nums`, return *the number of AND triples*.
*Cho một mảng số nguyên `nums`, trả về *số lượng bộ ba AND*.*

An **AND triple** is a triple of indices `(i, j, k)` such that:
*Một **bộ ba AND** là một bộ ba các chỉ số `(i, j, k)` sao cho:*

*   `0 <= i < nums.length`
*   `0 <= j < nums.length`
*   `0 <= k < nums.length`
*   `nums[i] & nums[j] & nums[k] == 0`, where `&` represents the bitwise-AND operator.
    *   *`nums[i] & nums[j] & nums[k] == 0`, trong đó `&` biểu diễn toán tử bitwise-AND.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [2,1,3]
**Output:** 12
**Explanation:** We could choose the following i, j, k triples:
(i=0, j=0, k=1) : 2 & 2 & 1 = 0
(i=0, j=1, k=0) : 2 & 1 & 2 = 0
(i=0, j=1, k=1) : 2 & 1 & 1 = 0
(i=0, j=1, k=2) : 2 & 1 & 3 = 0
(i=0, j=2, k=1) : 2 & 3 & 1 = 0
(i=1, j=0, k=0) : 1 & 2 & 2 = 0
(i=1, j=0, k=1) : 1 & 2 & 1 = 0
(i=1, j=0, k=2) : 1 & 2 & 3 = 0
(i=1, j=1, k=0) : 1 & 1 & 2 = 0
(i=1, j=2, k=0) : 1 & 3 & 2 = 0
(i=2, j=0, k=1) : 3 & 2 & 1 = 0
(i=2, j=1, k=0) : 3 & 1 & 2 = 0

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [0,0,0]
**Output:** 27

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `0 <= nums[i] < 2^16`
