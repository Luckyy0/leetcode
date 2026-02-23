# Result for Longest Word in Dictionary through Deleting
# *Kết quả cho bài toán Từ dài nhất trong Từ điển thông qua Xóa*

## Description
## *Mô tả*

Given a string `s` and a string array `dictionary`, return *the longest string in the dictionary that can be formed by deleting some of the given string characters*. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
*Cho một chuỗi `s` và một mảng chuỗi `dictionary`, hãy trả về *chuỗi dài nhất trong từ điển có thể được tạo thành bằng cách xóa một số ký tự của chuỗi đã cho*. Nếu có nhiều hơn một kết quả khả thi, hãy trả về từ dài nhất có thứ tự từ điển nhỏ nhất. Nếu không có kết quả khả thi, hãy trả về chuỗi rỗng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]`
**Output:** `"apple"`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "abpcplea", dictionary = ["a","b","c"]`
**Output:** `"a"`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `1 <= dictionary.length <= 1000`
*   `1 <= dictionary[i].length <= 1000`
*   `s` and `dictionary[i]` consist of lowercase English letters.
