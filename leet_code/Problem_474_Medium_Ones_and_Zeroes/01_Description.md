# Result for Ones and Zeroes
# *Kết quả cho bài toán Số Một và Số Không*

## Description
## *Mô tả*

You are given an array of binary strings `strs` and two integers `m` and `n`.
*Bạn được cho một mảng các chuỗi nhị phân `strs` và hai số nguyên `m` và `n`.*

Return *the size of the largest subset of `strs` such that there are **at most** `m` `0`'s and `n` `1`'s in the subset*.
*Hãy trả về *kích thước của tập con lớn nhất của `strs` sao cho có **tối đa** `m` số `0` và `n` số `1` trong tập con đó*.*

A set `x` is a **subset** of a set `y` if all elements of `x` are also elements of `y`.
*Một tập hợp `x` là **tập con** của một tập hợp `y` nếu tất cả các phần tử của `x` cũng là phần tử của `y`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `strs = ["10","0001","111001","1","0"], m = 5, n = 3`
**Output:** `4`
**Explanation:** The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `strs = ["10","0","1"], m = 1, n = 1`
**Output:** `2`
**Explanation:** The largest subset is {"0", "1"}, so the answer is 2.

## Constraints:
## *Ràng buộc:*

*   `1 <= strs.length <= 600`
*   `1 <= strs[i].length <= 100`
*   `strs[i]` consists only of digits `'0'` and `'1'`.
*   `1 <= m, n <= 100`
