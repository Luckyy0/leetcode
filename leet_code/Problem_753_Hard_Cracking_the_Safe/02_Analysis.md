# Analysis for Cracking the Safe
# *Phân tích cho bài toán Phá két sắt*

## 1. Problem Essence & De Bruijn Sequence
## *1. Bản chất vấn đề & Chuỗi De Bruijn*

### The Challenge
### *Thách thức*
We need to construct a string that contains every possible combination of length $n$ (using digits $0 \dots k-1$) as a substring. Since substrings overlap, the optimal string reuses the last $n-1$ characters of the previous substring as the first $n-1$ characters of the next one. This is exactly the definition of a **De Bruijn Sequence**.
*Chúng ta cần xây dựng một chuỗi chứa mọi tổ hợp độ dài $n$ (sử dụng các chữ số $0 \dots k-1$) dưới dạng chuỗi con. Vì các chuỗi con chồng lên nhau, chuỗi tối ưu sẽ tái sử dụng $n-1$ ký tự cuối của chuỗi con trước đó làm $n-1$ ký tự đầu của chuỗi con tiếp theo. Đây chính xác là định nghĩa của **Chuỗi De Bruijn**.*

### Graph Modeling
### *Mô hình hóa Đồ thị*
Construct a directed graph where:
- **Nodes** are strings of length $n-1$ (representing the prefix context).
- **Edges** represent adding a digit (0 to $k-1$). Transitioning from node `u` via edge `d` leads to node `v` where `v` is the suffix of `u + d`.
- A Hamilton Path on a graph of nodes with length $n$, OR an **Eulerian Path** on a graph of nodes with length $n-1$.
Using nodes of length $n-1$ allows us to model this as finding an Eulerian circuit (visiting every edge exactly once), since every edge corresponds to a unique $n$-length sequence.
*Xây dựng đồ thị có hướng: **Nút** là các chuỗi độ dài $n-1$. **Cạnh** đại diện cho việc thêm một chữ số. Việc tìm chuỗi De Bruijn tương đương với tìm **Chu trình Euler** trên đồ thị này (đi qua mỗi cạnh đúng một lần).*

---

## 2. Strategy: Hierholzer's Algorithm (DFS)
## *2. Chiến lược: Thuật toán Hierholzer (DFS)*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Start Node:** Start with a string of $n-1$ zeros (e.g., if $n=2$, node is "0").
    *   **Nút bắt đầu:** Bắt đầu với chuỗi $n-1$ số 0.*

2.  **DFS Traversal:**
    - From the current node `curr` (string of length $n-1$):
    - Try to add digit `x` from $0 \to k-1$.
    - The edge represents the sequence `curr + x`.
    - If this edge hasn't been visited, mark it as visited and recursively visit the next node (suffix of `curr + x`).
    - **Post-order append:** Upon returning from recursion, append the digit `x` to the result buffer. Hierholzer's algorithm builds the path in reverse order.
    *   **Duyệt DFS:** Từ nút hiện tại, thử thêm các chữ số. Nếu cạnh chưa thăm, đánh dấu và đệ quy đến nút tiếp theo. Khi quay lui từ đệ quy, thêm chữ số vào bộ đệm kết quả.*

3.  **Initialization:** The final result needs the starting prefix (the node itself, $n-1$ zeros) to "prime" the sequence.
    *   **Khởi tạo:** Kết quả cuối cùng cần cộng thêm phần tiền tố ban đầu để hoàn chỉnh chuỗi.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(k^n)$. We visit every edge exactly once. Total edges = number of combinations = $k^n$.
    *   **Độ phức tạp thời gian:** $O(k^n)$.*
*   **Space Complexity:** $O(k^n)$ to store the visited edges and the recursion stack.
    *   **Độ phức tạp không gian:** $O(k^n)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**n=2, k=2. Start node "0"**
1. DFS("0").
   - Try edge '1': Next node "1" (suffix of "01").
     - DFS("1").
       - Try edge '1': Next node "1" (suffix of "11").
         - DFS("1"). Edge '1' visited. Try '0'.
         - Try edge '0': Next node "0" (suffix of "10").
           - DFS("0"). Edge '1' visited. Edge '0' visited from "1"?? No, from "0". Wait.
           - We need a global visited set.
           - ... Eventually path traces 00->01->11->10...
   - Post-order append helps resolve stuck paths by adding them to the end of the partial circuit.

Result typically: `00110` (or similar depending on traversal order).

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Hierholzer's algorithm is the most efficient way to generate De Bruijn sequences. Using a `Set<String>` to track visited edges (or `Set<Integer>` using hashing) is standard.
*Thuật toán Hierholzer là cách hiệu quả nhất để tạo chuỗi De Bruijn. Sử dụng `Set` để theo dõi các cạnh đã thăm là phương pháp chuẩn.*
---
*Mỗi cánh cửa đóng kín (Safe) đều ẩn chứa một quy luật tuần hoàn. Để mở khóa tất cả các khả năng (Combinations) mà không lãng phí bước đi nào, ta phải tìm ra sợi dây liên kết vô hình (Eulerian Path) nối liền điểm cuối của quá khứ với điểm đầu của tương lai. Dữ liệu dạy ta rằng trong một thế giới liên thông chặt chẽ (Connected graph), mọi con đường đều có thể quay về điểm xuất phát (Circuit) nếu ta biết cách đi hết các cạnh của nó.*
Every closed door (Safe) conceals a cyclic rule. To unlock all possibilities (Combinations) without wasting a step, we must find the invisible thread (Eulerian Path) connecting the end of the past with the beginning of the future. Data teaches us that in a tightly connected world (Connected graph), every path can return to the start (Circuit) if we know how to traverse all its edges.
