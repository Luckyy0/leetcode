# Result for Delete Columns to Make Sorted III
# *Kết quả cho bài toán Xóa Cột để Thực hiện Sắp xếp III*

## Description
## *Mô tả*

You are given an array of `n` strings `strs`, all of the same length.
*Bạn được cho một mảng `n` chuỗi `strs`, tất cả đều có cùng độ dài.*

We may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
*Chúng ta có thể chọn bất kỳ bộ chỉ số xóa nào, và đối với mỗi chuỗi, chúng ta xóa tất cả các ký tự ở những chỉ số đó.*

For example, if we have an array `["abcdef","uvwxyz"]` and deletion indices `{0, 2, 3}`, then the final array after deletions is `["bef", "vyz"]`.
*Ví dụ, nếu chúng ta có một mảng `["abcdef","uvwxyz"]` và chỉ số xóa `{0, 2, 3}`, thì mảng cuối cùng sau khi xóa là `["bef", "vyz"]`.*

Suppose we chose a set of deletion indices `D` such that after deletions, *each remaining column in `strs` is sorted*.
*Giả sử chúng ta chọn một tập hợp các chỉ số xóa `D` sao cho sau khi xóa, *mỗi cột còn lại trong `strs` đều được sắp xếp*.* Note this is not what the problem asks.
Wait, let me re-read the problem carefully.
Ah, the problem is actually:
"Suppose we chose a set of deletion indices `D` such that after deletions, the final array has **every element in every row** in lexicographic order." - NO.

Let's check the actual problem statement for 960.
"You are given an array of `n` strings `strs`, all of the same length. We may choose any set of deletion indices, and for each string, we delete all the characters in those indices. ... Suppose we chose a set of deletion indices `D` such that after deletions, **every string in the array is in lexicographic order**."
*Bạn được cho một mảng `n` chuỗi `strs`, tất cả đều cùng độ dài. Chúng ta có thể chọn bất kỳ bộ chỉ số xóa nào... Giả sử chúng ta chọn bộ chỉ số xóa `D` sao cho sau khi xóa, **mỗi chuỗi trong mảng đều có thứ tự từ điển tăng dần**.*

Return *the minimum possible value of* `D.length`.
*Trả về *giá trị nhỏ nhất có thể của* `D.length`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** strs = ["babca","bbazb"]
**Output:** 3
**Explanation:** After deleting columns 0, 1, and 4, the final array is strs = ["bc", "az"].
Both these strings are sorted. ["b", "a", "b", "c", "a"] becomes ["b", "c"] (sorted). ["b", "b", "a", "z", "b"] becomes ["a", "z"] (sorted).
Wait, "bc" sorted means 'b' <= 'c'. "az" sorted means 'a' <= 'z'.

## Example 2:
## *Ví dụ 2:*

**Input:** strs = ["edcba"]
**Output:** 4
**Explanation:** If we delete less than 4 columns, the only string "edcba" will not be sorted.

## Example 3:
## *Ví dụ 3:*

**Input:** strs = ["ghi","def","abc"]
**Output:** 0
**Explanation:** All strings are already sorted.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= strs.length <= 100`
*   `1 <= strs[i].length <= 100`
*   `strs[i]` consists of lowercase English letters.
