# Analysis for Stone Game
# *Phân tích cho bài toán Trò chơi Bốc đá*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Two players take turns picking piles from either end. There are an even number of piles, and the total sum is odd. Determine if the first player (Alice) can always win.
*Hai người chơi luân phiên bốc các nải từ hai đầu. Có số nải chẵn và tổng số đá là lẻ. Xác định xem người chơi đầu tiên (Alice) có luôn thắng hay không.*

---

## 2. Strategy: The Mathematical "Cheat" and DP
## *2. Chiến lược: Mẹo Toán học và Quy hoạch động*

### Approach 1: Mathematical Logic
### *Cách tiếp cận 1: Logic toán học*
Because there is an even number of piles, Alice can choose to take all the piles at **even indices** ($0, 2, 4 \dots$) or all the piles at **odd indices** ($1, 3, 5 \dots$).
*Vì có số nải chẵn, Alice có thể chọn lấy tất cả các nải ở **vị trí chẵn** hoặc tất cả các nải ở **vị trí lẻ**.*

1.  Calculate $Sum_{even} = \sum piles[0, 2, 4 \dots]$.
2.  Calculate $Sum_{odd} = \sum piles[1, 3, 5 \dots]$.
Since the total sum is odd, $Sum_{even} \neq Sum_{odd}$. Alice can simply compare them and choose the strategy that gives her the larger sum. Thus, Alice **always** wins.
*Vì tổng số đá là lẻ nên hai tổng này không bao giờ bằng nhau. Alice chỉ cần so sánh chúng và bắt đầu bằng nải ở đầu hoặc cuối để đảm bảo cô ấy sẽ lấy được toàn bộ tập hợp có tổng lớn hơn. Do đó, Alice **luôn luôn** thắng.*

### Approach 2: Dynamic Programming (The "Real" Way)
### *Cách tiếp cận 2: Quy hoạch động (Cách làm chính quy)*
Let `dp[i][j]` be the maximum score difference Alice can get over Bob from piles `i` through `j`.
- Base case: `dp[i][i] = piles[i]`.
- Transition: `dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])`.
Alice wins if `dp[0][n-1] > 0`.
*Gọi `dp[i][j]` là sự chênh lệch điểm số tối đa mà Alice có thể đạt được so với Bob từ nải `i` đến `j`. Nếu `dp[0][n-1] > 0`, Alice thắng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean stoneGame(int[] piles) {
    // Math logic: Alice always wins
    return true;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for the mathematical proof, or $O(N^2)$ for the formal DP solution.
    *   **Độ phức tạp thời gian:** $O(1)$ hoặc $O(N^2)$.*
*   **Space Complexity:** $O(1)$ or $O(N^2)$.
    *   **Độ phức tạp không gian:** $O(1)$ hoặc $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

While the $O(1)$ answer works for LeetCode, understanding the minimax/DP approach is vital for variants where the rules change (e.g., odd number of piles or ties allowed).
*Mặc dù câu trả lời $O(1)$ hoạt động được, việc hiểu cách tiếp cận DP là rất quan trọng cho các biến thể khác nơi quy tắc thay đổi.*
