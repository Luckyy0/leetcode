# Analysis for Map Sum Pairs
# *Phân tích cho bài toán Tổng các cặp trong Bản đồ*

## 1. Problem Essence & Prefix Accumulation
## *1. Bản chất vấn đề & Tích lũy Tiền tố*

### The Challenge
### *Thách thức*
We need to manage a set of string keys and their associated integer values. The primary operation is to retrieve the sum of all values whose keys start with a specific prefix.
*Chúng ta cần quản lý một tập hợp các khóa chuỗi và các giá trị nguyên liên quan của chúng. Thao tác chính là lấy tổng của tất cả các giá trị mà khóa của chúng bắt đầu bằng một tiền tố cụ thể.*

---

## 2. Strategy: Trie with Value Augmentation
## *2. Chiến lược: Trie với Tăng cường Giá trị*

A **Trie (Prefix Tree)** is the ideal data structure for prefix-based searches. By augmenting each node in the Trie with a `sum` value, we can answer queries instantly.
*Một **Trie (Cây tiền tố)** là cấu trúc dữ liệu lý tưởng cho các tìm kiếm dựa trên tiền tố. Bằng cách tăng cường cho mỗi nút trong Trie một giá trị `sum`, chúng ta có thể trả lời các truy vấn ngay lập tức.*

### Handling Overwrites (The Key Nuance)
### *Xử lý Ghi đè (Sắc thái quan trọng)*

When a key is re-inserted with a new value, we must adjust the sums along its path.
*Khi một khóa được chèn lại với giá trị mới, chúng ta phải điều chỉnh các tổng số dọc theo đường đi của nó.*

1.  **Old Value Tracking:** Use a separate `HashMap<String, Integer>` to store the exact value of each key.
    * **Theo dõi Giá trị Cũ:** Sử dụng một `HashMap` riêng để lưu trữ giá trị chính xác của từng khóa.*
2.  **Calculate Delta:** `delta = newValue - oldValue`.
    * **Tính toán độ lệch:** `delta = giá trị_mới - giá trị_cũ`.*
3.  **Update Path:** Traverse the Trie for the given `key`. At each node, `node.sum += delta`.
    * **Cập nhật Đường đi:** Duyệt qua Trie cho `key` đã cho. Tại mỗi nút, cộng thêm `delta` vào `sum` của nút.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **`insert(key, val)`:**
    - Find `delta` using the `HashMap`.
    - Iterate through characters of `key`, creating nodes as needed.
    - Update `sum` at each node on the path.
2.  **`sum(prefix)`:**
    - Traverse the Trie following `prefix`.
    - If any character node is missing, return `0`.
    - Otherwise, return the `sum` stored at the node of the last character of `prefix`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Instant Sums:** Traditional Trie search for a prefix would require a DFS to sum all child values. By storing a running sum, `sum(prefix)` becomes $O(L)$ where $L$ is the prefix length.
    * **Tổng số tức thì:** Thay vì phải duyệt cây con để tính tổng, việc lưu trữ sẵn tổng giúp truy vấn đạt độ phức tạp $O(L)$.*
*   **Efficiency:** For $N$ keys and length $L$, the space is $O(N \times L)$, but the search speed is decoupled from the number of keys.
    * **Hiệu suất:** Tốc độ tìm kiếm độc lập với số lượng khóa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `insert`: $O(L)$, where $L$ is the key length.
    - `sum`: $O(P)$, where $P$ is the prefix length.
    * **Độ phức tạp thời gian:** Tuyến tính theo độ dài chuỗi.*
*   **Space Complexity:** $O(N \times L)$ to store the Trie and the HashMap.
    * **Độ phức tạp không gian:** $O(N \times L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

1. **Insert ("apple", 3)**:
   - Path a->p->p->l->e all get `sum = 3`.
2. **Sum ("ap")**:
   - Traverse to node 'p'. Result = node.sum = 3.
3. **Insert ("app", 2)**:
   - oldVal = 0. delta = 2.
   - Path a->p->p all get `+2`. 
   - New sums: a(5), p(5), p(5), l(3), e(3).
4. **Sum ("ap")**:
   - Traverse to node 'p'. Result = 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Whenever you need to aggregate information based on prefixes, augment your Trie nodes with the aggregation result (sum, count, max, etc.). This shifts the computational cost from the query phase to the update phase, which is often a beneficial trade-off.
*Bất cứ khi nào bạn cần tổng hợp thông tin dựa trên tiền tố, hãy tăng cường các nút Trie với kết quả tổng hợp. Điều này chuyển chi phí tính toán từ giai đoạn truy vấn sang giai đoạn cập nhật.*
---
*Tiền tố (Prefix) là chìa khóa mở ra sự kết hợp của nhiều giá trị. Trong cấu trúc của cây (Trie), mỗi nút không chỉ là một ký tự, mà còn là một kho chứa (Sum) mang trong mình sức nặng của tất cả các hậu duệ. Dữ liệu dạy ta rằng bằng cách ghi lại sự thay đổi (Delta) ngay khi nó xảy ra, ta có thể thấu thị được bức tranh tổng thể một cách tức thời, mà không cần phải lục lại từng nhành lá.*
The prefix (Prefix) is the key that opens the combination of many values. In the structure of the tree (Trie), each node is not just a character, but also a reservoir (Sum) carrying the weight of all its descendants. Data teaches us that by recording the change (Delta) as soon as it happens, we can see the overall picture instantly, without having to re-examine every leaf.
