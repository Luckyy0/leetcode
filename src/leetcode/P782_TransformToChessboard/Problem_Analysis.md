# 782. Transform to Chessboard / Biến đổi thành Bàn cờ

## Problem Description / Mô tả bài toán
You are given an `n x n` binary grid `board`. In each move, you can swap any two rows or any two columns.
Bạn được cho một lưới nhị phân `n x n` `board`. Trong mỗi lần di chuyển, bạn có thể hoán đổi hai hàng bất kỳ hoặc hai cột bất kỳ.

Return the minimum number of moves to transform the board into a **chessboard**. A chessboard is a board where no two adjacent cells have the same value.
Trả về số lần di chuyển tối thiểu để biến đổi bảng thành **bàn cờ**. Bàn cờ là bảng mà không có hai ô lân cận nào có cùng giá trị.

If the task is impossible, return -1.
Nếu nhiệm vụ không thể thực hiện được, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Property Checklist / Danh sách Kiểm tra Thuộc tính
For a valid chessboard, many strict properties must hold:
1. Every row must be either identical to the first row or the exact inverse of it. (Diagonal property).
Mọi hàng phải giống hệt hàng đầu tiên hoặc là nghịch đảo chính xác của nó.
2. The number of 1s in any row or column must be between `N/2` and `(N+1)/2`.
Số lượng số 1 trong bất kỳ hàng hoặc cột nào phải nằm trong khoảng từ `N/2` đến `(N+1)/2`.
3. The number of rows identical to the first row must also be between `N/2` and `(N+1)/2`.

If property 1 holds for rows, it automatically holds for columns.

Algorithm:
1. Validate properties.
2. For rows and columns separately:
   - Calculate how many swaps needed to match `0101...` pattern or `1010...` pattern.
   - If `N` is odd, only one pattern is valid.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Pattern Validation and Swap Counting
Check row/column counts and internal consistency. Once validated, calculate the minimum swaps to align the current binary strings into a perfect checkerboard sequence.
Kiểm tra số lượng hàng/cột và tính nhất quán nội bộ. Sau khi được xác thực, hãy tính toán số lần hoán đổi tối thiểu để căn chỉnh các chuỗi nhị phân hiện tại thành một chuỗi bàn cờ hoàn hảo.

---
