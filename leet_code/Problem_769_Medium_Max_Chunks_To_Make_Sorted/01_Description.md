# Result for Max Chunks To Make Sorted
# *Kết quả cho bài toán Số Khối Tối đa để Sắp xếp*

## Description
## *Mô tả*

You are given an integer array `arr` of length `n` that represents a permutation of the integers in the range `[0, n - 1]`.
*Bạn được cho một mảng số nguyên `arr` có độ dài `n` đại diện cho một hoán vị của các số nguyên trong khoảng `[0, n - 1]`.*

We split `arr` into some number of **chunks** (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted version of `arr`.
*Chúng ta chia `arr` thành một số lượng **khối** (tức là phân vùng), và sắp xếp riêng lẻ từng khối. Sau khi nối chúng lại, kết quả phải bằng phiên bản đã sắp xếp của `arr`.*

Return *the largest number of chunks we can make to sort the array*.
*Trả về *số lượng khối lớn nhất chúng ta có thể tạo ra để sắp xếp mảng*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [4,3,2,1,0]
**Output:** 1
**Explanation:**
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,0,2,3,4]
**Output:** 4
**Explanation:**
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

---

## Constraints:
## *Ràng buộc:*

*   `n == arr.length`
*   `1 <= n <= 10`
*   `0 <= arr[i] < n`
*   All the elements of `arr` are unique.
