# Result for Sequence Reconstruction
# *Kết quả cho bài toán Tái cấu trúc Dãy*

## Description
## *Mô tả*

You are given an integer array `nums` of length `n` where `nums` is a permutation of the integers in the range `[1, n]`. You are also given a 2D integer array `sequences` where `sequences[i]` is a subsequence of `nums`.
*Cho một mảng số nguyên `nums` có độ dài `n` trong đó `nums` là một hoán vị của các số nguyên trong khoảng `[1, n]`. Bạn cũng được cho một mảng số nguyên 2D `sequences` trong đó `sequences[i]` là một dãy con của `nums`.*

Check if `nums` is the **unique** shortest common supersequence of `sequences`.
*Hãy kiểm tra xem `nums` có phải là siêu dãy chung ngắn nhất **duy nhất** của các `sequences` hay không.*

A **common supersequence** is a sequence such that every `sequences[i]` is a subsequence of it.
*Một **siêu dãy chung** là một dãy mà mọi `sequences[i]` đều là dãy con của nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3], sequences = [[1,2],[1,3]]`
**Output:** `false`
**Explanation:** There are two possible common supersequences: [1,2,3] and [1,3,2].
The sequence [1,2,3] is a common supersequence, but it is not unique.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,3], sequences = [[1,2]]`
**Output:** `false`
**Explanation:** The shortest common supersequence is [1,2]. But [1,2,3] is given as nums.

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,2,3], sequences = [[1,2],[2,3]]`
**Output:** `true`
**Explanation:** The sequences [1,2] and [2,3] uniquely define the supersequence [1,2,3].

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 10^4`
*   `nums` is a permutation of `[1, n]`.
*   `1 <= sequences.length <= 10^4`
*   `1 <= sequences[i].length <= 10^4`
*   `1 <= sum(sequences[i].length) <= 10^5`
*   `1 <= sequences[i][j] <= n`
*   All the integers in `sequences[i]` are unique.
*   All the integers in `sequences` are in the range `[1, n]`.
