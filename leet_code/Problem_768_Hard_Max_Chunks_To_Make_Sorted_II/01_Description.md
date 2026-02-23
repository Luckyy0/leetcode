# Result for Max Chunks To Make Sorted II
# *Kết quả cho bài toán Số Khối Tối đa để Sắp xếp II*

## Description
## *Mô tả*

You are given an integer array `arr`.
*Bạn được cho một mảng số nguyên `arr`.*

We split `arr` into some number of **chunks** (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted version of `arr`.
*Chúng ta chia `arr` thành một số lượng **khối** (tức là phân vùng), và sắp xếp riêng lẻ từng khối. Sau khi nối chúng lại, kết quả phải bằng phiên bản đã sắp xếp của `arr`.*

Return *the largest number of chunks we can make to sort the array*.
*Trả về *số lượng khối lớn nhất chúng ta có thể tạo ra để sắp xếp mảng*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [5,4,3,2,1]
**Output:** 1
**Explanation:**
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1].
Sorting each chunk results in [4, 5], [1, 2, 3].
Concatenating results in [4, 5, 1, 2, 3], which is not sorted.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [2,1,3,4,4]
**Output:** 4
**Explanation:**
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 2000`
*   `0 <= arr[i] <= 10^8`
