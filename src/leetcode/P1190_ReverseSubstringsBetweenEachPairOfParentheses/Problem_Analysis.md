# 1190. Reverse Substrings Between Each Pair of Parentheses / Đảo ngược Chuỗi con Giữa Mỗi Cặp Dấu ngoặc đơn

## Problem Description / Mô tả bài toán
Given a string `s` that consists of lower case English letters and parentheses.
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Result should not contain any parentheses.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack or Wormhole Traversal / Ngăn xếp hoặc Duyệt Lỗ sâu
Approach 1: Stack.
- Push chars.
- If ')', pop until '(', reverse popped part, push back.
- O(N^2) worst case.

Approach 2: O(N) Wormhole.
Matching pairs `(i, j)`.
Pairs reverse direction.
Traverse string:
- If `(`: jump to `j`, change direction (flip).
- If `)`: jump to `i`, change direction.
- Else: append char.
Actually simpler:
Precompute pairs.
Start at 0, direction +1.
When hitting a parenthesis, verify where its pair is, jump there, reverse direction.
This effectively simulates the reversal paths without moving chars.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Wormhole Traversal (Optimized)
Instead of simulating recursion with O(N²) string operations, use a "wormhole" concept. Precompute the matching pairs of parentheses. Traverse the string; whenever a parenthesis is encountered, jump instantly to its matching pair and reverse the direction of traversal. This path naturally traces the characters in their final reversed order without repeated scanning or string building overhead.
Thay vì mô phỏng đệ quy với các thao tác chuỗi O(N²), hãy sử dụng khái niệm "lỗ sâu". Tính toán trước các cặp dấu ngoặc đơn khớp nhau. Duyệt chuỗi; bất cứ khi nào gặp dấu ngoặc đơn, hãy nhảy ngay lập tức đến cặp khớp của nó và đảo ngược hướng duyệt. Đường dẫn này tự nhiên theo dõi các ký tự theo thứ tự đảo ngược cuối cùng của chúng mà không cần quét lại hoặc chi phí xây dựng chuỗi.

---
