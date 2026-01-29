# 860. Lemonade Change / Tiền lẻ Bán nước chanh

## Problem Description / Mô tả bài toán
Each lemonade costs $5$. Customers are in a queue and pay with $5, $10, or $20. You must provide change to each.
Mỗi cốc nước chanh giá $5. Khách hàng đứng trong hàng và thanh toán bằng tờ $5, $10, hoặc $20. Bạn phải thối tiền lẻ cho từng khách.

Return `true` if you can provide every customer with correct change.
Trả về `true` nếu bạn có thể thối tiền chính xác cho mọi khách hàng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Money Management / Quản lý Tiền tham lam
When giving $15 in change (for a $20 bill), you have two options:
1. One $10 and one $5.
2. Three $5.

Optimization:
The $5 bill is more "valuable" because it's needed for $10 changes as well. Always prefer using the $10 bill for $20 changes if possible.
Tờ $5 "giá trị" hơn vì nó cũng cần thiết để thối cho tờ $10. Luôn ưu tiên sử dụng tờ $10 để thối cho tờ $20 nếu có thể.

Algorithm:
1. Initialize `five = 0, ten = 0`.
2. For each bill:
   - If 5: `five++`.
   - If 10: `ten++, five--`.
   - If 20:
     - Prefer: `ten--, five--`.
     - Else: `five -= 3`.
3. If any count becomes negative, return `false`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Change Priorities
Maintain counts of the currency denominations. Since $5 bills are strictly more versatile than $10 bills, reserving $5s by spending $10s first is the optimal greedy strategy.
Duy trì số lượng các mệnh giá tiền tệ. Vì các tờ $5 linh hoạt hơn hẳn các tờ $10, việc tiết kiệm các tờ $5 bằng cách tiêu các tờ $10 trước là chiến lược tham lam tối ưu.

---
