# 465. Optimal Account Balancing / Cân Bằng Tài Khoản Tối Ưu

## Problem Description / Mô tả bài toán
You are given a list of transactions `transactions` where `transactions[i] = [fromi, toi, amounti]` indicates that the person with `ID = fromi` gave `amounti` $ to the person with `ID = toi`.
Bạn được cho một danh sách các giao dịch `transactions` trong đó `transactions[i] = [fromi, toi, amounti]` cho biết người có `ID = fromi` đã đưa `amounti` $ cho người có `ID = toi`.

Return the **minimum** number of transactions required to settle the debt.
Hãy trả về số lượng giao dịch **tối thiểu** cần thiết để giải quyết nợ nần.

### Example 1:
```text
Input: transactions = [[0,1,10],[2,0,5]]
Output: 2
Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.
Two transactions are needed. One way to settle the debt is person #1 pays person #0 $10 and person #0 pays person #2 $5.
Actually, 2 is correct.
```

## Constraints / Ràng buộc
- `1 <= transactions.length <= 8`
- `transactions[i].length == 3`
- `0 <= fromi, toi < 12`
- `fromi != toi`
- `1 <= amounti <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Debt Consolidation / Quay lui với việc hợp nhất nợ
The first step is to calculate the net balance for each person.
`balance[person] = sum(received) - sum(given)`.
Only people with non-zero balances need to participate in settlement. Let these non-zero balances be in a list `debts`.

Our goal is to reduce all values in `debts` to 0 using minimum operations.

Algorithm:
1. Calculate `debts[]` for all people involved. Filter out people with 0 balance.
2. Use a recursive function `dfs(startIndex)`:
   - Skip if `debts[startIndex] == 0`.
   - If `startIndex == debts.length`, return 0.
   - For `i` from `startIndex + 1` to `debts.length - 1`:
     - If `debts[i] * debts[startIndex] < 0` (they have opposite signs, one owes and one is owed):
       - Settle `debts[startIndex]` into `debts[i]`: `debts[i] += debts[startIndex]`.
       - Recurse: `res = 1 + dfs(startIndex + 1)`.
       - **Backtrack**: `debts[i] -= debts[startIndex]`.
       - Update the minimum transactions found.
3. Return the minimum result.

### Complexity / Độ phức tạp
- **Time**: Worst case O((N-1)!) where N is the number of people with non-zero balances. Given N <= 12, this is feasible.
- **Space**: O(N) for recursion.

---

## Analysis / Phân tích

### Approach: Recursive Debt Settlement

**Algorithm**:
1.  Compute net balances.
2.  DFS through non-zero balances.
3.  Greedy pruning: only match opposite signs.

---
