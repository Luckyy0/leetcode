# Result for Guess the Word
# *Kết quả cho bài toán Đoán Từ*

## Description
## *Mô tả*

You are given an array of unique strings `words` where `words[i]` is 6 letters long, and one word in this array is chosen as `secret`.
*Bạn được cho một mảng các chuỗi duy nhất `words` trong đó mỗi chữ có độ dài 6, và một trong số đó được chọn làm từ bí mật `secret`.*

You are also given an object `Master` that has a function `guess(word)` which returns an integer:
*Bạn cũng được cho một đối tượng `Master` có hàm `guess(word)` trả về một số nguyên:*

- If `word` is not in the original word list, it returns `-1`.
*Nếu `word` không nằm trong danh sách từ, nó trả về `-1`.*
- If it is in the list, it returns the number of **exact matches** (both character and position) between your guess and the `secret` word.
*Nếu nó có trong danh sách, nó trả về số lượng **ký tự khớp hoàn toàn** (về cả ký tự và vị trí) giữa từ bạn đoán và từ bí mật.*

Your goal is to find the secret word within **10 guesses**. You will be penalized if you make more than 10 guesses or if you guess a word that is not in `words`.
*Mục tiêu của bạn là tìm ra từ bí mật trong vòng **10 lượt đoán**. Bạn sẽ bị phạt nếu đoán quá 10 lần hoặc đoán một từ không có trong `words`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** secret = "acckzz", words = ["acckzz","ccbazz","eiowzz","abcczz"]
**Output:** "You guessed the secret word!"
**Explanation:** 
master.guess("acckzz") returns 6, because "acckzz" is the secret word.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches with "acckzz".
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches with "acckzz".
master.guess("abcczz") returns 4, because "abcczz" has 4 matches with "acckzz".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 100`
*   `words[i].length == 6`
*   `words[i]` consist of lowercase English letters.
*   All strings in `words` are **unique**.
*   `secret` exists in `words`.
*   Number of calls to `master.guess` is limited to 10.
