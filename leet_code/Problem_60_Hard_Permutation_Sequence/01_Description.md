# Result for Permutation Sequence
# *Kết quả cho bài toán Chuỗi Hoán Vị*

## Description
## *Mô tả*

The set `[1, 2, 3, ..., n]` contains a total of `n!` unique permutations. By listing and labeling all of the permutations in order, we get the following sequence for `n = 3`:
*Tập hợp `[1, 2, 3, ..., n]` chứa tổng cộng `n!` hoán vị duy nhất. Bằng cách liệt kê và gắn nhãn tất cả các hoán vị theo thứ tự, chúng ta nhận được chuỗi sau cho `n = 3`:*

1.  `"123"`
2.  `"132"`
3.  `"213"`
4.  `"231"`
5.  `"312"`
6.  `"321"`

Given `n` and `k`, return the `kth` permutation sequence.
*Cho `n` và `k`, hãy trả về chuỗi hoán vị thứ `k`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 3`, `k = 3`
**Output:** `"213"`

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 4`, `k = 9`
**Output:** `"2314"`

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 3`, `k = 1`
**Output:** `"123"`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 9`
*   `1 <= k <= n!`
