# Result for Delete Columns to Make Sorted II
# *Kết quả cho bài toán Xóa Cột để Thực hiện Sắp xếp II*

## Description
## *Mô tả*

You are given an array of `n` strings `strs`, all of the same length.
*Bạn được cho một mảng `n` chuỗi `strs`, tất cả đều có cùng độ dài.*

We may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
*Chúng ta có thể chọn bất kỳ bộ chỉ số xóa nào, và đối với mỗi chuỗi, chúng ta xóa tất cả các ký tự ở những chỉ số đó.*

For example, if we have an array `["abcdef","uvwxyz"]` and deletion indices `{0, 2, 3}`, then the final array after deletions is `["bef", "vyz"]`.
*Ví dụ, nếu chúng ta có một mảng `["abcdef","uvwxyz"]` và chỉ số xóa `{0, 2, 3}`, thì mảng cuối cùng sau khi xóa là `["bef", "vyz"]`.*

Suppose we chose a set of deletion indices `D` such that after deletions, the final array has its elements in **lexicographic** order (`strs[0] <= strs[1] <= strs[2] ... <= strs[n-1]`).
*Giả sử chúng ta chọn một tập hợp các chỉ số xóa `D` sao cho sau khi xóa, mảng cuối cùng có các phần tử theo thứ tự **từ điển** (`strs[0] <= strs[1] <= strs[2] ... <= strs[n-1]`).*

Return *the minimum possible value of* `D.length`.
*Trả về *giá trị nhỏ nhất có thể của* `D.length`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** strs = ["ca","bb","ac"]
**Output:** 1
**Explanation:** 
After deleting the first column, strs = ["a", "b", "c"].
Now strs is in lexicographic order (ie. strs[0] <= strs[1] <= strs[2]).
We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.

## Example 2:
## *Ví dụ 2:*

**Input:** strs = ["xc","yb","za"]
**Output:** 0
**Explanation:** 
strs is already in lexicographic order, so we do not need to delete anything.
Note that the rows of strs are not necessarily in lexicographic order:
i.e., it is NOT necessarily true that (strs[0][0] <= strs[0][1] <= ...)

## Example 3:
## *Ví dụ 3:*

**Input:** strs = ["zyx","wvu","tsr"]
**Output:** 3
**Explanation:** 
We have to delete every column.

---

## Constraints:
## *Ràng buộc:*

*   `n == strs.length`
*   `1 <= n <= 100`
*   `1 <= strs[i].length <= 100`
*   `strs[i]` consists of lowercase English letters.
