# Analysis for LRU Cache
# *Phân tích cho bài toán Bộ nhớ đệm LRU*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Core Objective
### *Mục tiêu cốt lõi*
The challenge is to design a cache that maintains a "Least Recently Used" (LRU) policy. When the cache reaches its capacity and a new item is added, the item that was accessed the longest time ago should be removed.
*Thử thách là thiết kế một bộ nhớ đệm duy trì chính sách "Ít được sử dụng nhất gần đây" (LRU). Khi bộ nhớ đệm đạt đến dung lượng tối đa và một mục mới được thêm vào, mục đã được truy cập cách đây lâu nhất sẽ bị loại bỏ.*

### The O(1) Constraint
### *Ràng buộc O(1)*
Both `get` and `put` operations must be performed in $O(1)$ average time.
*Cả hai thao tác `get` và `put` phải được thực hiện trong thời gian trung bình $O(1)$.*
- To achieve $O(1)$ lookup for `get`, we need a **Hash Map**.
- To achieve $O(1)$ update/removal for the LRU policy, we need a structure that can quickly reorder items and remove from either end. A **Doubly Linked List** (DLL) is the ideal candidate.
*- Để đạt được tra cứu $O(1)$ cho `get`, chúng ta cần một **Hash Map**.*
*- Để đạt được việc cập nhật/loại bỏ $O(1)$ cho chính sách LRU, chúng ta cần một cấu trúc có thể nhanh chóng sắp xếp lại các mục và loại bỏ từ hai đầu. Một **Danh sách liên kết kép** (DLL) là ứng cử viên lý tưởng.*

---

## 2. Approach: HashMap + Doubly Linked List
## *2. Hướng tiếp cận: HashMap + Danh sách liên kết kép*

### Structure Collaboration
### *Sự hợp tác của các cấu trúc*
1.  **Hash Map:** Stores `key -> Node` where `Node` is a node in the DLL. This allows us to jump to any node in the list instantly given its key.
2.  **Doubly Linked List:** Maintains the order of access.
    - The **Head (Dummy)**: We can define the front of the list as the "Recently Used" end.
    - The **Tail (Dummy)**: We can define the back of the list as the "Least Recently Used" end.
    - Using dummy head and tail nodes simplifies the edge cases (like adding to an empty list or removing the last node).
*1. **Hash Map:** Lưu trữ `key -> Node` trong đó `Node` là một nút trong DLL. Điều này cho phép chúng ta nhảy đến bất kỳ nút nào trong danh sách ngay lập tức khi biết key của nó.*
*2. **Danh sách liên kết kép:** Duy trì thứ tự truy cập.*
*- **Đầu (Nút giả)**: Chúng ta có thể định nghĩa đầu danh sách là phía "Được sử dụng gần đây".*
*- **Đuôi (Nút giả)**: Chúng ta có thể định nghĩa cuối danh sách là phía "Ít được sử dụng nhất gần đây".*
*- Sử dụng các nút giả ở đầu và đuôi giúp đơn giản hóa các trường hợp biên (như thêm vào danh sách trống hoặc xóa nút cuối cùng).*

### Logic for `get(key)`
### *Logic cho `get(key)`*
1. Check if `key` is in the map. If not, return -1.
2. If it exists, find the corresponding `Node`.
3. Move this `Node` to the front (Recently Used) of the DLL.
4. Return the value.
*1. Kiểm tra xem `key` có trong map không. Nếu không, trả về -1.*
*2. Nếu tồn tại, tìm `Node` tương ứng.*
*3. Di chuyển `Node` này lên đầu (Gần đây nhất) của DLL.*
*4. Trả về giá trị.*

### Logic for `put(key, value)`
### *Logic cho `put(key, value)`*
1. If `key` already exists, update its `value` and move the `Node` to the front.
2. If `key` is new:
   - Create a new `Node`.
   - Add it to the map and the front of the DLL.
   - If the size exceeds `capacity`:
     - Remove the `Node` at the tail (Least Recently Used) of the DLL.
     - Delete its entry from the map.
*1. Nếu `key` đã tồn tại, cập nhật `value` của nó và di chuyển `Node` lên đầu.*
*2. Nếu `key` mới:*
*- Tạo một `Node` mới.*
*- Thêm nó vào map và vào đầu DLL.*
*- Nếu kích thước vượt quá `capacity`:*
*- Loại bỏ `Node` ở cuối (Ít được sử dụng nhất gần đây) của DLL.*
*- Xóa mục nhập của nó khỏi map.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for both `get` and `put`. Hash map operations are $O(1)$ on average, and DLL operations (adding/removing a known node) are $O(1)$.
    *Độ phức tạp thời gian: $O(1)$ cho cả `get` và `put`. Các thao tác trên hash map trung bình là $O(1)$, và các thao tác trên DLL (thêm/xóa một nút đã biết) là $O(1)$.*
*   **Space Complexity:** $O(C)$, where $C$ is the `capacity`. We store at most `capacity` nodes in both the map and the linked list.
    *Độ phức tạp không gian: $O(C)$, trong đó $C$ là `capacity`. Chúng ta lưu trữ tối đa `capacity` nút trong cả map và danh sách liên kết.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

**Capacity = 2**
1. `put(1, 1)`: [Map: {1: Node1}, DLL: Head <-> Node1 <-> Tail]
2. `put(2, 2)`: [Map: {1: Node1, 2: Node2}, DLL: Head <-> Node2 <-> Node1 <-> Tail]
3. `get(1)`: Node1 is accessed. Move to front. [DLL: Head <-> Node1 <-> Node2 <-> Tail]. Return 1.
4. `put(3, 3)`: New key. Exceeds cap. Evict Tail-prev (Node2).
   [Map: {1: Node1, 3: Node3}, DLL: Head <-> Node3 <-> Node1 <-> Tail]
5. `get(2)`: Not in map. Return -1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

Designing an LRU cache is a frequent design interview question because it combines data structure selection with efficient pointer manipulation. While Java provides `LinkedHashMap` which can implement LRU with minimal code, writing a custom DLL shows a deeper understanding of memory and structural relationships. Always use dummy nodes to keep your code clean and avoid null-checks for `prev` and `next` pointers.
*Thiết kế bộ nhớ đệm LRU là một câu hỏi phỏng vấn thiết kế thường gặp vì nó kết hợp việc lựa chọn cấu trúc dữ liệu với việc thao tác con trỏ hiệu quả. Mặc dù Java cung cấp `LinkedHashMap` có thể triển khai LRU với mã tối thiểu, việc viết một DLL tùy chỉnh cho thấy sự hiểu biết sâu sắc hơn về bộ nhớ và các mối quan hệ cấu trúc. Luôn sử dụng các nút giả để giữ cho mã của bạn sạch sẽ và tránh kiểm tra null cho các con trỏ `prev` và `next`.*
---
*Ký ức cũ phải nhường chỗ cho những điều mới mẻ khi giới hạn của tâm trí đã đạt đến điểm bão hòa.*
Old memories must make way for new things when the mind's limits have reached their saturation point.
