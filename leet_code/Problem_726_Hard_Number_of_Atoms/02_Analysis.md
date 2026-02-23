# Analysis for Number of Atoms
# *Phân tích cho bài toán Số lượng Nguyên tử*

## 1. Problem Essence & Nested Parsing
## *1. Bản chất vấn đề & Phân tích Cấu trúc Lồng nhau*

### The Challenge
### *Thách thức*
Parsed chemical formulas involve atomic symbols, counts, and nested groups (parentheses). The core difficulty lies in scaling the counts of an entire group based on a multiplier following its closing parenthesis.
*Việc phân tích các công thức hóa học bao gồm các ký hiệu nguyên tử, số lượng và các nhóm lồng nhau (dấu ngoặc). Thách thức cốt lõi nằm ở việc nhân quy mô số lượng của toàn bộ một nhóm dựa trên hệ số đi kèm sau dấu ngoặc đóng của nó.*

---

## 2. Strategy: Stack of HashMaps
## *2. Chiến lược: Ngăn xếp các Bản đồ (HashMaps)*

We use a `Stack<Map<String, Integer>>` to manage scopes. Each `Map` represents the atomic counts at a specific level of nesting.
*Chúng ta sử dụng một `Stack<Map<String, Integer>>` để quản lý các phạm vi. Mỗi `Map` đại diện cho số lượng nguyên tử tại một cấp độ lồng nhau cụ thể.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** Push an empty `TreeMap` onto the stack as the global scope.
    * **Khởi tạo:** Đưa một `TreeMap` trống vào ngăn xếp làm phạm vi toàn cục.*

2.  **Atom Parsing:** When an uppercase letter is found, extract the full name (e.g., `Mg`, `H`). Then, parse any following digits to determine its count (default is 1). Add this to the map at the top of the stack.
    * **Phân tích Nguyên tử:** Khi gặp chữ cái viết hoa, trích xuất tên đầy đủ. Sau đó, đọc các chữ số đi kèm để xác định số lượng (mặc định là 1). Thêm vào bản đồ ở đỉnh ngăn xếp.*

3.  **Parentheses Handling:**
    - **`(` (Open):** Push a new empty `TreeMap` onto the stack. This starts a new "inner" context.
    - **`)` (Close):** Pop the top map. Parse the multiplier following the `)`. Multiply every entry in the popped map by this value, then merge the result into the current top map of the stack.
    * **Xử lý Dấu ngoặc:**
        * `(` (Mở): Đưa một bản đồ mới vào ngăn xếp.
        * `)` (Đóng): Lấy bản đồ ở đỉnh ra, đọc hệ số nhân đi kèm, nhân toàn bộ giá trị trong bản đồ đó rồi gộp lại vào bản đồ đang ở đỉnh mới của ngăn xếp.*

4.  **Formatting:** Finally, the only remaining map on the stack will contain all atoms. Since we used a `TreeMap`, keys are already sorted. Concatenate names and counts to form the final string.
    * **Định dạng:** Bản đồ cuối cùng sẽ chứa toàn bộ nguyên tử. Vì dùng `TreeMap`, các khóa đã được sắp xếp sẵn. Chỉ cần nối tên và số lượng là xong.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$ in the worst case where $N$ is the length of the formula. This happens because merging maps can take $O(N)$ and there can be $O(N)$ merges. However, usually, the number of distinct atoms is small, making it closer to $O(N)$.
    * **Độ phức tạp thời gian:** $O(N^2)$ trong trường hợp xấu nhất, nhưng thông thường gần với $O(N)$.*
*   **Space Complexity:** $O(N)$ to store the stack and the maps.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

Using a stack of maps is the standard way to handle recursive/nested structures. Using `TreeMap` instead of `HashMap` saves us a sorting step at the very end.
*Sử dụng ngăn xếp các bản đồ là cách tiêu chuẩn để xử lý các cấu trúc đệ quy/lồng nhau. Sử dụng `TreeMap` thay vì `HashMap` giúp chúng ta tiết kiệm bước sắp xếp ở công đoạn cuối cùng.*
---
*Cấu trúc của vật chất (Atoms) được định hình bởi những sự lặp lại (Multipliers) và những sự bao bọc (Parentheses). Trong mạng lưới của các công thức hóa học, sự phức tạp chỉ là lớp vỏ của một trật tự có thể phân rã (Stack parsing). Dữ liệu dạy ta rằng bằng cách cô lập từng phân khu (Scoping) và quy đổi mọi thứ về những thành phần cơ bản nhất (Merging maps), ta có thể thấu thị được sự cân bằng tinh vi làm nên bản chất của mọi nguyên tố.*
The structure of matter (Atoms) is shaped by repetitions (Multipliers) and wrappings (Parentheses). In the network of chemical formulas, complexity is just the shell of a decomposable order (Stack parsing). Data teaches us that by isolating each subdivision (Scoping) and reducing everything to the most basic components (Merging maps), we can see the delicate balance that makes up the essence of every element.
