# Result for Length of Longest Fibonacci Subsequence
# *Kết quả cho bài toán Độ dài của Dãy con Fibonacci Dài nhất*

## Description
## *Mô tả*

A sequence `x1, x2, ..., xn` is **Fibonacci-like** if:
*Một dãy `x1, x2, ..., x n` được gọi là **giống Fibonacci** nếu:*

- `n >= 3`
- `xi + xi+1 = xi+2` for all `i + 2 <= n`

Given a strictly increasing array `arr` of positive integers forming a sequence, return *the **length** of the longest Fibonacci-like subsequence of `arr`*. If one does not exist, return `0`.
*Cho một mảng `arr` tăng dần nghiêm ngặt gồm các số nguyên dương tạo thành một dãy, hãy trả về *độ dài của dãy con giống Fibonacci dài nhất của `arr`*. Nếu không tồn tại, hãy trả về `0`.*

A **subsequence** is derived from another sequence `arr` by deleting any number of elements (including none) from `arr`, without changing the order of the remaining elements. For example, `[3, 5, 8]` is a subsequence of `[3, 4, 5, 6, 7, 8]`.
*Một dãy con (subsequence) được dẫn xuất từ một dãy `arr` khác bằng cách xóa bất kỳ số lượng phần tử nào (bao gồm cả không xóa) khỏi `arr`, mà không thay đổi thứ tự của các phần tử còn lại. Ví dụ: `[3, 5, 8]` là một dãy con của `[3, 4, 5, 6, 7, 8]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [1,2,3,4,5,6,7,8]
**Output:** 5
**Explanation:** The longest subsequence is [1,2,3,5,8].

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,3,7,11,12,14,18]
**Output:** 3
**Explanation:** The longest subsequence is [1,11,12], [3,11,14] or [7,11,18].

---

## Constraints:
## *Ràng buộc:*

*   `3 <= arr.length <= 1000`
*   `1 <= arr[i] < arr[i + 1] <= 10^9`
