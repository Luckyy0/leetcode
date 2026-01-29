# 1021. Remove Outermost Parentheses / Loại bỏ Dấu ngoặc ngoài cùng

## Problem Description / Mô tả bài toán
A valid parentheses string is either empty, `(A)`, or `A + B`.
Một chuỗi dấu ngoặc hợp lệ là rỗng, `(A)`, hoặc `A + B`.
A primitive valid parentheses string cannot be split into `A + B`.
Một chuỗi dấu ngoặc hợp lệ nguyên thủy là chuỗi không thể tách thành `A + B`.

Given a valid parentheses string `s`, consider its primitive decomposition: `s = P_1 + P_2 + ... + P_k`.
Cho một chuỗi dấu ngoặc hợp lệ `s`, hãy xem xét phân rã nguyên thủy của nó: `s = P_1 + P_2 + ... + P_k`.
Return `s` after removing the outermost parentheses of every primitive string in the decomposition.
Hãy trả về `s` sau khi loại bỏ các dấu ngoặc ngoài cùng của mọi chuỗi nguyên thủy trong phân rã.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Counter / Stack / Bộ đếm / Ngăn xếp
We can identify the boundaries of primitive strings by tracking the balance of open and close parentheses.
Chúng ta có thể xác định ranh giới của các chuỗi nguyên thủy bằng cách theo dõi sự cân bằng của các dấu ngoặc mở và đóng.

Algorithm:
1. Initialize `count = 0` and `StringBuilder`.
2. Iterate through `s`.
3. If `c == '('`:
   - If `count > 0`, append `(` (it's not outermost).
   - `count++`.
4. If `c == ')'`:
   - `count--`.
   - If `count > 0`, append `)` (it's not outermost).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Depth-Aware Filtering
Traverse the string while maintaining a depth counter. Parentheses encountered at a depth greater than 0 are part of the inner structure and should be kept, while those at depth 0 (transitions between primitives) or causing a transition to depth 1 are the outermost layers to be discarded.
Duyệt qua chuỗi trong khi duy trì bộ đếm độ sâu. Các dấu ngoặc gặp phải ở độ sâu lớn hơn 0 là một phần của cấu trúc bên trong và nên được giữ lại, trong khi những dấu ngoặc ở độ sâu 0 (chuyển tiếp giữa các nguyên thủy) hoặc gây ra sự chuyển đổi sang độ sâu 1 là các lớp ngoài cùng cần bị loại bỏ.

---
