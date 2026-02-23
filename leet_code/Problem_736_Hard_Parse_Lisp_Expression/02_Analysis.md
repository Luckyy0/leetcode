# Analysis for Parse Lisp Expression
# *Phân tích cho bài toán Phân tích Biểu thức Lisp*

## 1. Problem Essence & Scoped Recursion
## *1. Bản chất vấn đề & Đệ quy Phân cấp*

### The Challenge
### *Thách thức*
We need to evaluate a nested Functional Programming style expression. The difficulty lies in managing variable "shadowing" (where a nested `let` can redefine a variable from an outer scope) and correctly parsing sub-expressions that are themselves balanced parenthetical strings.
*Chúng ta cần tính toán một biểu thức lồng nhau theo phong cách lập trình hàm. Thách thức nằm ở việc quản lý hiện tượng "che khuất" biến (shadowing - nơi một lệnh `let` bên trong có thể định nghĩa lại một biến từ phạm vi bên ngoài) và phân tích chính xác các biểu thức con vốn tự bản thân chúng là các chuỗi cân bằng dấu ngoặc.*

---

## 2. Strategy: Recursive Evaluation with Environment Mapping
## *2. Chiến lược: Đệ quy kết hợp Bản đồ Môi trường*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Environment Map:** Use a `Map<String, Integer>` to store variable values. Whenever we enter a `let` scope, we create a copy of the current map to ensure that assignments don't leak back to the parent scope.
    * **Bản đồ Môi trường:** Sử dụng `Map` để lưu giá trị các biến. Khi vào một khối `let` mới, tạo một bản sao của bản đồ hiện tại để đảm bảo các phép gán không ảnh hưởng ngược lại phạm vi cha.*

2.  **Tokenization Helper:** Create a function to split an expression into its top-level "tokens." A token can be:
    - A simple integer (e.g., `123`, `-5`).
    - A variable name (e.g., `x`, `y`).
    - A full parenthesized expression (e.g., `(add 1 2)`).
    * **Hỗ trợ Phân tách:** Chia biểu thức thành các thành phần cấp cao nhất. Một thành phần có thể là một số nguyên, một tên biến, hoặc một biểu thức đầy đủ nằm trong ngoặc.*

3.  **Recursive Evaluator:**
    - If the expression is an integer: Return its value.
    - If it's a variable: Look it up in the current map.
    - If it's a parenthetical expression `(command ...)`:
        - `add`: Evaluate the next two tokens and return their sum.
        - `mult`: Evaluate the next two tokens and return their product.
        - `let`: Evaluate pairs of (variable, expression) to update the local map, then evaluate the final expression.
    * **Bộ tính toán Đệ quy:** Dựa vào lệnh (`add`, `mult`, `let`) để thực hiện logic tương ứng. Với `let`, ta gán các cặp giá trị cho biến và cuối cùng tính toán biểu thức đích.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the length of the string. The $N^2$ factor comes from string slicing and map copying at each level of nesting.
    * **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ to store the recursion stack and local copies of the environment maps.
    * **Độ phức tạp không gian:** $O(N^2)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

For Lisp-like parsing, recursive descent is the most natural fit. Always use a balanced parenthesis counter to correctly identify where a sub-expression ends, rather than simply splitting by spaces.
*Đối với việc phân tích dạng Lisp, đệ quy đi xuống là phù hợp nhất. Hãy luôn sử dụng bộ đếm dấu ngoặc để xác định điểm kết thúc của biểu thức con thay vì chỉ tách chuỗi bằng khoảng trắng.*
---
*Sự trừu tượng (Abstraction) trong ngôn ngữ cho phép ta định nghĩa thế giới thông qua những cái tên (Variables). Trong cấu trúc của Lisp, mỗi phạm vi (Scope) là một thực tại khép kín, nơi các giá trị cũ có thể bị che mờ bởi những định nghĩa mới. Dữ liệu dạy ta rằng bằng cách tuân thủ trật tự lồng nhau (Recursion) và giữ cho các môi trường được cô lập (Local maps), ta có thể giải mã được những ý niệm phức tạp nhất từ những viên gạch cơ bản nhất của toán học.*
Abstraction (Abstraction) in language allows us to define the world through names (Variables). In the structure of Lisp, each scope (Scope) is a self-contained reality, where old values can be obscured by new definitions. Data teaches us that by following a nested order (Recursion) and keeping environments isolated (Local maps), we can decode the most complex notions from the most basic bricks of mathematics.
