# 1072. Flip Columns For Maximum Number of Equal Rows / Lật Cột để có Số lượng Hàng Bằng nhau Tối đa

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `matrix`.
You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from `0` to `1` or vice versa).
Bạn được cho một ma trận nhị phân `m x n` `matrix`.
Bạn có thể chọn bất kỳ số lượng cột nào trong ma trận và lật mọi ô trong cột đó (tức là, Thay đổi giá trị của ô từ `0` thành `1` hoặc ngược lại).

Return the maximum number of rows that have all values equal after some number of flips.
Trả về số lượng hàng tối đa có tất cả các giá trị bằng nhau sau một số lần lật.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pattern Matching / Khớp Mẫu
Two rows can become equal (all 0s or all 1s) simultaneously if and only if they are formatted identically or exactly oppositely.
Hai hàng có thể trở nên bằng nhau (tất cả là 0 hoặc tất cả là 1) đồng thời nếu và chỉ nếu chúng được định dạng giống hệt nhau hoặc đối lập chính xác.
Example: `0011` and `1100`.
If we flip columns 3 and 4:
`0011` -> `0000` (equal).
`1100` -> `1111` (equal).
Essentially, a row `R` is compatible with another row `S` if `R == S` or `R == ~S`.

Algorithm:
1. Normalize each row:
   - If first char is '1', flip the whole row (temporarily, or produce a "key").
   - If first char is '0', keep as is.
   - This "canonical form" maps `0011` to `0011` and `1100` to `0011`.
2. Count frequency of each canonical form.
3. Max frequency is the answer.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Canonical Form Aggregation
Recognize that rows which can be harmonized (made all 0s or all 1s together) share a structural invariant. Specifically, any row is structurally equivalent to its bitwise negation. By converting each row to a canonical form (e.g., ensuring the first bit is always 0 by flipping if necessary), we can simply count the frequency of these patterns. The most frequent pattern determines the maximum number of simultaneously salvageable rows.
Nhận ra rằng các hàng có thể được hài hòa (làm cho tất cả là 0 hoặc tất cả là 1 cùng nhau) chia sẻ một bất biến cấu trúc. Cụ thể, bất kỳ hàng nào cũng tương đương về mặt cấu trúc với phủ định bit của nó. Bằng cách chuyển đổi mỗi hàng sang dạng chính tắc (ví dụ: đảm bảo bit đầu tiên luôn là 0 bằng cách lật nếu cần), chúng ta có thể đơn giản đếm tần suất của các mẫu này. Mẫu thường xuyên nhất xác định số lượng hàng có thể cứu được đồng thời tối đa.

---
