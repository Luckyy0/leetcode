# Result for Palindrome Partitioning II
# *Kết quả cho bài toán Phân Tách Chuỗi Đối Xứng II*

## Description
## *Mô tả*

Given a string `s`, partition `s` such that every substring of the partition is a **palindrome**.
*Cho một chuỗi `s`, hãy phân tách `s` sao cho mỗi chuỗi con của phép phân tách đều là một **chuỗi đối xứng**.*

Return *the **minimum** cuts needed for a palindrome partitioning of `s`*.
*Hãy trả về *số lần cắt **tổng tối thiểu** cần thiết để phân tách chuỗi đối xứng của `s`**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "aab"`
**Output:** `1`
**Explanation:** The palindrome partitioning ["aa","b"] could be produced using 1 cut.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "a"`
**Output:** `0`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "ab"`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 2000`
*   `s` contains only lowercase English letters.
