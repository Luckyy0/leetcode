# 1222. Queens That Can Attack the King / Những quân Hậu có thể Tấn công Vua

## Problem Description / Mô tả bài toán
On an 8x8 chessboard, there is one King and several Queens.
Return all the queens that can directly attack the King.
Attacking directly means in same row, column or diagonal, with no other queens in between.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation in 8 Directions / Mô phỏng theo 8 Hướng
From King's position, iterate in all 8 directions.
In each direction, stop at the first piece encountered.
If it is a Queen, add to result.
Since only one piece can block/be the attacker per direction, iterating outwards from King is efficient.

### Complexity / Độ phức tạp
- **Time**: O(8 * 8) = O(1). Board size is fixed.
- **Space**: O(1) mostly (or O(Q) output).

---

## Analysis / Phân tích

### Approach: Radial Search from King
Instead of checking each queen to see if it attacks the King, start from the King and scan outwards in all 8 directions (horizontal, vertical, diagonal). The first queen encountered in any direction is the one that can "directly" attack (others in that line are blocked). Store queen positions in a set or boolean grid for quick lookup, or just check the input list (but scanning from King on grid is faster conceptually since board is small). Actually, filling a boolean grid first allows O(1) check during expansion.
Thay vì kiểm tra từng quân hậu xem nó có tấn công Vua hay không, hãy bắt đầu từ Vua và quét ra ngoài theo tất cả 8 hướng (ngang, dọc, chéo). Quân hậu đầu tiên gặp phải theo bất kỳ hướng nào là quân hậu có thể tấn công "trực tiếp" (những quân khác trong dòng đó bị chặn). Lưu trữ vị trí quân hậu trong một tập hợp hoặc lưới boolean để tra cứu nhanh, hoặc chỉ cần kiểm tra danh sách đầu vào (nhưng quét từ Vua trên lưới nhanh hơn về mặt khái niệm vì bàn cờ nhỏ). Thực ra, điền vào lưới boolean trước cho phép kiểm tra O(1) trong quá trình mở rộng.

---
