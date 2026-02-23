# Analysis for Card Flipping Game
# *Phân tích cho bài toán Trò chơi Lật bài*

## 1. Problem Essence & The "Invalid" Condition
## *1. Bản chất vấn đề & Điều kiện "Không hợp lệ"*

### The Challenge
### *Thách thức*
A number $X$ is **not good** if we cannot avoid having it on the back side of some card when it's on the front side of our chosen card.
The key observation: If a card has the **same** number on both its front and back (`fronts[i] == backs[i]`), that number $X = fronts[i]$ can **never** be the answer. No matter how we flip other cards, this specific card will always have $X$ on its back side if we don't pick it as front, or if we do pick it as front, the rule says it shouldn't be on the back of any card.
Wait, let's re-read carefully: "If this number is not on the back side of **any** of the cards, then this number is good."
This includes itself. So if `fronts[i] == backs[i]`, that number is disqualified.
*Một con số $X$ là **không tốt** nếu chúng ta không thể tránh khỏi việc nó xuất hiện ở mặt sau của một lá bài nào đó. Quan sát quan trọng: Nếu một lá bài có cùng một con số ở cả hai mặt (`fronts[i] == backs[i]`), con số đó không bao giờ có thể là đáp án vì nó sẽ luôn xuất hiện ở mặt sau (hoặc mặt trước).*

---

## 2. Strategy: Filtering Disqualified Numbers
## *2. Chiến lược: Lọc các số bị loại*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Identify Disqualified Numbers:**
    - Traverse all cards. If `fronts[i] == backs[i]`, add `fronts[i]` to a `disqualified` set.
    *   **Xác định các số bị loại:** Duyệt qua tất cả các quân bài. Nếu `fronts[i] == backs[i]`, thêm số đó vào tập hợp `disqualified`.*

2.  **Find Minimum Potential Candidate:**
    - Iterate through all numbers in `fronts` and `backs`.
    - If a number is **not** in the `disqualified` set, it is a potential candidate.
    - Keep track of the minimum such number.
    *   **Tìm ứng viên nhỏ nhất:** Duyệt qua tất cả các số trong `fronts` và `backs`. Nếu một số không nằm trong tập `disqualified`, nó là ứng viên tiềm năng. Tìm số nhỏ nhất.*

3.  **Result:** If no candidate is found, return `0`.
    *   **Kết quả:** Nếu không thấy ứng viên, trả về `0`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int flipgame(int[] fronts, int[] backs) {
    Set<Integer> same = new HashSet<>();
    for (int i = 0; i < fronts.length; i++) {
        if (fronts[i] == backs[i]) same.add(fronts[i]);
    }
    
    int ans = 2001;
    for (int x : fronts) {
        if (!same.contains(x)) ans = Math.min(ans, x);
    }
    for (int x : backs) {
        if (!same.contains(x)) ans = Math.min(ans, x);
    }
    
    return ans == 2001 ? 0 : ans;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of cards. We pass through the arrays a constant number of times.
    *   **Độ phức tạp thời gian:** $O(N)$, vì ta duyệt qua mảng số lần cố định.*
*   **Space Complexity:** $O(N)$ for the `HashSet`.
    *   **Độ phức tạp không gian:** $O(N)$ cho tập hợp số bị loại.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `fronts = [1,2,4,4,7], backs = [1,3,4,1,3]`
1. Check `fronts[i] == backs[i]`:
   - `i=0: 1 == 1`? Yes. `same = {1}`.
   - `i=2: 4 == 4`? Yes. `same = {1, 4}`.
   - `i=3: 4 == 1`? No.
2. Check candidates in `fronts`:
   - 1: disqual.
   - 2: Not in `same`. `min = 2`.
   - 4: disqual.
   - 7: Not in `same`. `min = 2`.
3. Check candidates in `backs`:
   - 1: disqual.
   - 3: Not in `same`. `min = 2`.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The core of this problem is understanding that any number that appears on both sides of the same card is completely unusable across the entire game, because a flip only swaps it but doesn't remove it from the back-side pool.
*Cốt lõi của bài toán này là hiểu rằng bất kỳ con số nào xuất hiện ở cả hai mặt của cùng một lá bài đều không thể sử dụng được trong toàn bộ trò chơi, vì việc lật chỉ tráo đổi nó chứ không loại bỏ nó khỏi "vùng chứa" mặt sau.*
