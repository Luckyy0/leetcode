# Analysis for Solve the Equation
# *Phân tích cho bài toán Giải Phương trình*

## 1. Problem Essence & Linear Equation Normalization
## *1. Bản chất vấn đề & Chuẩn hóa Phương trình bậc nhất*

### The Challenge
### *Thách thức*
We are given a linear equation as a string and need to find the value of $x$. The equation involves simple arithmetic and the variable $x$.
*Chúng ta được cho một phương trình bậc nhất dưới dạng chuỗi và cần tìm giá trị của $x$. Phương trình bao gồm các phép tính số học đơn giản và biến $x$.*

The core task is to parse the left and right sides of the equation and combine them into the standard form $Ax = B$.
*Nhiệm vụ cốt lõi là phân tích các vế trái và phải của phương trình và kết hợp chúng thành dạng chuẩn $Ax = B$.*

---

## 2. Strategy: Coefficient Parsing
## *2. Chiến lược: Phân tích Hệ số*

We can simplify each side of the equation independently into a pair of values: `(coeffX, constant)`.
*Chúng ta có thể đơn giản hóa độc lập mỗi vế của phương trình thành một cặp giá trị: `(coeffX, constant)`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Split the Equation:** Use the `=` sign as a delimiter to separate the left and right strings.
    * **Chia Phương trình:** Sử dụng dấu `=` làm dấu phân cách để tách các chuỗi bên trái và bên phải.*

2.  **Parse Each Side:** Create a helper function that scans a string and extracts terms.
    * **Phân tích mỗi vế:** Tạo một hàm phụ trợ để quét chuỗi và trích xuất các hạng tử.*
    - A term is defined by a leading `+` or `-` (implicitly `+` for the first term).
    - If a term ends with `x`, parse the numeric part as a coefficient (handling cases like `x`, `+x`, `-x` as `1`, `1`, `-1`).
    - Otherwise, parse the term as a constant integer.

3.  **Consolidate:** 
    * **Hợp nhất:** *
    - Final $A = \text{leftCoeffX} - \text{rightCoeffX}$.
    - Final $B = \text{rightConstant} - \text{leftConstant}$.
    - *The equation becomes $Ax = B$.*

4.  **Evaluate:**
    * **Đánh giá:** *
    - If $A == 0$ and $B == 0$: Return "Infinite solutions".
    - If $A == 0$ and $B \ne 0$: Return "No solution".
    - Otherwise: Return "x=" + (B / A).

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Handling `x` edge cases:** A string like `x` has an implicit coefficient of `1`, and `-x` has `-1`. Using a regex (like `(?=[+-])`) or a manual scanner that looks for these specific cases is vital.
    * **Xử lý các trường hợp cận của `x`:** Một chuỗi như `x` có hệ số mặc định là `1`, và `-x` là `-1`. Việc sử dụng regex hoặc một trình quét thủ công để tìm các trường hợp cụ thể này là rất quan trọng.*
*   **Linear Simplicity:** Since we are guaranteed integer solutions if a unique one exists, there's no need for floating-point arithmetic.
    * **Sự đơn giản của Phương trình bậc nhất:** Vì chúng ta được đảm bảo nghiệm số nguyên nếu tồn tại nghiệm duy nhất, nên không cần dùng đến số thực.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$ where $L$ is the length of the equation string. We traverse the string a constant number of times (splitting and parsing tokens).
    * **Độ phức tạp thời gian:** $O(L)$ trong đó $L$ là độ dài của chuỗi phương trình.*
*   **Space Complexity:** $O(L)$ to store the tokens/substrings during parsing.
    * **Độ phức tạp không gian:** $O(L)$ để lưu trữ các mã thông báo/chuỗi con trong quá trình phân tích.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** "x+5-3+x=6+x-2"
1. Split: "x+5-3+x" and "6+x-2".
2. Parse Left:
   - x: X=1.
   - +5: C=5.
   - -3: C=-3.
   - +x: X=1.
   - Total: X=2, C=2.
3. Parse Right:
   - 6: C=6.
   - +x: X=1.
   - -2: C=-2.
   - Total: X=1, C=4.
4. $A = 2-1 = 1$, $B = 4-2 = 2$.
5. $1x = 2 \rightarrow x=2$.
**Result:** "x=2".

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For parsing algebraic strings, standardizing them into a sum of coefficients ($Ax + B = Cx + D$) is the most robust approach. Focus on a clean way to split tokens by signs to simplify the parsing loop.
*Để phân tích các chuỗi đại số, việc chuẩn hóa chúng thành tổng các hệ số là cách tiếp cận mạnh mẽ nhất. Hãy tập trung vào một cách sạch sẽ để tách các hạng tử theo dấu nhằm đơn giản hóa vòng lặp phân tích.*
---
*Mọi sự cân bằng (Equation) đều bắt đầu từ việc thấu hiểu giá trị của những biến số (x). Trong toán học, việc giải quyết một mâu thuẫn (No solution) hay tìm thấy sự đồng điệu tuyệt đối (Infinite solutions) đòi hỏi ta phải quy nạp tất cả về một trật tự chung (Ax = B). Dữ liệu dạy ta rằng bằng cách phân tách (Parsing) và hợp nhất (Consolidate), ta có thể tìm thấy lời giải cho những ẩn số phức tạp nhất.*
Every balance (Equation) starts from understanding the value of variables (x). In mathematics, resolving a contradiction (No solution) or finding absolute harmony (Infinite solutions) requires us to induce everything into a common order (Ax = B). Data teaches us that by separating (Parsing) and merging (Consolidate), we can find solutions to the most complex unknowns.
