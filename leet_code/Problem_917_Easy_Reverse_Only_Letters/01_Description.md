# Result for Reverse Only Letters
# *Kết quả cho bài toán Đảo ngược Chỉ Các Chữ cái*

## Description
## *Mô tả*

Given a string `s`, reverse the string according to the following rules:
*Cho một chuỗi `s`, hãy đảo ngược chuỗi theo các quy tắc sau:*

*   All the characters that are not English letters remain in the same position.
    *   *Tất cả các ký tự không phải là chữ cái tiếng Anh vẫn ở vị trí cũ.*
*   All the English letters (lowercase or uppercase) should be reversed.
    *   *Tất cả các chữ cái tiếng Anh (chữ thường hoặc chữ hoa) nên được đảo ngược.*

Return `s` *after reversing it*.
*Hãy trả về `s` *sau khi đảo ngược nó*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "ab-cd"
**Output:** "dc-ba"

## Example 2:
## *Ví dụ 2:*

**Input:** s = "a-bC-dEf-ghIj"
**Output:** "j-Ih-gfE-dCba"

## Example 3:
## *Ví dụ 3:*

**Input:** s = "Test1ng-Leet=code-Q!"
**Output:** "Qedo1ct-eeLg=ntse-T!"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 100`
*   `s` consists of characters with ASCII values in the range `[33, 122]`.
*   `s` does not contain `'\"'` or `'\\'`.
