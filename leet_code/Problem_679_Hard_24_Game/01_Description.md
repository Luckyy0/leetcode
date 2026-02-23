# Result for 24 Game
# *Kết quả cho bài toán Trò chơi 24*

## Description
## *Mô tả*

You are given an integer array `cards` of length 4. You have four cards, each containing a number in the range `[1, 9]`. You should arrange the numbers on these cards in a mathematical expression using the operators `['+', '-', '*', '/']` and the parentheses `'('` and `')'` to get the value 24.
*Bạn được cho một mảng số nguyên `cards` có độ dài 4. Bạn có bốn lá bài, mỗi lá chứa một con số trong phạm vi `[1, 9]`. Bạn nên sắp xếp các con số trên các lá bài này thành một biểu thức toán học sử dụng các toán tử `['+', '-', '*', '/']` và các dấu ngoặc `'('` và `')'` để thu được giá trị 24.*

You can use the following rules:
*Bạn có thể sử dụng các quy tắc sau:*

- The division operator `/` represents real division, not integer division.
    - *Toán tử chia `/` đại diện cho phép chia thực, không phải phép chia số nguyên.*
    - For example, `4 / (1 - 2/3) = 4 / (1/3) = 12`.
- Every card must be used exactly once.
    - *Mỗi lá bài phải được sử dụng đúng một lần.*
- You may rearrange the order of the cards.
    - *Bạn có thể sắp xếp lại thứ tự của các lá bài.*

Return `true` if you can get the value 24 and `false` otherwise.
*Hãy trả về `true` nếu bạn có thể thu được giá trị 24 và `false` nếu không.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** cards = [4,1,8,7]
**Output:** true
**Explanation:** (8-4) * (7-1) = 24

## Example 2:
## *Ví dụ 2:*

**Input:** cards = [1,2,1,2]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `cards.length == 4`
*   `1 <= cards[i] <= 9`
