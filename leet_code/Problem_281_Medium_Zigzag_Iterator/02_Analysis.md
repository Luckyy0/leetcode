# Analysis for Zigzag Iterator
# *Phân tích cho bài toán Iterator Zigzag*

## 1. Problem Essence & Round-Robin
## *1. Bản chất vấn đề & Round-Robin*

### The Pattern
### *Mẫu*
We have lists $L_1, L_2, ..., L_k$.
Order: $L_1[0], L_2[0], ..., L_k[0], L_1[1], L_2[1], ...$
Skip list if it runs out of elements.

### Strategy: Queue of Iterators
### *Chiến lược: Hàng đợi Iterator*
To handle `k` vectors systematically (answering the follow-up):
- Store an `Iterator` for each non-empty list.
- Put these iterators into a `Queue`.
- `next()`:
    - Poll iterator `curr` from Queue.
    - Value is `curr.next()`.
    - If `curr` still has elements, put it back to the end of the Queue.
    - Return Value.
- `hasNext()`:
    - Queue not empty.

This naturally handles the "Zigzag" (interleaving) even for `k` lists.

---

## 2. Approach: Queue
## *2. Hướng tiếp cận: Hàng đợi*

### Logic
### *Logic*
1.  Initialize: Create iterators for `v1`, `v2`. Add to Queue if `hasNext()`.
2.  `next()`:
    - `it = queue.poll()`.
    - `res = it.next()`.
    - `if it.hasNext() queue.offer(it)`.
    - Return `res`.
3.  `hasNext()`: `!queue.isEmpty()`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Scalability:** Works seamlessly for K inputs.
*   **Memory Efficient:** Only stores iterators, not data copies.
    *Khả năng mở rộng: Hoạt động mượt mà cho K đầu vào. Hiệu quả bộ nhớ: Chỉ lưu iterator, không sao chép dữ liệu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ per `next()` call (amortized queue operations).
*   **Space Complexity:** $O(K)$ where K is number of lists (iters stored in queue). Here $K=2$.
    *Độ phức tạp thời gian: $O(1)$. Độ phức tạp không gian: $O(K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `v1=[1,2]`, `v2=[3,4,5,6]`
1.  Queue: `[it1, it2]`.
2.  `next()`: Poll `it1`. Val 1. `it1` has more? Yes. Push back. Q: `[it2, it1]`.
3.  `next()`: Poll `it2`. Val 3. `it2` has more? Yes. Push back. Q: `[it1, it2]`.
4.  `next()`: Poll `it1`. Val 2. `it1` has more? No. Drop. Q: `[it2]`.
5.  `next()`: Poll `it2`. Val 4. Push back. Q: `[it2]`.
... and so on.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Queue method is the canonical solution for "Leapfrog" or "Round Robin" iteration.
*Phương pháp Hàng đợi là giải pháp chính thống cho phép lặp "nhảy cóc" hoặc "Round Robin".*
---
*Cuộc đời là một điệu nhảy zigzag giữa công việc và nghỉ ngơi, giữa học và hành. Quan trọng là giữ được nhịp điệu (queue) không bị đứt đoạn.*
Life is a zigzag dance between work and rest, learning and practicing. The key is to keep the rhythm (queue) unbroken.
