# Analysis for LFU Cache
# *Phân tích cho bài toán Bộ nhớ đệm LFU*

## 1. Problem Essence & Multi-Level Mapping
## *1. Bản chất vấn đề & Ánh xạ Đa cấp*

### The Challenge
### *Thách thức*
Designing a cache that removes the **Least Frequently Used (LFU)** item. If there are ties in frequency, remove the **Least Recently Used (LRU)** item. All operations must be $O(1)$.

### Strategy: HashMaps + Frequency Buckets Linked Lists
### *Chiến lược: HashMap + Danh sách liên kết của các Xô Tần suất*

1.  **Main Maps:**
    - `Map<Integer, Node> cache`: Maps `key` to its corresponding `Node`.
    - `Map<Integer, DoubleLinkedList> freqMap`: Maps `frequency` to a **Doubly Linked List** of nodes that have that frequency.
2.  **Tracking `minFrequency`:**
    - Maintain a variable `minFreq` to keep track of the current minimum frequency in the entire cache. This allows $O(1)$ lookup for the eviction candidate.
3.  **Operations:**
    - **`get(key)` / `update(node)`:**
        - Increment the frequency of the node.
        - Move the node from its old list (at `oldFreq`) to the new list (at `newFreq`).
        - If the old list becomes empty and `oldFreq == minFreq`, increment `minFreq`.
    - **`put(key, value)`:**
        - If key exists: Update value and call `update(node)`.
        - If key is new:
            - If at capacity: Evict the `LRU` node from the list at `minFreq` (usually the `last` node in that DLL).
            - Insert the new node with `frequency = 1`.
            - Set `minFreq = 1`.

---

## 2. Approach: Bucketed DLLs
## *2. Hướng tiếp cận: Danh sách liên kết đôi theo xô*

### Logic
### *Logic*
(See above). The use of frequency buckets (each being an LRU cache itself) elegantly handles both LFU and LRU requirements. By using Doubly Linked Lists, insertion and deletion are $O(1)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Exact O(1):** No loops or complex searches during `get` or `put`.
    *Chính xác O(1): Không có vòng lặp hay tìm kiếm phức tạp.*
*   **Dual Criteria:** Naturally combines frequency and recency.
    *Tiêu chí kép: Kết hợp tự nhiên giữa tần suất và độ mới.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ average for both `get` and `put`.
    *Độ phức tạp thời gian: Trung bình $O(1)$.*
*   **Space Complexity:** $O(C)$, where $C$ is the capacity.
    *Độ phức tạp không gian: $O(C)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Capacity = 2**
1. `put(1, 1)`: `cache={1}, freqMap={1: [1]}, minFreq=1`.
2. `put(2, 2)`: `cache={1, 2}, freqMap={1: [1, 2]}, minFreq=1`.
3. `get(1)`: 
   - Move 1 to freq 2. `freqMap={1: [2], 2: [1]}`.
   - `minFreq` stays 1 because list for freq 1 is not empty.
4. `put(3, 3)`:
   - Evict from `minFreq=1`. List 1 has `[2]`. Evict 2.
   - Insert 3. `freqMap={1: [3], 2: [1]}, minFreq=1`.
Result: 2 is gone.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap for keys and HashMap of DLLs for frequency buckets.
*Sử dụng HashMap cho khóa và HashMap chứa các DLL cho các xô tần suất.*
---
*LFU Cache là đỉnh cao của sự cân bằng giữa giá trị (frequency) và thời gian (recency). Trong cuộc sống, những gì ta làm thường xuyên nhất (LFU) luôn xứng đáng có một vị trí ưu tiên, nhưng ngay cả trong những điều quan trọng đó, những gì mới mẻ hơn (LRU) vẫn mang lại hơi thở hiện đại. Bằng cách tổ chức ký ức vào những ngăn kéo tần suất (buckets), ta tối ưu hóa không gian tâm trí để luôn sẵn sàng cho những kiến thức mới.*
LFU Cache is the peak of balance between values (frequency) and time (recency). In life, what we do most often (LFU) always deserves a priority position, but even in those important things, what is newer (LRU) still brings a modern breath. By organizing memories into frequency drawers (buckets), we optimize the space of the mind to be ready for new knowledge.
