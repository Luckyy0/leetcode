# Result for Ransom Note
# *Kết quả cho bài toán Bản tin Tống tiền*

## Description
## *Mô tả*

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.
*Cho hai chuỗi `ransomNote` và `magazine`, hãy trả về `true` nếu `ransomNote` có thể được tạo ra bằng cách sử dụng các chữ cái từ `magazine` và `false` nếu ngược lại.*

Each letter in `magazine` can only be used once in `ransomNote`.
*Mỗi chữ cái trong `magazine` chỉ có thể được sử dụng một lần trong `ransomNote`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `ransomNote = "a", magazine = "b"`
**Output:** `false`

## Example 2:
## *Ví dụ 2:*

**Input:** `ransomNote = "aa", magazine = "ab"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `ransomNote = "aa", magazine = "aab"`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `1 <= ransomNote.length, magazine.length <= 10^5`
*   `ransomNote` and `magazine` consist of lowercase English letters.
