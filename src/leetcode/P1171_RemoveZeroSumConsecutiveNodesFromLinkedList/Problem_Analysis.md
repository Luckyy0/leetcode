# 1171. Remove Zero Sum Consecutive Nodes from Linked List / Xóa các Nút Liên tiếp có Tổng bằng 0 khỏi Danh sách Liên kết

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
After doing so, return the head of the final linked list. You may return any such final list.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum with HashMap / Tổng Tiền tố với HashMap
If `prefixSum[i] == prefixSum[j]`, then the sub-segment from `i+1` to `j` sums to 0.
Algorithm:
1. Create dummy head (val 0, points to head).
2. First pass: Compute prefix sums, map `prefixSum -> node`.
   - If a sum repeats, the map entry gets updated to the latest node. This effectively identifies the *last* node for a particular sum.
3. Second pass: Iterate nodes. For current node, if `map.get(prefixSum)` is effectively a future node, it means everything in between sums to 0.
   - Set `current.next = map.get(prefixSum).next`.
   - This skips the zero-sum segment.
   - Note: Skipping might skip nodes that were part of other prefix sums. This is fine because the skipped main sum encompasses them.
   - Wait, `map` stores the *last* occurrence. So `current` connects to `after last occurrence`.
   - Does this simple logic work recursively? Yes, because we skip the entire chunk.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Prefix Sum Mapping
Use a HashMap to store the running prefix sums and the linked list node associated with each sum. Iterate through the list to build this map; if the same sum encounters multiple times, the map will store the latest node, effectively marking the end of a zero-sum sequence starting after the first occurrence. Iterate a second time: for each node, look up its prefix sum in the map to find the final node with that same sum, and link straight to its next node, thereby pruning zero-sum segments.
Sử dụng HashMap để lưu trữ các tổng tiền tố đang chạy và nút danh sách liên kết được liên kết với mỗi tổng. Lặp qua danh sách để xây dựng bản đồ này; nếu cùng một tổng gặp nhiều lần, bản đồ sẽ lưu trữ nút mới nhất, đánh dấu hiệu quả phần cuối của chuỗi tổng bằng không bắt đầu sau lần xuất hiện đầu tiên. Lặp lại lần thứ hai: đối với mỗi nút, hãy tìm tổng tiền tố của nó trong bản đồ để tìm nút cuối cùng có cùng tổng đó và liên kết thẳng đến nút tiếp theo của nó, do đó cắt tỉa các phân đoạn tổng bằng không.

---
