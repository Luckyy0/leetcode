# 877. Stone Game / Trò chơi Sỏi

## Problem Description / Mô tả bài toán
Alice and Bob play a game with piles of stones. There is an even number of piles, and each pile has a positive integer number of stones `piles[i]`.
Alice và Bob chơi một trò chơi với các đống sỏi. Có một số lượng chẵn các đống sỏi, mỗi đống có một số lượng sỏi nguyên dương `piles[i]`.

The player who takes the most stones wins. Return `true` if Alice wins (playing optimally).
Người nào lấy được nhiều sỏi nhất sẽ thắng. Trả về `true` nếu Alice thắng (chơi tối ưu).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Game Theory / Strategy / Lý thuyết Trò chơi / Chiến lược
Crucial observation: Since the number of piles is even and the total number of stones is odd (implied in some variations or just given that there are no ties), Alice can always win.
Quan sát quan trọng: Vì số lượng đống là chẵn và tổng số sỏi thường là lẻ, Alice luôn có thể thắng.

Strategy:
Color the piles alternatively: `Black, White, Black, White...`.
Alice can choose to take all "Black" piles or all "White" piles by forcing Bob to take the other color every turn.
She simply calculates which color has more stones and sticks to that strategy.

Mathematical Proof:
Actually, for any 2D DP game problem of this type, `dp[i][j]` is the maximum relative score.
`dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])`.

### Complexity / Độ phức tạp
- **Time**: O(1) (for the return true) or O(N^2) for DP.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Parity Dominance
Alice, as the first player, can dictate the parity of indices chosen throughout the game. By identifying which index set (even or odd) contains the larger sum, she can ensure her victory.
Alice, với tư cách là người chơi đầu tiên, có thể ra lệnh cho tính chẵn lẻ của các chỉ số được chọn trong suốt trò chơi. Bằng cách xác định tập hợp chỉ số nào (chẵn hay lẻ) chứa tổng lớn hơn, cô ấy có thể đảm bảo chiến thắng của mình.

---
