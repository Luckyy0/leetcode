# Result for Group Shifted Strings
# *Kết quả cho bài toán Nhóm các chuỗi dịch chuyển*

## Description
## *Mô tả*

We can shift a string by shifting each of its letters to its successive letter.
*Chúng ta có thể dịch chuyển một chuỗi bằng cách dịch chuyển từng chữ cái của nó sang chữ cái kế tiếp.*

*   For example, `"abc"` can be shifted to be `"bcd"`.

We can keep shifting the string to form a sequence.
*Chúng ta có thể tiếp tục dịch chuyển chuỗi để tạo thành một chuỗi tuần tự.*

*   For example, we can keep shifting `"abc"` to form the sequence: `"abc" -> "bcd" -> ... -> "xyz"`.

Given an array of strings `strings`, group all `strings[i]` that belong to the same shifting sequence. You may return the answer in **any order**.
*Cho một mảng các chuỗi `strings`, hãy nhóm tất cả các `strings[i]` thuộc cùng một chuỗi dịch chuyển. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `strings = ["abc","bcd","acef","xyz","az","ba","a","z"]`
**Output:** `[["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `strings = ["a"]`
**Output:** `[["a"]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= strings.length <= 200`
*   `1 <= strings[i].length <= 50`
*   `strings[i]` consists of lowercase English letters.
