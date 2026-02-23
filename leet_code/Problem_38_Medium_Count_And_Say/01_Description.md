# Result for Count and Say
# *Kết quả cho bài toán Đếm và Nói*

## Description
## *Mô tả*

The **count-and-say** sequence is a sequence of digit strings defined by the recursive formula:
*Chuỗi **đếm và nói** là một chuỗi các chuỗi số được xác định bởi công thức đệ quy:*

*   `countAndSay(1) = "1"`
*   `countAndSay(n)` is the way you would "say" the digit string from `countAndSay(n-1)`, which is then converted into a different digit string.
    *`countAndSay(n)` là cách bạn sẽ "nói" chuỗi số từ `countAndSay(n-1)`, chuỗi này sau đó được chuyển đổi thành một chuỗi số khác.*

To determine how you "say" a digit string, split it into the **minimal** number of substrings such that each substring contains exactly **one** unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
*Để xác định cách bạn "nói" một chuỗi số, hãy chia nó thành số lượng chuỗi con **tối thiểu** sao cho mỗi chuỗi con chứa chính xác **một** chữ số duy nhất. Sau đó, đối với mỗi chuỗi con, hãy nói số lượng chữ số, sau đó nói chữ số đó. Cuối cùng, nối tất cả các chữ số đã nói lại với nhau.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 1`
**Output:** `"1"`
**Explanation:** This is the base case.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 4`
**Output:** `"1211"`
**Explanation:**
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 30`
