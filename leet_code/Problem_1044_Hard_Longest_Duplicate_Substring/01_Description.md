# Longest Duplicate Substring
# *Chuỗi Con Lặp Lại Dài Nhất*

## Description
## *Mô tả*

Given a string `s`, consider all *duplicated substrings*: (contiguous) substrings of `s` that occur 2 or more times. The occurrences may overlap.
*Cho một chuỗi ký tự `s`, hãy xem xét tất cả các *chuỗi con bị lặp lại*: đó là các chuỗi con (nằm liên tiếp) của `s` xuất hiện từ 2 lần trở lên. Các lần xuất hiện này hoàn toàn có thể nằm đè chéo (overlap) đan xen lên nhau.*

Return **any** duplicated substring that has the longest possible length. If `s` does not have a duplicated substring, the answer is `""`.
*Nhiệm vụ của bạn là trả về **bất kỳ** một chuỗi con lặp lại nào sở hữu chiều dài tối đa lớn nhất có thể. Nếu chuỗi `s` không có lấy một chuỗi con lặp lại nào, kết quả trả về là chuỗi rỗng `""`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "banana"
**Output:** "ana"
**Explanation:** 
*Giải thích:*
The duplicated substrings are "a", "n", "an", "na", and "ana".
*Các chuỗi con bị lặp lại trong từ "banana" bao gồm "a", "n", "an", "na", và "ana".*
The longest one is "ana", which appears twice (starting at index 1 and index 3).
*Chuỗi lặp lại dài nhất vô địch là "ana", nó xuất hiện hai lần (điểm bắt đầu tại vị trí index 1 và index 3).*

## Example 2:
## *Ví dụ 2:*

**Input:** s = "abcd"
**Output:** ""
**Explanation:** 
*Giải thích:*
There are no duplicated substrings in "abcd". All characters are unique.
*Không hề có bất cứ một chuỗi con lặp lại nào trong "abcd". Tất cả các ký tự đều đứng độc nhất và không đụng hàng.*

---

## Constraints:
## *Ràng buộc:*

*   `2 <= s.length <= 3 * 10^4`
*   `s` consists of lowercase English letters.
*   *Chuỗi `s` chỉ bao gồm các chữ cái in thường tiếng Anh.*
