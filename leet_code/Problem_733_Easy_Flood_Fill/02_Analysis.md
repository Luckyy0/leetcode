# Analysis for Flood Fill
# *Phân tích cho bài toán Đổ màu (Flood Fill)*

## 1. Problem Essence & Recursive Expansion
## *1. Bản chất vấn đề & Sự lan tỏa Đệ quy*

### The Challenge
### *Thách thức*
We need to change the color of a connected component in a grid. This is the exact algorithm used by the "Paint Bucket" tool in image editing software. We start from a single point and "spread" the new color to all adjacent pixels that share the initial color.
*Chúng ta cần thay đổi màu sắc của một tập hợp các điểm ảnh kết nối với nhau trong lưới. Đây chính là thuật toán được sử dụng bởi công cụ "Thùng sơn" trong các phần mềm chỉnh sửa ảnh. Ta bắt đầu từ một điểm và "lan tỏa" màu mới đến tất cả các điểm lân cận có cùng màu ban đầu.*

---

## 2. Strategy: Depth-First Search (DFS)
## *2. Chiến lược: Tìm kiếm theo Chiều sâu (DFS)*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Capture Initial State:** Store the original color of the starting pixel `image[sr][sc]`.
    * **Ghi lại Trạng thái Ban đầu:** Lưu lại màu nguyên bản của điểm xuất phát.*

2.  **Edge Case Prevention:** If the `newColor` is the same as the original color, return the image immediately. This prevents an infinite loop of re-coloring the same pixels.
    * **Ngăn chặn Trường hợp Biên:** Nếu màu mới giống hệt màu cũ, ta kết thúc ngay để tránh vòng lặp vô tận.*

3.  **Recursive Spreading (DFS):**
    - Check if the current pixel `(r, c)` is within the grid boundaries.
    - Check if the pixel has the original color.
    - If both conditions are met:
        - Change its color to `newColor`.
        - Recursively call the function for its 4 neighbors (Up, Down, Left, Right).
    * **Lan tỏa Đệ quy (DFS):** Kiểm tra xem điểm hiện tại có hợp lệ và có cùng màu cũ hay không. Nếu có, đổi sang màu mới và tiếp tục gọi đệ quy cho 4 hướng lân cận.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot M)$, where $N$ and $M$ are the dimensions of the grid. Each pixel is visited at most once.
    * **Độ phức tạp thời gian:** $O(N \cdot M)$.*
*   **Space Complexity:** $O(N \cdot M)$ for the recursion stack in the worst case (a long narrow path).
    * **Độ phức tạp không gian:** $O(N \cdot M)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**image = [[1, 1], [1, 0]], sr = 0, sc = 0, new = 2**
1. (0,0) is color 1. Change to 2. Call neighbors (0,1) and (1,0).
2. (0,1) is color 1. Change to 2.
3. (1,0) is color 1. Change to 2.
4. Neighbors of (0,1) and (1,0) that are (1,1) have color 0. Skip.
**Result:** [[2, 2], [2, 0]]

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

DFS is highly efficient and clean for flood fill operations on small to medium grids. For very large images where recursion depth might exceed the stack limit, an **explicit stack or queue (BFS)** should be used instead.
*DFS cực kỳ hiệu quả và gọn gàng cho việc đổ màu trong các lưới vừa và nhỏ. Với các ảnh cực lớn có thể gây tràn bộ nhớ đệm (stack overflow), ta nên sử dụng ngăn xếp thủ công hoặc hàng đợi (BFS).*
---
*Sự lan tỏa (Diffusion) trong một chiều không gian hữu hạn được dẫn dắt bởi sự tương đồng (Color match). Từ một điểm khởi đầu đơn lẻ, một ý niệm mới (New color) sẽ thấm đẫm mọi ngóc ngách thuộc về cùng một bản chất. Dữ liệu dạy ta rằng bằng cách xác định ranh giới vững chắc (Boundary checks) và kiên trì trong việc truyền đạt (Recursion), ta có thể biến đổi toàn bộ một cấu trúc liên thông mà không bỏ sót bất kỳ một mắt xích nào.*
Diffusion (Diffusion) in a finite spatial dimension is guided by similarity (Color match). From a single starting point, a new concept (New color) will permeate every corner belonging to the same nature. Data teaches us that by defining solid boundaries (Boundary checks) and being persistent in communication (Recursion), we can transform an entire interconnected structure without missing any link.
