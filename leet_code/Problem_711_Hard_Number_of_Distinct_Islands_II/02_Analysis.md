# Analysis for Number of Distinct Islands II
# *Phân tích cho bài toán Số lượng Đảo phân biệt II*

## 1. Problem Essence & Rotational Symmetry
## *1. Bản chất vấn đề & Tính Đối xứng Quay*

### The Challenge
### *Thách thức*
In this variation, two islands are considered identical if they have the same shape under **translation, rotation (90, 180, 270 degrees), or reflection (horizontal, vertical, diagonal)**. This means for each found island, we must generate all 8 possible symmetries and find a way to represent them uniquely.
*Trong biến thể này, hai hòn đảo được coi là giống nhau nếu chúng có cùng hình dạng sau khi **tịnh tiến, xoay (90, 180, 270 độ), hoặc lật (ngang, dọc, chéo)**. Điều này có nghĩa là với mỗi hòn đảo, ta phải tạo ra cả 8 hình dạng đối xứng và tìm cách biểu diễn chúng một cách duy nhất.*

---

## 2. Strategy: Canonical Form Generation
## *2. Chiến lược: Tạo Hình dạng Chuẩn tắc*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Extract Island:** Use DFS or BFS to get the list of coordinates $(x, y)$ for each island.
    * **Trích xuất Đảo:** Sử dụng DFS hoặc BFS để lấy danh sách tọa độ $(x, y)$ của từng hòn đảo.*

2.  **Generate 8 Symmetries:** For a point $(x, y)$, the 8 symmetric points are:
    - $(x, y), (x, -y), (-x, y), (-x, -y)$
    - $(y, x), (y, -x), (-y, x), (-y, -x)$
    * **Tạo 8 Đối xứng:** Với mỗi điểm $(x, y)$, ta tạo ra 8 điểm đối xứng qua các trục.*

3.  **Normalize Each Symmetry:**
    - For a set of points in a specific symmetry, find the minimum $x$ ($min\_x$) and minimum $y$ ($min\_y$).
    - Subtract $(min\_x, min\_y)$ from every point to "shift" the shape to the origin $(0,0)$.
    - Sort the points in each set.
    * **Chuẩn hóa từng Đối xứng:** Tìm tọa độ nhỏ nhất của bộ điểm để tịnh tiến hình dạng về gốc $(0,0)$, sau đó sắp xếp các điểm.*

4.  **Find the Canonical Key:**
    - Convert each of the 8 normalized point sets into a unique string.
    - Sort these 8 strings and pick the lexicographically smallest one as the **Canonical Key** for the island.
    * **Tìm Khóa Chuẩn tắc:** Chuyển 8 bộ điểm đã chuẩn hóa thành chuỗi, sau đó chọn chuỗi nhỏ nhất theo thứ tự từ điển làm khóa đại diện.*

5.  **Set Matching:** Store all canonical keys in a `HashSet` and return its size.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N \times \log(M \times N))$. We visit each cell, and for each island, we sort its points (up to 8 times).
    * **Độ phức tạp thời gian:** $O(M \times N \times \log(M \times N))$.*
*   **Space Complexity:** $O(M \times N)$ to store visited cells and island shapes.
    * **Độ phức tạp không gian:** $O(M \times N)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

The key to symmetry problems is **Normalization**. By shifting every possible view of a shape to the origin and picking the "smallest" view, we effectively ignore translation, rotation, and reflection.
*Chìa khóa của các bài toán đối xứng là **Chuẩn hóa**. Bằng cách tịnh tiến mọi góc nhìn về gốc tọa độ và chọn góc nhìn "nhỏ nhất", ta có thể bỏ qua mọi phép biến đổi hình học.*
---
*Hình dạng của một thực thể không thay đổi khi ta thay đổi góc nhìn (Rotation) hay soi gương (Reflection). Trong thế giới của các ô vuông (Grid), bản chất của một hòn đảo (Island) nằm ở sự sắp xếp tương đối giữa các phần tử. Dữ liệu dạy ta rằng bằng cách thử nghiệm mọi góc độ (8 symmetries) và đưa tất cả về một hệ quy chiếu chung (Origin), ta có thể nhận diện được sự đồng nhất thực sự đằng sau mọi lớp vỏ bọc hình học.*
The shape of an entity does not change when we change the perspective (Rotation) or mirror it (Reflection). In the world of squares (Grid), the essence of an island (Island) lies in the relative arrangement of elements. Data teaches us that by testing every angle (8 symmetries) and bringing them all to a common reference system (Origin), we can identify true identity behind every geometric shell.
