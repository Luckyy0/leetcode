# 174. Dungeon Game / Trò Chơi Hầm Ngục

## Problem Description / Mô tả bài toán
The demons had captured the princess and imprisoned her in the bottom-right corner of a `dungeon`. The `dungeon` consists of `m x n` rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
Lũ quỷ đã bắt cóc công chúa và giam giữ cô ở góc dưới bên phải của một `hầm ngục`. `Hầm ngục` bao gồm các phòng `m x n` được bố trí trong một lưới 2D. Hiệp sĩ dũng cảm của chúng ta ban đầu được đặt ở phòng trên cùng bên trái và phải chiến đấu qua hầm ngục để giải cứu công chúa.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Hiệp sĩ có điểm máu ban đầu được đại diện bởi một số nguyên dương. Nếu tại bất kỳ thời điểm nào điểm máu của anh ta giảm xuống 0 hoặc thấp hơn, anh ta chết ngay lập tức.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
Một số phòng được canh giữ bởi lũ quỷ (được đại diện bởi các số nguyên âm), vì vậy hiệp sĩ mất máu khi vào các phòng này; các phòng khác có thể trống (được đại diện là 0) hoặc chứa các quả cầu ma thuật giúp tăng máu cho hiệp sĩ (được đại diện bởi các số nguyên dương).

To reach the princess as quickly as possible, the knight decides to move only **rightward** or **downward** in each step.
Để đến được với công chúa càng nhanh càng tốt, hiệp sĩ quyết định chỉ di chuyển **sang phải** hoặc **xuống dưới** trong mỗi bước.

Return the knight's minimum initial health so that he can rescue the princess.
Trả về số máu ban đầu tối thiểu của hiệp sĩ để anh ta có thể giải cứu công chúa.

### Example 1:
```text
Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: 7 is the minimum initial health. (Path: -2 -> -3 -> 3 -> 1 -> -5 requires min 7 health).
```

### Example 2:
```text
Input: dungeon = [[0]]
Output: 1
```

## Constraints / Ràng buộc
- `m == dungeon.length`
- `n == dungeon[i].length`
- `1 <= m, n <= 200`
- `-1000 <= dungeon[i][j] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Why Bottom-Up Dynamic Programming? / Tại sao là Quy hoạch Động từ dưới lên?
If we try top-down (from (0,0) to princess), we need to track both the current health and the minimum health needed so far. This is difficult because a path with high current health might have required very high initial health earlier.
Nếu chúng ta thử từ trên xuống dưới, chúng ta cần theo dõi cả lượng máu hiện tại và lượng máu tối thiểu cần thiết cho đến nay. Điều này rất khó vì một con đường có lượng máu hiện tại cao có thể đã yêu cầu lượng máu ban đầu rất cao trước đó.

However, if we work **backward** from the princess (bottom-right) to the knight (top-left), we can determine exactly how much health is needed to survive the current room and reach the destination.
Tuy nhiên, nếu chúng ta làm việc **ngược lại** từ công chúa về phía hiệp sĩ, chúng ta có thể xác định chính xác lượng máu cần thiết để sống sót trong phòng hiện tại và đi đến đích.

**State Definition**:
`dp[i][j]` is the minimum health required **before** entering room `(i, j)` to reach the princess.

**Transition**:
To survive from `(i, j)`, the knight must go to `(i+1, j)` or `(i, j+1)`.
The health needed at `(i, j)` is `min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]`.
Since health must always be at least 1:
`dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])`.

---

## Analysis / Phân tích

### Approach: 2D Dynamic Programming (Backward)

**Algorithm**:
1. Initialize `dp` table of size `(m+1) x (n+1)` with `Integer.MAX_VALUE`.
2. Base case: `dp[m][n-1] = 1` and `dp[m-1][n] = 1`. (To ensure reaching (m-1, n-1) needs only 1 health if it was empty).
3. Loop from `m-1` down to 0 and `n-1` down to 0:
    - `dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])`.
4. Return `dp[0][0]`.

### Complexity / Độ phức tạp
- **Time**: O(M * N) - visit each room once.
- **Space**: O(M * N) or O(N) with optimization.

---

## Edge Cases / Các trường hợp biên
1.  **Single room**: `[[x]]`.
2.  **All positive dungeon**: Minimum health will be 1.
3.  **All negative dungeon**: Knight needs high initial health.
4.  **Zeroes**.
