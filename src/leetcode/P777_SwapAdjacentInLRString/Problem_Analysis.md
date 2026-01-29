# 777. Swap Adjacent in LR String / Hoán đổi Lân cận trong Chuỗi LR

## Problem Description / Mô tả bài toán
In a string composed of 'L', 'R', and 'X' characters, like `"RXXLRXRXL"`, a move consists of either:
Trong một chuỗi bao gồm các ký tự 'L', 'R' và 'X', chẳng hạn như `"RXXLRXRXL"`, một nước đi bao gồm:

- Replacing `"XL"` with `"LX"`. (Moves 'L' to the left)
- Replacing `"RX"` with `"XR"`. (Moves 'R' to the right)

Given `start` and `end` strings, return `true` if there exists a sequence of moves to transform `start` into `end`.
Cho các chuỗi `start` và `end`, hãy trả về `true` nếu tồn tại một chuỗi các nước đi để biến đổi `start` thành `end`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Preservation and Movement Constraints / Ràng buộc Bảo toàn và Di chuyển
1. **Letter sequences must match**: If you remove all 'X' characters, the sequence of 'L' and 'R' must be identical in both strings because 'L' and 'R' cannot cross each other.
Dãy các chữ cái phải khớp nhau: Nếu bạn loại bỏ tất cả các ký tự 'X', dãy 'L' và 'R' phải giống hệt nhau trong cả hai chuỗi vì 'L' và 'R' không thể vượt qua nhau.
2. **Movement direction**:
   - 'L' can only move left (`XL -> LX`). So index of 'L' in `start` must be `>=` index of 'L' in `end`.
   - 'R' can only move right (`RX -> XR`). So index of 'R' in `start` must be `<=` index of 'R' in `end`.

Algorithm:
- Use two pointers to skip 'X' characters in both strings and compare the L/R letters and their positions.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Relative Position Check
Iterate through the non-'X' characters. Verify that their sequence remains the same and that their displacement follows the allowed directional rules (L moves left, R moves right).
Lặp lại qua các ký tự không phải 'X'. Xác minh rằng trình tự của chúng vẫn giữ nguyên và sự dịch chuyển của chúng tuân theo các quy tắc hướng được phép (L di chuyển sang trái, R di chuyển sang phải).

---
