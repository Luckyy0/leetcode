# 486. Predict the Winner / Dự Đoán Người Chiến Thắng

## Problem Description / Mô tả bài toán
You are given an integer array `nums`. Two players are playing a game with this array: player 1 and player 2.
Cho một mảng số nguyên `nums`. Hai người chơi đang chơi một trò chơi với mảng này: người chơi 1 và người chơi 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., `nums[0]` or `nums[nums.length - 1]`) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.
Người chơi 1 và người chơi 2 thay phiên nhau, người chơi 1 bắt đầu trước. Cả hai người chơi bắt đầu với số điểm là 0. Tại mỗi lượt, người chơi lấy một trong các số từ một trong hai đầu của mảng (ví dụ: `nums[0]` hoặc `nums[nums.length - 1]`), làm giảm kích thước của mảng đi 1. Người chơi cộng số đã chọn vào điểm của mình. Trò chơi kết thúc khi không còn phần tử nào trong mảng.

Return `true` if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return `true`. You may assume that both players are playing optimally.
Hãy trả về `true` nếu Người chơi 1 có thể thắng trò chơi. Nếu điểm của cả hai người chơi bằng nhau, người chơi 1 vẫn thắng. Giả sử rằng cả hai người chơi đều chơi một cách tối ưu.

### Example 1:
```text
Input: nums = [1,5,2]
Output: false
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (the advantageous move), the array becomes [1,5]. Now player 2 can choose 5, and then player 1 gets 1. 
Final Scores: Player 1 = 2 + 1 = 3, Player 2 = 5. Hence, player 1 loses.
```

### Example 2:
```text
Input: nums = [1,5,233,7]
Output: true
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score than player 2.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 20`
- `0 <= nums[i] <= 10^7`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Mini-Max) / Quy hoạch động (Mini-Max)
This is a zero-sum game problem. We want to maximize the **difference** between Player 1's score and Player 2's score.
Let `dp[i][j]` be the maximum difference (P1 score - P2 score) Player 1 (or any current player) can achieve from the subarray `nums[i...j]`.

Algorithm:
1. Base case: `dp[i][i] = nums[i]`. (Only one element remains).
2. Recursive step:
   - The current player picks `nums[i]`. The next player will achieve `dp[i+1][j]` (the relative advantage from the remaining part). So picking `nums[i]` yields `nums[i] - dp[i+1][j]`.
   - The current player picks `nums[j]`. This yields `nums[j] - dp[i][j-1]`.
   - `dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])`.
3. If `dp[0][n-1] >= 0`, Player 1 wins.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or O(N) with space optimization.

---

## Analysis / Phân tích

### Approach: Interval Dynamic Programming

**Algorithm**:
1.  Initialize DP table.
2.  Iterate over lengths of subarrays.
3.  Fill table using recursive relation.
4.  Check if final max difference is non-negative.

---
