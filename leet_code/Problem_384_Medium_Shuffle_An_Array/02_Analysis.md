# Analysis for Shuffle an Array
# *Phân tích cho bài toán Tráo đổi Mảng*

## 1. Problem Essence & Fisher-Yates Algorithm
## *1. Bản chất vấn đề & Thuật toán Fisher-Yates*

### The Challenge
### *Thách thức*
Generating a truly random permutation where every possible ordering has the same probability ($1/N!$), using $O(N)$ time.

### Strategy: Fisher-Yates Shuffle
### *Chiến lược: Tráo đổi Fisher-Yates*
1.  **Preparation:** Keep a copy of the original array to support the `reset()` function.
2.  **Shuffling Logic:**
    - Iterate from the last element (index $n-1$) down to the second element (index $1$).
    - At each position $i$, pick a random index $j$ such that $0 \le j \le i$.
    - Swap the element at $i$ with the element at $j$.
3.  **Why it works:**
    - The first element chosen for the last position has $1/N$ probability.
    - The next element for position $n-2$ has $1/(N-1)$ probability, and so on.
    - Total probability for any permutation = $\frac{1}{N} \times \frac{1}{N-1} \times \dots \times 1 = \frac{1}{N!}$.

---

## 2. Approach: Iterative Swapping
## *2. Hướng tiếp cận: Hoán đổi Lặp*

### Logic
### *Logic*
(See above). We use `random.nextInt(i + 1)` to pick an index from the un-shuffled portion of the array.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear time for shuffling.
    *Hiệu quả O(N): Thời gian tuyến tính để tráo đổi.*
*   **In-place potential:** Can be done on a clone to preserve the original.
    *Tiềm năng thực hiện tại chỗ: Có thể thực hiện trên bản sao để bảo toàn bản gốc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `reset()`: $O(1)$ if returning original, $O(N)$ if cloning.
    - `shuffle()`: $O(N)$.
    *Độ phức tạp thời gian: O(N) cho shuffle, O(N) cho reset (bản sao).*
*   **Space Complexity:** $O(N)$ to store the original array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Array:** `[1, 2, 3]`
1. $i = 2$. Pick $j \in [0, 2]$. Say $j = 0$. Swap `array[2]` and `array[0]`. `[3, 2, 1]`.
2. $i = 1$. Pick $j \in [0, 1]$. Say $j = 1$. Swap `array[1]` and `array[1]`. `[3, 2, 1]`.
Result: `[3, 2, 1]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Fisher-Yates Shuffle.
*Tráo đổi Fisher-Yates.*
---
*Sự ngẫu nhiên (shuffle) không phải là sự hỗn loạn vô định, mà là một sự công bằng tuyệt đối (equal probability) trong mọi khả năng. Bằng cách hoán đổi từng vị trí một cách có hệ thống (Fisher-Yates), ta mang lại sự tươi mới cho cấu trúc cũ mà vẫn giữ được sự cân bằng của xác suất.*
Randomness (shuffle) is not aimless chaos, but absolute fairness (equal probability) in every possibility. By systematically swapping each position (Fisher-Yates), we bring freshness to the old structure while maintaining the balance of probability.
