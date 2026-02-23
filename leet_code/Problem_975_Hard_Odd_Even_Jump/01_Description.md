# Result for Odd Even Jump
# *Kết quả cho bài toán Nhảy Chẵn Lẻ*

## Description
## *Mô tả*

You are given an integer array `arr`. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps in the series are called **odd-numbered jumps**, and the (2nd, 4th, 6th, ...) jumps in the series are called **even-numbered jumps**. Note that the **jumps** are numbered, not the indices.
*Bạn được cho một mảng số nguyên `arr`. Từ một chỉ số bắt đầu nào đó, bạn có thể thực hiện một loạt các bước nhảy. Các bước nhảy (thứ 1, thứ 3, thứ 5, ...) trong chuỗi được gọi là **bước nhảy lẻ**, và các bước nhảy (thứ 2, thứ 4, thứ 6, ...) trong chuỗi được gọi là **bước nhảy chẵn**. Lưu ý rằng **các bước nhảy** được đánh số, không phải các chỉ số.*

You may jump forward from index `i` to index `j` (with `i < j`) in the following way:
*Bạn có thể nhảy về phía trước từ chỉ số `i` đến chỉ số `j` (với `i < j`) theo cách sau:*

*   During **odd-numbered jumps** (i.e., jumps 1, 3, 5, ...), you jump to the index `j` such that `arr[i] <= arr[j]` and `arr[j]` is the smallest possible value. If there are multiple such indices `j`, you can only jump to the **smallest** such index `j`.
    *   *Trong các **bước nhảy lẻ** (tức là bước nhảy 1, 3, 5, ...), bạn nhảy đến chỉ số `j` sao cho `arr[i] <= arr[j]` và `arr[j]` là giá trị nhỏ nhất có thể. Nếu có nhiều chỉ số `j` như vậy, bạn chỉ có thể nhảy đến chỉ số `j` **nhỏ nhất**.*
*   During **even-numbered jumps** (i.e., jumps 2, 4, 6, ...), you jump to the index `j` such that `arr[i] >= arr[j]` and `arr[j]` is the largest possible value. If there are multiple such indices `j`, you can only jump to the **smallest** such index `j`.
    *   *Trong các **bước nhảy chẵn** (tức là bước nhảy 2, 4, 6, ...), bạn nhảy đến chỉ số `j` sao cho `arr[i] >= arr[j]` và `arr[j]` là giá trị lớn nhất có thể. Nếu có nhiều chỉ số `j` như vậy, bạn chỉ có thể nhảy đến chỉ số `j` **nhỏ nhất**.*
*   (It may be the case that for some index `i`, there are no legal jumps.)
    *   *(Có thể xảy ra trường hợp đối với một số chỉ số `i`, không có bước nhảy hợp lệ nào.)*

A starting index is **good** if, starting from that index, you can reach the end of the array (index `arr.length - 1`) by jumping some number of times (possibly 0 or more than once).
*Một chỉ số bắt đầu là **tốt** nếu, bắt đầu từ đó, bạn có thể đến được cuối mảng (chỉ số `arr.length - 1`) bằng cách nhảy một số lần (có thể là 0 hoặc nhiều lần).*

Return *the number of **good** starting indices*.
*Trả về *số lượng chỉ số bắt đầu **tốt***.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [10,13,12,14,15]
**Output:** 2
**Explanation:** 
From starting index i = 0, we can make our 1st jump to i = 2 (since arr[2] is the smallest among arr[1], arr[2], arr[3], arr[4] that is greater or equal to arr[0]), then we cannot jump any more.
From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
From starting index i = 4, we have reached the end already.
In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of jumps.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [2,3,1,1,4]
**Output:** 3

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [5,1,3,4,2]
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 2 * 10^4`
*   `0 <= arr[i] <= 10^5`
