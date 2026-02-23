# Result for Letter Combinations of a Phone Number
# *Kết quả cho bài toán Tổ Hợp Chữ Cái của Số Điện Thoại*

## Description
## *Mô tả*

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.
*Cho một chuỗi chứa các chữ số từ `2-9`, hãy trả về tất cả các tổ hợp chữ cái có thể mà số đó có thể đại diện. Trả về câu trả lời theo **bất kỳ thứ tự nào**.*

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*Ánh xạ từ chữ số sang chữ cái (giống như trên các nút điện thoại) được đưa ra dưới đây. Lưu ý rằng 1 không ánh xạ tới bất kỳ chữ cái nào.*

*   2: "abc"
*   3: "def"
*   4: "ghi"
*   5: "jkl"
*   6: "mno"
*   7: "pqrs"
*   8: "tuv"
*   9: "wxyz"

## Example 1:
## *Ví dụ 1:*

**Input:** `digits = "23"`
**Output:** `["ad","ae","af","bd","be","bf","cd","ce","cf"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `digits = ""`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `digits = "2"`
**Output:** `["a","b","c"]`

## Constraints:
## *Ràng buộc:*

*   `0 <= digits.length <= 4`
*   `digits[i]` is a digit in the range `['2', '9']`.
