# Result for Bulls and Cows
# *Kết quả cho bài toán Bò và Cựu*

## Description
## *Mô tả*

You are playing the **[Bulls and Cows](https://en.wikipedia.org/wiki/Bulls_and_Cows)** game with your friend.
*Bạn đang chơi trò chơi **[Bò và Cựu](https://en.wikipedia.org/wiki/Bulls_and_Cows)** với bạn của mình.*

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
*   The number of "bulls", which are digits in the guess that are in the correct position.
*   The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
*Bạn viết ra một con số bí mật và yêu cầu bạn của mình đoán xem con số đó là gì. Khi bạn của bạn đưa ra một dự đoán, bạn cung cấp một gợi ý với thông tin sau:*
*   *Số lượng "bò", là các chữ số trong dự đoán nằm đúng vị trí.*
*   *Số lượng "cựu", là các chữ số trong dự đoán nằm trong số bí mật của bạn nhưng nằm sai vị trí. Cụ thể, đó là các chữ số không phải bò trong dự đoán có thể được sắp xếp lại sao cho chúng trở thành bò.*

Given the secret number `secret` and your friend's guess `guess`, return *the hint for your friend's guess*.
*Cho số bí mật `secret` và dự đoán của bạn của bạn `guess`, hãy trả về *gợi ý cho dự đoán của bạn của bạn*.*

The hint should be formatted as `"xAyB"`, where `x` is the number of bulls and `y` is the number of cows. Note that both `secret` and `guess` may contain duplicate digits.
*Gợi ý nên được định dạng là `"xAyB"`, trong đó `x` là số lượng bò và `y` là số lượng cựu. Lưu ý rằng cả `secret` và `guess` đều có thể chứa các chữ số trùng lặp.*

## Example 1:
## *Ví dụ 1:*

**Input:** `secret = "1807", guess = "7810"`
**Output:** `"1A3B"`
**Explanation:** Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

## Example 2:
## *Ví dụ 2:*

**Input:** `secret = "1123", guess = "0111"`
**Output:** `"1A1B"`
**Explanation:** Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.

## Constraints:
## *Ràng buộc:*

*   `1 <= secret.length, guess.length <= 1000`
*   `secret.length == guess.length`
*   `secret` and `guess` consist of digits only.
