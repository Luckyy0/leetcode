# Result for Push Dominoes
# *Kết quả cho bài toán Đẩy Quân cờ Domino*

## Description
## *Mô tả*

There are `n` dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
*Có `n` quân cờ domino xếp thành một hàng, ban đầu được đặt thẳng đứng. Chúng ta đồng thời đẩy một số quân sang trái hoặc sang phải.*

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, each domino that is falling to the right pushes the adjacent domino on the right.
*Sau mỗi giây, quân cờ đang đổ sang trái sẽ đẩy quân bên trái nó, và tương tự với bên phải.*

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
*Khi một quân domino đang đứng bị hai quân khác từ hai phía đổ vào cùng lúc, nó sẽ đứng yên do lực cân bằng.*

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
*Chúng ta coi rằng một quân domino đang đổ sẽ không tác động thêm lực vào một quân đã đổ.*

You are given a string `dominoes` representing the initial state where:
- `dominoes[i] = 'L'`: the `i`-th domino has been pushed to the left.
- `dominoes[i] = 'R'`: the `i`-th domino has been pushed to the right.
- `dominoes[i] = '.'`: the `i`-th domino has not been pushed.

Return *a string representing the final state*.
*Trả về *một chuỗi đại diện cho trạng thái cuối cùng*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** dominoes = "RR.L"
**Output:** "RR.L"
**Explanation:** The first domino expends no additional force to the second domino.

## Example 2:
## *Ví dụ 2:*

**Input:** dominoes = ".L.R...LR..L.."
**Output:** "LL.RR.LLRRLL.."

---

## Constraints:
## *Ràng buộc:*

*   `n == dominoes.length`
*   `1 <= n <= 10^5`
*   `dominoes[i]` is either `'L'`, `'R'`, or `'.'`.
