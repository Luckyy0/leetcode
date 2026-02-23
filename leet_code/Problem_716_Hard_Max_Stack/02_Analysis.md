# Analysis for Max Stack
# *Phân tích cho bài toán Ngăn xếp Cực đại*

## 1. Problem Essence & Multi-Dimensional Access
## *1. Bản chất vấn đề & Truy cập Đa chiều*

### The Challenge
### *Thách thức*
A standard stack provides LIFO (Last-In-First-Out) access. However, `popMax` requires finding and removing the maximum element regardless of its position. If we use two stacks (the common trick for `peekMax`), `popMax` becomes $O(N)$ because we have to rebuild the stack. To achieve $O(\log N)$, we need a structure that tracks both stack order and value-based order.
*Một ngăn xếp tiêu chuẩn cung cấp quyền truy cập LIFO. Tuy nhiên, `popMax` yêu cầu tìm và xóa phần tử lớn nhất bất kể vị trí của nó. Nếu dùng hai ngăn xếp, `popMax` sẽ tốn $O(N)$. Để đạt $O(\log N)$, ta cần một cấu trúc theo dõi cả thứ tự ngăn xếp và thứ tự giá trị.*

---

## 2. Strategy: Doubly Linked List + TreeMap
## *2. Chiến lược: Danh sách Liên kết Kép + TreeMap*

We combine two data structures:
1.  **Doubly Linked List (DLL):** Stores elements in the order they were pushed. This handles `top`, `push`, and `pop` in $O(1)$.
2.  **TreeMap<Integer, List<Node>>:** Maps each value to a list of nodes in the DLL that contain that value. This handles `peekMax` and `popMax` in $O(\log N)$.

### Step-by-Step Logic
### *Logic từng bước*

1.  **push(x):**
    - Add a new node with value `x` to the end of the DLL.
    - Store the node reference in the `TreeMap` under key `x`.
    * **Thêm phần tử:** Thêm nút vào cuối danh sách liên kết kép và lưu tham chiếu vào TreeMap.*

2.  **pop():**
    - Remove the tail node of the DLL.
    - Remove this node's reference from the `TreeMap`.
    * **Lấy phần tử trên cùng:** Xóa nút cuối trong danh sách và xóa trong TreeMap.*

3.  **peekMax():**
    - Return `treeMap.lastKey()`.
    * **Xem giá trị lớn nhất:** Lấy khóa lớn nhất từ TreeMap.*

4.  **popMax():**
    - Get the list of nodes for `treeMap.lastKey()`.
    - Pick the **last** node in that list (the one pushed most recently).
    - Remove it from the DLL and the `TreeMap`.
    * **Xóa giá trị lớn nhất:** Lấy nút cuối cùng trong danh sách các nút có giá trị lớn nhất, xóa nó khỏi danh sách liên kết và TreeMap.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Logarithmic Efficiency:** By using a `TreeMap`, all operations related to the maximum value are $O(\log N)$ instead of $O(N)$.
    * **Hiệu suất Logarit:** Sử dụng TreeMap giúp các thao tác cực đại đạt $O(\log N)$.*
*   **Doubly Linked List:** Necessary because `popMax` might remove an element from the middle of the stack. A DLL allows $O(1)$ removal if we have the node reference.
    * **Danh sách Liên kết Kép:** Cần thiết vì `popMax` có thể xóa ở giữa ngăn xếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `top`, `peekMax`: $O(1)$ or $O(\log N)$ (TreeMap access).
    - `push`, `pop`, `popMax`: $O(\log N)$ due to TreeMap updates.
    * **Độ phức tạp thời gian:** $O(\log N)$ cho mọi thao tác cập nhật.*
*   **Space Complexity:** $O(N)$ to store all nodes in both structures.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

When you need to access a collection by two different "sorting" orders (insertion order vs value order), combining a Linked List with a Map/Heap is the standard design pattern.
*Khi cần truy cập một bộ sưu tập theo hai thứ tự khác nhau (thứ tự chèn và thứ tự giá trị), việc kết hợp Danh sách liên kết với Map/Heap là mô hình thiết kế chuẩn mực.*
---
*Ngăn xếp (Stack) là dòng thời gian của những sự kiện chồng chất. Trong mê cung của các giá trị, việc tìm kiếm đỉnh cao nhất (Max) yêu cầu một cái nhìn vượt lên trên thứ tự thời gian. Dữ liệu dạy ta rằng bằng cách kết nối các khoảnh khắc (Linked List) và lập chỉ mục cho sức mạnh (TreeMap), ta có thể can thiệp vào quá khứ (PopMax) mà không phá vỡ cấu trúc của hiện tại.*
A stack (Stack) is a timeline of accumulated events. In the labyrinth of values, searching for the highest peak (Max) requires a perspective beyond chronological order. Data teaches us that by connecting moments (Linked List) and indexing strength (TreeMap), we can intervene in the past (PopMax) without breaking the structure of the present.
