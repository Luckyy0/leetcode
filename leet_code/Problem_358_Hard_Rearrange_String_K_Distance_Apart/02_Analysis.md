# Analysis for Rearrange String k Distance Apart
# *Phân tích cho bài toán Sắp xếp lại Chuỗi cách nhau khoảng k*

## 1. Problem Essence & Greedy Strategy
## *1. Bản chất vấn đề & Chiến lược Tham lam*

### The Challenge
### *Thách thức*
Arranging characters such that identical ones are separated by at least $k$ positions. This requires using high-frequency characters as early as possible while managing their "cool-down" period.

### Strategy: Max-Heap + Waiting Queue
### *Chiến lược: Max-Heap + Hàng đợi Chờ*
1.  **Frequency Count:** Map all characters to their counts.
2.  **Max-Heap:** Add all characters to a Max-Heap based on their frequency. We always want to pick the most frequent character available to avoid being left with unreachable duplicates.
3.  **Waiting Queue:** Once a character is used, it cannot be used again for the next $k-1$ slots. We put it in a `Queue` along with the position index when it becomes available again.
4.  **Greedy Loop:**
    - For each position $i$ in the output string:
        - Check the `Queue`. If the front character is now available (it has been $k$ positions since it was last used), add it back to the `Max-Heap`.
        - If the `Max-Heap` is empty but we still need to fill characters, it's **impossible**. Return `""`.
        - Poll the best character from the `Max-Heap`.
        - Append to our result, decrement its frequency.
        - If frequency $> 0$, add it to the `Queue`.

---

## 2. Approach: Priority Queue + Queue
## *2. Hướng tiếp cận: Priority Queue + Queue*

### Logic
### *Logic*
(See above). This greedy approach ensures we "use up" the most constrained characters (highest frequency) as soon as they are legal to use.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Greedy:** Always choosing the max frequency available is proven to be the correct greedy choice for this class of problems.
    *Tham lam tối ưu: Luôn chọn tần suất tối đa hiện có được chứng minh là lựa chọn tham lam đúng đắn cho loại bài toán này.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log 26)$ which simplifies to $O(N)$ because the alphabet size is constant.
    *Độ phức tạp thời gian: $O(N \log 26) \approx O(N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "aabbcc", k = 3`
1. Frequencies: `{a:2, b:2, c:2}`. Heap: `[a, b, c]`. Queue: `[]`.
2. $i=0$: Pick `a`. Heap: `[b, c]`. Queue: `[(a, count 1, available at i=3)]`. Result: `a`.
3. $i=1$: Pick `b`. Heap: `[c]`. Queue: `[(a,1,3), (b,1,4)]`. Result: `ab`.
4. $i=2$: Pick `c`. Heap: `[]`. Queue: `[(a,1,3), (b,1,4), (c,1,5)]`. Result: `abc`.
5. $i=3$: Queue front `a` is available. Heap: `[a]`. Pick `a`. Result: `abca`.
... and so on.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Max-Heap with cool-down queue is the robust solution.
*Max-Heap với hàng đợi "giảm nhiệt" là giải pháp mạnh mẽ nhất.*
---
*Trong cuộc sống, sự lặp lại (duplicates) là cần thiết, nhưng để giữ cho mọi thứ luôn mới mẻ, chúng cần có khoảng cách (k distance). Biết cách kiềm chế (waiting queue) và ưu tiên những gì quan trọng nhất (max frequency) là chìa khóa của sự sắp xếp hoàn hảo.*
In life, repetition (duplicates) is necessary, but to keep things fresh, they need distance (k distance). Knowing how to restrain yourself (waiting queue) and prioritize what is most important (max frequency) is the key to perfect arrangement.
