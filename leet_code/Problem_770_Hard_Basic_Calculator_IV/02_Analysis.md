# Analysis for Basic Calculator IV
# *Phân tích cho bài toán Máy tính Cơ bản IV*

## 1. Problem Essence & Polynomial Arithmetic
## *1. Bản chất vấn đề & Số học Đa thức*

### The Challenge
### *Thách thức*
We need to parse an expression containing variables, constants, and operators (+, -, \*). Recursively simplify it into a polynomial form.
*Chúng ta cần phân tích một biểu thức chứa biến, hằng số và toán tử (+, -, \*). Đơn giản hóa nó một cách đệ quy về dạng đa thức.*

A Polynomial consists of Terms. Each Term has a **coefficient** (int) and a list of **variables** (List<String> sorted lexicographically).
*Một Đa thức gồm các Hạng tử. Mỗi Hạng tử có một **hệ số** (int) và một danh sách các **biến** (List<String> được sắp xếp theo thứ tự từ điển).*

Example: $3a^2b + 5c$ has terms: `{coeff: 3, vars: [a, a, b]}` and `{coeff: 5, vars: [c]}`.
*Ví dụ: $3a^2b + 5c$ có các hạng tử: `{hệ số: 3, biến: [a, a, b]}` và `{hệ số: 5, biến: [c]}`.*

---

## 2. Strategy: Recursive Parsing & Objects
## *2. Chiến lược: Phân tích Đệ quy & Đối tượng*

### Data Structures
### *Cấu trúc Dữ liệu*
1.  **Polynomial Class:** Represents a collection of Terms. Map `List<String>` (key) -> `Coef` (value).
2.  **Operations:**
    - `Add(Poly a, Poly b)`: Merge maps.
    - `Sub(Poly a, Poly b)`: Merge with negated coefficients.
    - `Mul(Poly a, Poly b)`: Cross-multiply every term in `a` with `b`.
      - New term vars: Merge lists and sort.
      - New term coef: `c1 * c2`.
    *   **Lớp Đa thức:** Đại diện cho tập hợp Hạng tử. Sử dụng Map để lưu trữ. Các phép toán `Cộng`, `Trừ` (gộp map), `Nhân` (nhân chéo từng hạng tử).*

### Algorithm
### *Thuật toán*

1.  **Parse (`evalvars`):** Store known values in a map. Replace variables in expression with values immediately or handle during parsing? Better to keep as variables in Terms, but if a variable has a known int value, treat it as a constant Term.
    *   **Phân tích (`evalvars`):** Lưu các giá trị đã biết vào map. Nếu biến có giá trị, coi như hằng số.*

2.  **Shunting-Yard or Recursive Descent:**
    - Convert expression to Postfix (RPN) or use recursion. recursion is easier for parentheses.
    - `parse()` function returns a `Polynomial`.
    - Base case: Variable or Number. Return Poly with 1 term.
    - Recursive step: Handle `(`, `)`, `+`, `-`, `*`. Priority: `*` > `+,-`.
    *   **Shunting-Yard hoặc Đệ quy Xuống:** Chuyển sang hậu tố hoặc dùng đệ quy. Hàm `parse` trả về `Polynomial`. Trường hợp cơ sở: Biến hoặc Số. Bước đệ quy: Xử lý ngoặc và toán tử theo độ ưu tiên.*
    - Actually, typically standard approach: Two stacks (Opers, Polys).
    *   Thực tế, cách tiếp cận chuẩn: Hai ngăn xếp (Toán tử, Đa thức).*

3.  **Final Formatting:**
    - Flatten the map to a list of terms.
    - Sort terms:
      - By Degree (descending).
      - By Lexicographical order of variables (ascending).
    - Format as string: coefficient + "*" + variables joined by "*".
    *   **Định dạng Cuối cùng:** Làm phẳng map thành danh sách hạng tử. Sắp xếp theo bậc (giảm dần) và từ điển. Định dạng thành chuỗi.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
class Poly {
    // Map of Variables-List -> Coefficient
    Map<List<String>, Integer> terms = new HashMap<>();
    
    void add(Poly other) { ... }
    void mul(Poly other) { ... }
    List<String> toResult() { ... }
}

// Main logic
Stack<Poly> operands = new Stack<>();
Stack<Character> ops = new Stack<>();

// Iterate expression tokens...
// Apply standard precedence logic.
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** High. Polynomial multiplication can explode terms. Given constraints (len 250), it is manageable but worst case is exponential if expression is `(a+b)*(c+d)...`. But typically constrained.
    *   **Độ phức tạp thời gian:** Cao. Nhân đa thức có thể làm bùng nổ số lượng hạng tử. Với ràng buộc độ dài 250, vẫn khả thi.*
*   **Space Complexity:** High for storing terms.
    *   **Độ phức tạp không gian:** Cao để lưu các hạng tử.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Exp:** `(e + 8) * (e - 8)`
1. Parse `e` -> Poly `{ {e}: 1 }`.
2. Parse `8` -> Poly `{ {}: 8 }`.
3. Add -> `{ {e}: 1, {}: 8 }`. (Represents `e + 8`)
4. Parse `e`, `8`. Sub -> `{ {e}: 1, {}: -8 }`. (Represents `e - 8`)
5. Mul:
   - `e * e` -> `{e, e}: 1`
   - `e * -8` -> `{e}: -8`
   - `8 * e` -> `{e}: 8`
   - `8 * -8` -> `{}: -64`
6. Combine: `{e, e}: 1`, `{e}: 0`, `{}: -64`.
7. Remove zero Coefs. Result: `1*e*e`, `-64`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Object-Oriented Design with a `Polynomial` class handling `Map<List<String>, Integer>` is the robust way.
*Thiết kế Hướng đối tượng với lớp `Polynomial` xử lý `Map<List<String>, Integer>` là cách tiếp cận mạnh mẽ nhất.*
