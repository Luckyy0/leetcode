# Result for Optimal Account Balancing
# *Kết quả cho bài toán Cân bằng Tài khoản Tối ưu*

## Description
## *Mô tả*

You are given an array of transactions `transactions` where `transactions[i] = [from_i, to_i, amount_i]` indicates that the person with `ID = from_i` gave `amount_i` $ to the person with `ID = to_i`.
*Bạn được cho một mảng các giao dịch `transactions` trong đó `transactions[i] = [from_i, to_i, amount_i]` cho biết rằng người có `ID = from_i` đã đưa `amount_i` $ cho người có `ID = to_i`.*

Return *the minimum number of transactions required to settle the debt*.
*Hãy trả về *số lượng giao dịch tối thiểu cần thiết để tất toán nợ nần*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `transactions = [[0,1,10],[2,0,5]]`
**Output:** `2`
**Explanation:**
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.
Two transactions are needed. One way is to settle the debt by person #1 giving person #0 $10 and person #0 giving person #2 $5.

## Example 2:
## *Ví dụ 2:*

**Input:** `transactions = [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]`
**Output:** `1`
**Explanation:**
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.
Therefore, person #0 only need to give person #1 $4, and all debt is settled.

## Constraints:
## *Ràng buộc:*

*   `1 <= transactions.length <= 8`
*   `transactions[i].length == 3`
*   `0 <= from_i, to_i < 12`
*   `from_i != to_i`
*   `1 <= amount_i <= 100`
