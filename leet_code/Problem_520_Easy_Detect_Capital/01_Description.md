# Result for Detect Capital
# *Kết quả cho bài toán Phát hiện Chữ hoa*

## Description
## *Mô tả*

We define the usage of capitals in a word to be right when one of the following cases holds:
*Chúng tôi định nghĩa việc sử dụng chữ hoa trong một từ là đúng khi một trong các trường hợp sau xảy ra:*

*   All letters in this word are capitals, like `"USA"`.
    *Tất cả các chữ cái trong từ này đều là chữ hoa, như `"USA"`.*
*   All letters in this word are not capitals, like `"leetcode"`.
    *Tất cả các chữ cái trong từ này không phải là chữ hoa, như `"leetcode"`.*
*   Only the first letter in this word is capital, like `"Google"`.
    *Chỉ chữ cái đầu tiên trong từ này là chữ hoa, như `"Google"`.*

Given a string `word`, return `true` if the usage of capitals in it is right.
*Cho một chuỗi `word`, hãy trả về `true` nếu việc sử dụng chữ hoa trong đó là đúng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `word = "USA"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `word = "FlaG"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= word.length <= 100`
*   `word` consists of lowercase and uppercase English letters.
