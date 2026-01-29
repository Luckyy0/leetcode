# 1056. Confusing Number / Số Gây nhầm lẫn

## Problem Description / Mô tả bài toán
A **confusing number** is a number that when rotated 180 degrees becomes a different number with each digit valid.
Một **số gây nhầm lẫn** là một số mà khi xoay 180 độ sẽ trở thành một số khác với mỗi chữ số đều hợp lệ.

We can rotate digits 0, 1, 6, 8, 9. 0, 1, and 8 rotate to themselves. 6 rotates to 9 and 9 rotates to 6. Other numbers do not rotate to valid numbers.
Chúng ta có thể xoay các chữ số 0, 1, 6, 8, 9. 0, 1 và 8 xoay thành chính nó. 6 xoay thành 9 và 9 xoay thành 6. Các số khác không xoay thành số hợp lệ.

Given an integer `n`, return `true` if it is a confusing number, or `false` otherwise.
Cho một số nguyên `n`, hãy trả về `true` nếu nó là số gây nhầm lẫn, hoặc `false` nếu ngược lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit Mapping and Reversal / Ánh xạ Chữ số và Đảo ngược
Algorithm:
1. Map: `0->0`, `1->1`, `6->9`, `8->8`, `9->6`. Others invalid.
2. Construct reversed number digit by digit.
   - Extract last digit `d = n % 10`.
   - If `d` invalid, return false.
   - `newNum = newNum * 10 + map(d)`.
   - `n /= 10`.
3. Check `newNum != originalN`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Rotational Simulation
Construct the rotated version of the number by mapping each digit to its invert (if valid) and assembling them in reverse order. The number is "confusing" if this reconstruction is both valid and numerically distinct from the original.
Xây dựng phiên bản xoay của số bằng cách ánh xạ từng chữ số với nghịch đảo của nó (nếu hợp lệ) và lắp ráp chúng theo thứ tự ngược lại. Con số này "gây nhầm lẫn" nếu việc tái tạo này vừa hợp lệ vừa khác biệt về mặt số học so với bản gốc.

---
