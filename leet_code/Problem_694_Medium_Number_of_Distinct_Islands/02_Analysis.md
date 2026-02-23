# Analysis for Number of Distinct Islands
# *Phân tích cho bài toán Số lượng Đảo phân biệt*

## 1. Problem Essence & Local Coordinate Invariance
## *1. Bản chất vấn đề & Tính bất biến của Tọa độ Cục bộ*

### The Challenge
### *Thách thức*
We need to identify the "shape" of each island. Two islands have the same shape if they are identical under translation. This means if we "normalized" the coordinates of every cell in an island by subtracting the top-left-most coordinate, identical islands would produce the same set of relative points.
*Chúng mã hóa "hình dạng" của từng hòn đảo. Hai hòn đảo có cùng hình dạng nếu chúng giống hệt nhau sau khi tịnh tiến. Điều này có nghĩa là nếu ta "chuẩn hóa" tọa độ bằng cách trừ đi tọa độ bắt đầu, các đảo giống nhau sẽ cho ra cùng một tập hợp điểm tương đối.*

---

## 2. Strategy: DFS with Path Encoding
## *2. Chiến lược: DFS với Mã hóa Đường đi*

A robust way to capture a shape is to record the sequence of moves made during a DFS traversal.
*Một cách mạnh mẽ để ghi lại hình dạng là ghi lại chuỗi các bước di chuyển trong quá trình duyệt DFS.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Traverse the Grid:** Iterate through the grid. When a `1` is found, start a DFS.
    * **Duyệt lưới:** Khi tìm thấy `1`, bắt đầu DFS.*

2.  **DFS with Signature:** 
    - At each step of DFS, record the direction taken: `r` (right), `l` (left), `u` (up), `d` (down).
    - **Crucial Nuance:** After visiting a neighbor and returning, also record a `b` (backtrack) or some other marker. This distinguishes shapes that have the same order of branches but different structures.
    * **DFS với Chữ ký:** Tại mỗi bước, ghi lại hướng di chuyển. Sau khi quay lại từ một nhánh, ghi lại ký hiệu "quay lui" (backtrack). Điều này cực kỳ quan trọng để phân biệt các hình dạng khác nhau.*

3.  **Collect Unique Shapes:** Store these "path strings" in a `HashSet`.
    * **Thu thập Hình dạng:** Lưu trữ các "chuỗi đường đi" này vào một tập hợp `HashSet`.*

4.  **Result:** The number of elements in the `HashSet` is the number of distinct islands.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Canonical Path:** Path serialization is a canonical way to represent a tree/shape. The "backtrack" marker ensures that we capture the tree structure formed by DFS correctly.
    * **Đường đi Chuẩn tắc:** Phân hóa chuỗi đường đi là cách chuẩn để đại diện cho một hình dạng. Dấu mốc "quay lui" đảm bảo ta bắt được cấu trúc cây của DFS.*
*   **Scale:** Since the grid size is small ($50 \times 50$), storing these strings in a set is efficient.
    * **Quy mô:** Với lưới nhỏ, việc lưu các chuỗi này là hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M, N$ are grid dimensions. Each cell is visited once.
    * **Độ phức tạp thời gian:** $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ to store the visited cells and the set of unique paths.
    * **Độ phức tạp không gian:** $O(M \times N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Example:**
Island 1: (0,0), (0,1), (1,0)
1. DFS starts at (0,0).
2. Move Right: (0,0) -> (0,1). Path: `r`.
3. Backtrack: Path: `rb`.
4. Move Down: (0,0) -> (1,0). Path: `rbd`.
5. Backtrack: Path: `rbdb`.
Signature: `rbdb`.

Any other L-shaped island starting at a different position will yield the exact same `rbdb` signature.
**Result:** 1 unique shape.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When capturing shapes in a grid, path-encoding is a powerful alternative to relative coordinate sets. Always remember the "backtrack" marker in path serialization to maintain the correct structural topology of the traversal.
*Khi ghi lại hình dạng, mã hóa đường đi là một lựa chọn tuyệt vời. Luôn nhớ thêm ký hiệu "quay lui" để giữ đúng cấu trúc topo của quá trình duyệt.*
---
*Hình dạng của mặt đất (Islands) không chỉ được xác định bởi vị trí tuyệt đối, mà bởi nhịp điệu của sự di chuyển (Path). Trong mê cung của các ô vuông (Grid), bí mật của sự tương đồng nằm ở những bước chân ta đã đi qua. Dữ liệu dạy ta rằng bằng cách lắng nghe từng hướng rẽ (Direction) và từng khoảnh khắc trở về (Backtrack), ta có thể nhận diện được bản chất duy nhất của mọi cấu trúc giữa đại dương rộng lớn.*
The shape of the ground (Islands) is not only determined by absolute position, but by the rhythm of movement (Path). In the labyrinth of squares (Grid), the secret of similarity lies in the steps we have taken. Data teaches us that by listening to every turn (Direction) and every moment of return (Backtrack), we can identify the unique nature of every structure in the vast ocean.
