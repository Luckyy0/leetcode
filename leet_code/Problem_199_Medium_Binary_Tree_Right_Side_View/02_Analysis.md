# Analysis for Binary Tree Right Side View
# *Phân tích cho bài toán Góc nhìn bên phải của cây nhị phân*

## 1. Problem Essence & Perception
## *1. Bản chất vấn đề & Nhận thức*

### What is the "Right Side"?
### *Thế nào là "Bên phải"?*
The "Right Side View" essentially asks for the **last node** encountered in each level of the tree (from top to bottom).
*Góc nhìn bên phải thực chất là yêu cầu tìm **nút cuối cùng** gặp được trong mỗi tầng của cây (từ trên xuống dưới).*

Even if a node is technically a "left child", if the "right child" at that level is missing, the "left child" becomes visible from the right side.
*Ngay cả khi một nút về mặt kỹ thuật là "con bên trái", nếu "con bên phải" ở tầng đó bị thiếu, thì "con bên trái" sẽ trở nên nhìn thấy được từ phía bên phải.*

---

## 2. Approach 1: BFS (Level Order Traversal)
## *2. Hướng tiếp cận 1: BFS (Duyệt theo tầng)*

### Logic
### *Logic*
This is the most intuitive approach.
1.  Use a Queue to perform BFS.
2.  At each level, iterate through all nodes currently in the queue.
3.  The **last node** processed in the loop for that level is the one visible from the right. Add it to the result list.
*Đây là cách tiếp cận trực quan nhất. 1. Sử dụng Hàng đợi để BFS. 2. Tại mỗi tầng, duyệt qua tất cả các nút. 3. **Nút cuối cùng** được xử lý trong vòng lặp tầng đó là nút nhìn thấy từ bên phải.*

---

## 3. Approach 2: DFS (Smart Traversal)
## *3. Hướng tiếp cận 2: DFS (Duyệt thông minh)*

### Logic
### *Logic*
We can use recursion `DFS(node, level)`.
If we visit the **right child first** before the left child, then for every level, the first node we encounter is guaranteed to be the rightmost visible node.
*Chúng ta có thể sử dụng đệ quy `DFS(node, level)`. Nếu chúng ta thăm **con bên phải trước** con bên trái, thì với mỗi tầng, nút đầu tiên chúng ta gặp đảm bảo là nút ngoài cùng bên phải.*

1.  Maintain a `List` of results.
2.  When visiting a node at `level`, check if `level == result.size()`.
    - If true, it means this is the first time we've reached this depth. Add the node to `result`.
    - If false, we've already added a node for this level (which came from the right side), so ignore subsequent nodes at this level.
3.  Recursively call `Right` then `Left`.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Both BFS and DFS visit every node exactly once.
    *Độ phức tạp thời gian: $O(N)$. Cả BFS và DFS đều thăm mỗi nút đúng một lần.*
*   **Space Complexity:** 
    - BFS: $O(W)$ where $W$ is the max width of the tree (leaves).
    - DFS: $O(H)$ where $H$ is the height of the tree (stack depth).
    *Độ phức tạp không gian: BFS tốn $O(W)$, DFS tốn $O(H)$.*

---

## 5. Visualized Dry Run (DFS Right-First)
## *5. Chạy thử bằng hình ảnh (DFS Phải-Trước)*

**Tree:** `1 -> (Left: 2 -> Right: 5), (Right: 3 -> nothing)`

1.  `DFS(1, 0)`. `Res` size 0. `0 == 0`. Add 1. `Res: [1]`.
2.  Go Right -> `DFS(3, 1)`. `Res` size 1. `1 == 1`. Add 3. `Res: [1, 3]`.
3.  Go Right -> `null`.
4.  Go Left -> `null`.
5.  Back to 1. Go Left -> `DFS(2, 1)`. `Res` size 2. `1 != 2`. Do nothing.
6.  Go Right -> `DFS(5, 2)`. `Res` size 2. `2 == 2`. Add 5. `Res: [1, 3, 5]`.

**Result:** `[1, 3, 5]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Both BFS and DFS are excellent here. BFS maps naturally to the definition ("last of level"). DFS maps naturally to a clever implementation ("first of level from right"). In an interview, DFS is often slightly faster to implement because you don't need to manage the Queue and nested loops manually.
*Cả BFS và DFS đều xuất sắc ở đây. BFS khớp tự nhiên với định nghĩa ("cuối cùng của tầng"). DFS khớp với một cách triển khai thông minh ("đầu tiên của tầng từ bên phải"). Trong phỏng vấn, DFS thường nhanh hơn một chút để viết vì bạn không cần quản lý Hàng đợi thủ công.*
---
*Góc nhìn quyết định tất cả. Đôi khi chỉ cần thay đổi thứ tự ưu tiên (phải trước trái), những điều bị che khuất sẽ hiện ra rõ ràng.*
Perspective determines everything. Sometimes just by changing priority (right before left), hidden things become clear.
