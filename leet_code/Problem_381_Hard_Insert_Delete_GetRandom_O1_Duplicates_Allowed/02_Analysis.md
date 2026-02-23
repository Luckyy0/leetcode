# Analysis for Insert Delete GetRandom O(1) - Duplicates allowed
# *Phân tích cho bài toán Thêm, Xóa, Lấy Ngẫu nhiên O(1) - Cho phép Trùng lặp*

## 1. Problem Essence & Linked Indices
## *1. Bản chất vấn đề & Chỉ số Liên kết*

### The Challenge
### *Thách thức*
Maintaining $O(1)$ efficiency while handling duplicates. If we just store values in a Map, we lose information about how many times a value appears. If we use a List, deletion is $O(N)$.

### Strategy: List + Map of Sets
### *Chiến lược: Danh sách + Bản đồ các Tập hợp*
1.  **Storage:** Use an `ArrayList<Integer>` to store all elements. This ensures `getRandom` is $O(1)$ and maintains the correct probability (duplicate values appear multiple times in the list).
2.  **Indexing:** Use a `HashMap<Integer, Set<Integer>>` to map each value to a **set of indices** where it currently resides in the list.
3.  **Removal (Swap with Tail):**
    - To remove `val`:
    - Pick any index `idx` of `val` from its set in the Map.
    - Get the last value `lastVal` and its index `lastIdx` from the List.
    - Move `lastVal` to `idx` in the List.
    - Update the set of indices for `lastVal`: remove `lastIdx`, add `idx`.
    - Update the set of indices for `val`: remove `idx`.
    - Remove the last element from the List.

---

## 2. Approach: Set of Indices + Contiguous List
## *2. Hướng tiếp cận: Tập hợp Chỉ số + Danh sách Liên tục*

### Logic
### *Logic*
(See above). The use of a `Set` (specifically `LinkedHashSet` for $O(1)$ iterator behavior or just `Set` for $O(1)$ removal) is crucial for managing multiple occurrences of the same value.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Average O(1):** Handles duplicates while maintaining the same speed as the non-duplicate version.
    *Thời gian O(1) trung bình: Xử lý trùng lặp trong khi vẫn duy trì tốc độ như phiên bản không trùng lặp.*
*   **Correct Probabilities:** Since the List contains all instances, `rand.nextInt(list.size())` naturally reflects the frequency of each value.
    *Xác suất chính xác: Vì Danh sách chứa tất cả các thực thể, việc chọn ngẫu nhiên phản ánh đúng tần suất.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ average per operation.
    *Độ phức tạp thời gian: $O(1)$ trung bình.*
*   **Space Complexity:** $O(N)$ for the list and maps.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**State:** `List = [1, 1, 2]`, `Map = {1: {0, 1}, 2: {2}}`
**Operation:** `remove(1)`
1. Pick `idx = 0` (from Set of 1).
2. Last index: `2`. Last value: `2`.
3. Update List: `List[0] = 2`. `List = [2, 1, 2]`.
4. Update Map for 2: remove `2`, add `0`. `Map[2] = {0}`.
5. Update Map for 1: remove `0`. `Map[1] = {1}`.
6. Pop List: `List = [2, 1]`.
Result: `[2, 1]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap of LinkedHashSet + ArrayList.
*HashMap chứa LinkedHashSet + ArrayList.*
---
*Trong một tập hợp đa dạng (duplicates allowed), mỗi sự hiện diện đều có trọng số của riêng nó (probability). Bằng cách hoán đổi vị trí khéo léo với kẻ đứng cuối (swap with tail), chúng ta có thể loại bỏ bất kỳ trở ngại nào mà không làm xáo trộn trật tự tổng thể của cả hệ thống.*
In a diverse collection (duplicates allowed), every existence has its own weight (probability). By cleverly swapping positions with the last one (swap with tail), we can remove any obstacle without disturbing the overall order of the system.
