# Result for H-Index II
# *Kết quả cho bài toán H-Index II*

## Description
## *Mô tả*

Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their `i^th` paper and `citations` is sorted in **ascending order**, return *the researcher's h-index*.
*Cho một mảng các số nguyên `citations` trong đó `citations[i]` là số lượng trích dẫn mà một nhà nghiên cứu nhận được cho bài báo thứ `i` của họ và `citations` được sắp xếp theo **thứ tự tăng dần**, hãy trả về *chỉ số h của nhà nghiên cứu*.*

You must write an algorithm that runs in logarithmic time.
*Bạn phải viết một thuật toán chạy trong thời gian logarit.*

## Example 1:
## *Ví dụ 1:*

**Input:** `citations = [0,1,3,5,6]`
**Output:** `3`
**Explanation:** [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `citations = [1,2,100]`
**Output:** `2`

## Constraints:
## *Ràng buộc:*

*   `n == citations.length`
*   `1 <= n <= 10^5`
*   `0 <= citations[i] <= 1000`
*   `citations` is sorted in **ascending order**.
