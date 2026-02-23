# Analysis for Reveal Cards In Increasing Order
# *Phân tích cho bài toán Lật Ngửa Các Quân Bài Theo Thứ Tự Tăng Dần*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Reorder the deck so that the simulation (reveal top, move next to bottom) produces sorted cards.
*Sắp xếp lại bộ bài sao cho quá trình mô phỏng (lật lá trên cùng, chuyển lá tiếp theo xuống đáy) tạo ra các lá bài đã sắp xếp.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Simulation process: Indices are processed in a specific order.
- Example indices simulation for length 7:
  - Queue: [0, 1, 2, 3, 4, 5, 6]
  - Step 1: Reveal 0. Move 1 to bottom. Queue: [2, 3, 4, 5, 6, 1]
  - Step 2: Reveal 2. Move 3 to bottom. Queue: [4, 5, 6, 1, 3]
  - And so on.
- The order of "revealed indices" corresponds to the sorted values of the deck.
- Algorithm:
  1. Sort the `deck`.
  2. Simulate the process using indices `0` to `n-1` with a Queue/Deque.
  3. Record the order in which indices are "revealed".
  4. Place the sorted card values into the result array at these revealed indices.
  5. E.g., if the simulation reveals index `k` first, `result[k]` should be the smallest card. If it reveals index `m` second, `result[m]` should be the second smallest card.
*Mô phỏng quy trình bằng Queue chứa các chỉ số. Thứ tự chỉ số được "lật" sẽ tương ứng với các giá trị đã sắp xếp của bộ bài. Gán giá trị nhỏ nhất vào chỉ số lật đầu tiên, v.v.*

---

## 2. Strategy: Simulation with Queue
## *2. Chiến lược: Mô phỏng với Hàng đợi*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort:** `Arrays.sort(deck)`.
    *   **Sắp xếp:** `deck` tăng dần.*

2.  **Initialize Queue:** Add indices `0, 1, ..., n-1`.
    *   **Khởi tạo Queue:** Thêm chỉ số.*

3.  **Simulate:**
    - Iterate through sorted `deck` values.
    - `index = queue.poll()`.
    - `result[index] = deck[i]`. (Assign current smallest card to this position).
    - If queue not empty: `queue.add(queue.poll())`. (Move next index to bottom).
    *   **Mô phỏng:** Lấy chỉ số ra, gán giá trị. Chuyển chỉ số tiếp theo xuống cuối.*

4.  **Return:** `result`.
    *   **Trả về:** `result`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }
        
        int[] result = new int[n];
        
        for (int card : deck) {
            // Reveal the top card index
            int index = indexQueue.poll();
            result[index] = card;
            
            // Move the next top card index to the bottom
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }
        
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ for sorting. Simulation is $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for queue and result.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simulating the index manipulation is more intuitive than trying to reverse-engineer the deck mathematically.
*Mô phỏng thao tác chỉ số trực quan hơn là cố gắng đảo ngược quy trình toán học.*
