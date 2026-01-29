# 1169. Invalid Transactions / Giao dịch Không hợp lệ

## Problem Description / Mô tả bài toán
A transaction is possibly invalid if:
- amount > 1000
- or, it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
Given a list of strings `transactions` ("name,time,amount,city"), return a list of invalid transactions.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Parsing and Comparison / Phân tích và So sánh
1. Parse transactions into objects: Name, Time, Amount, City, OriginalString, Index.
2. Mark transactions invalid if amount > 1000.
3. Compare all pairs (O(N^2)). Or optimize by grouping by Name.
4. For same name, compare times and cities.
   - If `abs(t1 - t2) <= 60` and `city1 != city2`:
     - Mark BOTH as invalid.
5. Collect result.

### Complexity / Độ phức tạp
- **Time**: O(N^2) worst case (all same name).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Grouped Comparisons
Parse all transactions. Group them by name to limit comparisons. Within each name group, check every transaction against every other transaction. If a pair occurs within 60 minutes in different cities, mark both as invalid. Also, mark any transaction with an amount $> 1000$. Use a boolean array to track invalid status to avoid duplicates.
Phân tích tất cả các giao dịch. Nhóm chúng theo tên để hạn chế so sánh. Trong mỗi nhóm tên, kiểm tra mọi giao dịch so với mọi giao dịch khác. Nếu một cặp xảy ra trong vòng 60 phút ở các thành phố khác nhau, hãy đánh dấu cả hai là không hợp lệ. Ngoài ra, hãy đánh dấu bất kỳ giao dịch nào có số tiền $> 1000$. Sử dụng mảng boolean để theo dõi trạng thái không hợp lệ để tránh trùng lặp.

---
