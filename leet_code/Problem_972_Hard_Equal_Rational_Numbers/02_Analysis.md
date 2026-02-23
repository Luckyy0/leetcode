# Analysis for Equal Rational Numbers
# *Phân tích cho bài toán Các Số Hữu tỉ Bằng nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Compare two rational numbers represented as strings. Strings may contain repeating parts in parentheses.
*So sánh hai số hữu tỉ được biểu diễn bằng chuỗi, có thể chứa phần lặp lại trong ngoặc.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A repeating decimal can be converted to a fraction or simply expanded.
- Since constraint on length is very small (Integer part $\le 4$, non-repeating $\le 4$, repeating $\le 4$), we can just expand the repeating part enough times to compare as `double` or `string`.
- However, floating point precision might be tricky.
- Better approach: Convert both to `Double`. Expand the repeating part sufficiently (e.g., to ~16-20 digits) so that `Double.parseDouble` handles it correctly.
- Or: Convert to Fraction `P/Q`.
  - Format: `I.N(R)`.
  - Value = $I + \frac{N}{10^k} + \frac{R}{10^k \cdot (10^len - 1)}$.
  - Where $k$ is length of non-repeating part $N$, $len$ is length of repeating part $R$.
  - Simplify fraction using GCD.
  - Compare two simplified fractions.
- Special Case: `0.(9)` equals `1`. Fraction method handles this naturally ($9/9 = 1$).
- Constraint: repeating part length $\le 4$. LCM of 1,2,3,4 is 12. If we expand to length ~15, it should be stable.
- Given the constraints are tiny, using `Double` with sufficient expansion is easier to implement and likely correct within epsilon. But let's verify `0.(9)` case. `0.99999999999999` is very close to 1.
- Let's stick to the double conversion strategy by repeating the repeating part multiple times (e.g., 20 digits). `Double` has ~15-17 significant decimal digits.
*Chuyển đổi sang Double bằng cách mở rộng phần lặp lại đủ dài. Double có đủ độ chính xác cho các ràng buộc nhỏ này.*

---

## 2. Strategy: String Expansion to Double
## *2. Chiến lược: Mở rộng Chuỗi sang Double*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Parse Function:** Convert string `S` to `double`.
    - Find `(` and `)`.
    - If no `(`, simple `Double.valueOf(S)`.
    - If `(`, extract `base` (integer + non-repeating) and `repeat`.
    - Append `repeat` to `base` repeatedly until length is sufficiently long (e.g., 20 chars after dot).
    - Parse result.
    *   **Hàm Parse:** Chuyển chuỗi sang số thực. Mở rộng phần lặp lại.*

2.  **Comparison:** `Math.abs(d1 - d2) < 1e-9`.
    *   **So sánh:** Sai số nhỏ.*

3.  **Refinement:** Handling `0.(9)` vs `1.`.
    - `0.99999...` is mathematically 1.
    - Floating point representation of `0.9999999999999999` (16 nines) is virtually 1.
    - Let's assume standard float precision suffices.
    *   **Tinh chỉnh:** Xử lý trường hợp 0.(9).*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public boolean isRationalEqual(String s, String t) {
        return Math.abs(convertToDouble(s) - convertToDouble(t)) < 1e-9;
    }

    private double convertToDouble(String s) {
        int i = s.indexOf('(');
        if (i != -1) {
            String base = s.substring(0, i);
            String rep = s.substring(i + 1, s.length() - 1);
            StringBuilder sb = new StringBuilder(base);
            while (sb.length() < 20) {
                sb.append(rep);
            }
            return Double.parseDouble(sb.toString());
        }
        return Double.parseDouble(s);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. String lengths are very small.
    *   **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Expanding the repeating part to utilize `double` precision is the simplest and most effective approach given the constraints.
*Mở rộng phần lặp lại để tận dụng độ chính xác của `double` là cách tiếp cận đơn giản và hiệu quả nhất với các ràng buộc đã cho.*
