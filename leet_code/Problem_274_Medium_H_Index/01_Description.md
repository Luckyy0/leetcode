# Result for H-Index
# *Kết quả cho bài toán Chỉ số H*

## Description
## *Mô tả*

Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their `i^th` paper, return *the researcher's h-index*.
*Cho một mảng các số nguyên `citations` trong đó `citations[i]` là số lượng trích dẫn mà một nhà nghiên cứu nhận được cho bài báo thứ `i` của họ, hãy trả về *chỉ số h của nhà nghiên cứu*.*

According to the [definition of h-index on Wikipedia](https://en.wikipedia.org/wiki/H-index): The h-index is defined as the maximum value of `h` such that the given researcher has published at least `h` papers that have each been cited at least `h` times.
*Theo [định nghĩa về chỉ số h trên Wikipedia](https://en.wikipedia.org/wiki/H-index): Chỉ số h được định nghĩa là giá trị `h` lớn nhất sao cho nhà nghiên cứu đã xuất bản ít nhất `h` bài báo, mỗi bài được trích dẫn ít nhất `h` lần.*

## Example 1:
## *Ví dụ 1:*

**Input:** `citations = [3,0,6,1,5]`
**Output:** `3`
**Explanation:** [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `citations = [1,3,1]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `n == citations.length`
*   `1 <= n <= 5000`
*   `0 <= citations[i] <= 1000`
