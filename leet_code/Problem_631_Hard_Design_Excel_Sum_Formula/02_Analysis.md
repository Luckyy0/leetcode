# Analysis for Design Excel Sum Formula
# *Phân tích cho bài toán Thiết kế Công thức Tổng Excel*

## 1. Problem Essence & Dependency Management
## *1. Bản chất vấn đề & Quản lý Phụ thuộc*

### The Challenge
### *Thách thức*
We need to model a spreadsheet where cells can contain static values or dynamic "sum formulas". When a cell is updated, all cells dependent on it (directly or indirectly via formulas) must reflect the new value.
*Chúng ta cần mô hình hóa một bảng tính nơi các ô có thể chứa giá trị tĩnh hoặc "công thức tổng" động. Khi một ô được cập nhật, tất cả các ô phụ thuộc vào nó (trực tiếp hoặc gián tiếp qua công thức) phải phản ánh giá trị mới.*

The core difficulty is handling the lazy or eager updates of formulas. Given the constraints (max 100 calls), even a recursive approach without complex memoization can work.
*Khó khăn cốt lõi là xử lý việc cập nhật công thức (lười biếng hoặc chủ động). Với các ràng buộc (tối đa 100 cuộc gọi), ngay cả cách tiếp cận đệ quy mà không có bộ nhớ đệm phức tạp cũng có thể hoạt động.*

---

## 2. Strategy: Recursive Evaluation with Formula Storage
## *2. Chiến lược: Đánh giá Đệ quy với Lưu trữ Công thức*

Each cell will store its state: either a constant `value` or a `formula` (represented as a collection of other cells it depends on).
*Mỗi ô sẽ lưu trữ trạng thái của nó: hoặc là một giá trị hằng số `value` hoặc là một `công thức` (được biểu diễn dưới dạng một tập hợp các ô khác mà nó phụ thuộc vào).*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Data Structure:** Use a 2D object array `cells[height][width]`.
    * **Cấu trúc dữ liệu:** Sử dụng một mảng đối tượng 2 chiều `cells[height][width]`.*
    - Each element represents a cell and holds:
      - `int val`: The static value (if not a sum cell).
      - `Map<String, Integer> formula`: A map where the key is a cell coordinate (e.g., "A1") and the value is the frequency of that cell in the sum.
      - *Mỗi phần tử đại diện cho một ô và giữ: `val` (giá trị tĩnh) và `formula` (một bản đồ trong đó khóa là tọa độ ô và giá trị là tần suất của ô đó trong tổng).*

2.  **`set(row, col, val)`:** 
    - Overwrite any existing formula with the new static value.
    - *Ghi đè bất kỳ công thức hiện có nào bằng giá trị tĩnh mới.*

3.  **`get(row, col)`:**
    - If the cell has no formula, return `val`.
    - If it has a formula, sum up the values of all cells in the formula (calling `get` recursively) multiplied by their frequency.
    - *Nếu ô không có công thức, trả về `val`. Nếu nó có công thức, hãy cộng tổng giá trị của tất cả các ô trong công thức (gọi `get` đệ quy) nhân với tần suất của chúng.*

4.  **`sum(row, col, numbers)`:**
    - Create a new formula map for the target cell.
    - Parse each string in `numbers`. For ranges like "A1:B3", iterate through all rows and columns in the range and increment their counts in the map.
    - Return the result of `get(row, col)`.
    - *Tạo một bản đồ công thức mới cho ô mục tiêu. Phân tích từng chuỗi trong `numbers`. Đối với các phạm vi như "A1:B3", hãy duyệt qua tất cả các hàng và cột trong phạm vi và tăng số đếm của chúng trong bản đồ. Trả về kết quả của `get(row, col)`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Recursion:** Since a sum cell can depend on another sum cell, recursive calls to `get` naturally handle deep dependency chains.
    * **Đệ quy:** Vì một ô tổng có thể phụ thuộc vào một ô tổng khác, các lệnh gọi đệ quy tới `get` sẽ xử lý các chuỗi phụ thuộc sâu một cách tự nhiên.*
*   **Formula Parsing:** Converting characters like 'A' to column indices (0-based) and parsing row numbers is crucial for correct indexing.
    * **Phân tích Công thức:** Việc chuyển đổi các ký tự như 'A' thành chỉ số cột và phân tích số hàng là rất quan trọng để lập chỉ mục chính xác.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `set`: $O(1)$.
    - `get`: $O(V + E)$ in the worst case (like a graph DFS), where $V$ is the number of cells and $E$ is the number of dependencies.
    - `sum`: $O(\text{RangeSize} + get)$.
    - *Độ phức tạp thời gian: `set` là $O(1)$, `get` là $O(V + E)$ trong trường hợp xấu nhất, `sum` tỷ lệ thuận với kích thước phạm vi cộng với lệnh `get`.*
*   **Space Complexity:** $O(V \times \text{AvgFormulaSize})$ to store formulas for all cells.
    * **Độ phức tạp không gian: $O(V \times \text{AvgFormulaSize})$ để lưu trữ công thức cho tất cả các ô.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Operation:** `sum(3, 'C', ["A1", "A1:B2"])`
1. Cell C3 stores a formula: {A1: 2, A2: 1, B1: 1, B2: 1}. (A1 appears once individually and once in the range).
2. `get(3, 'C')` calculates: 2*get(A1) + 1*get(A2) + 1*get(B1) + 1*get(B2).
3. If later `set(A1, 5)`, `get(C3)` will use 5 instead of the old value.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Spreadsheet logic is essentially a Directed Acyclic Graph (DAG) of calculations. For small-scale problems, lazy recursive evaluation is the simplest to implement. For large systems, one would use topological sorting and eager updates to maintain performance.
*Logic bảng tính về bản chất là một Đồ thị có hướng không chu trình (DAG) của các phép tính. Đối với các bài toán quy mô nhỏ, đánh giá đệ quy lười biếng là đơn giản nhất để triển khai. Đối với các hệ thống lớn, người ta sẽ sử dụng sắp xếp topo và cập nhật chủ động để duy trì hiệu suất.*
---
*Mọi kết quả (Cell value) đều là sự tổng hòa của những yếu tố nền tảng. Trong cấu trúc của Excel, một công thức (Formula) không chỉ là một con số, mà là một lời tuyên bố về sự phụ thuộc (Dependency). Dữ liệu dạy ta rằng khi cái gốc thay đổi, những gì được xây dựng dựa trên nó (Sum) cũng phải chuyển mình để giữ vững tính chính xác.*
Every result (Cell value) is the harmony of fundamental factors. In the structure of Excel, a formula (Formula) is not just a number, but a statement of dependency (Dependency). Data teaches us that when the root changes, what is built upon it (Sum) must also transform to maintain accuracy.
