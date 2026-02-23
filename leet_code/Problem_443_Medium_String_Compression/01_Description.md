# Result for String Compression
# *Kết quả cho bài toán Nén Chuỗi*

## Description
## *Mô tả*

Given an array of characters `chars`, compress it using the following algorithm:
*Cho một mảng các ký tự `chars`, hãy nén nó bằng thuật toán sau:*

Begin with an empty string `s`. For each group of **consecutive repeating characters** in `chars`:
1. If the group's length is `1`, append the character to `s`.
2. Otherwise, append the character followed by the group's length.

The compressed string `s` **should not be returned separately**, but instead, be stored **in the input character array `chars`**. Note that group lengths that are `10` or longer will be split into multiple characters in `chars`.
*Chuỗi đã nén `s` **không được trả về riêng biệt**, mà thay vào đó, phải được lưu trữ **ngay trong mảng ký tự đầu vào `chars`**. Lưu ý rằng độ dài nhóm từ `10` trở lên sẽ được tách thành nhiều ký tự trong `chars`.*

After you are done **modifying the input array**, return *the new length of the array*.
*Sau khi bạn hoàn tất việc **sửa đổi mảng đầu vào**, hãy trả về *độ dài mới của mảng*.*

You must write an algorithm that uses only $O(1)$ extra space.

## Example 1:
## *Ví dụ 1:*

**Input:** `chars = ["a","a","b","b","c","c","c"]`
**Output:** Return `6`, and the first 6 characters of the input array should be: `["a","2","b","2","c","3"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `chars = ["a"]`
**Output:** Return `1`, and the first character of the input array should be: `["a"]`

## Example 3:
## *Ví dụ 3:*

**Input:** `chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]`
**Output:** Return `4`, and the first 4 characters of the input array should be: `["a","b","1","2"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= chars.length <= 2000`
*   `chars[i]` is a lowercase English letter, uppercase English letter, digit, or symbol.
