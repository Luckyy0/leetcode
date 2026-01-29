# 649. Dota2 Senate / Thượng Viện Dota2

## Problem Description / Mô tả bài toán
In the world of Dota2, there are two parties: the Radiant and the Dire.
Trong thế giới Dota2, có hai đảng: Radiant và Dire.

The Dota2 Senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
Thượng viện Dota2 bao gồm các thượng nghị sĩ đến từ hai đảng. Bây giờ Thượng viện muốn quyết định về một thay đổi trong trò chơi Dota2. Việc bỏ phiếu cho thay đổi này là một thủ tục theo vòng. Trong mỗi vòng, mỗi thượng nghị sĩ có thể thực hiện một trong hai quyền:
1. Ban one senator's right: A senator can make another senator run out all his and her rights in this and all the following rounds.
   Cấm quyền của một thượng nghị sĩ: Một thượng nghị sĩ có thể khiến một thượng nghị sĩ khác mất hết quyền của mình trong vòng này và tất cả các vòng tiếp theo.
2. Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he or she can announce the victory and decide on the change in the game.
   Tuyên bố chiến thắng: Nếu thượng nghị sĩ này thấy các thượng nghị sĩ vẫn còn quyền bỏ phiếu đều thuộc cùng một đảng, người đó có thể tuyên bố chiến thắng và quyết định thay đổi trò chơi.

Given a string `senate` representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are `n` senators, the size of the given string will be `n`.
Cho một chuỗi `senate` đại diện cho đảng của mỗi thượng nghị sĩ. Các ký tự 'R' và 'D' đại diện cho đảng Radiant và đảng Dire. Nếu có `n` thượng nghị sĩ, kích thước của chuỗi đã cho sẽ là `n`.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
Thủ tục dựa trên vòng bắt đầu từ thượng nghị sĩ đầu tiên đến thượng nghị sĩ cuối cùng theo thứ tự đã cho. Thủ tục này sẽ kéo dài cho đến khi kết thúc bỏ phiếu. Tất cả các thượng nghị sĩ đã mất quyền sẽ bị bỏ qua trong thủ tục.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
Giả sử mọi thượng nghị sĩ đều đủ thông minh và sẽ chơi chiến lược tốt nhất cho đảng của mình. Dự đoán đảng nào cuối cùng sẽ tuyên bố chiến thắng và thay đổi trò chơi Dota2. Đầu ra phải là "Radiant" hoặc "Dire".

### Example 1:
```text
Input: senate = "RD"
Output: "Radiant"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Queue Simulation / Mô Phỏng Hàng Đợi
Greedy strategy: Use current turn to ban the *next available* opponent. The earliest possible opponent to prevent them from acting in THIS round or NEXT round (if they appeared before).
Actually, the best strategy is to ban the next opponent in the sequence. If the opponent is behind you in the queue, you prevent them from acting in this round. If they are ahead (index < current), you prevent them in the next round.
Use two Queues: `radiant` and `dire`, storing indices.
While both queues not empty:
Compare front indices `r_idx` and `d_idx`.
- If `r_idx < d_idx`: R acts before D. R bans D. R goes to back of queue with index `r_idx + n` (next round). D is removed.
- If `d_idx < r_idx`: D acts before R. D bans R. D goes to back with `d_idx + n`. R is removed.

### Complexity / Độ phức tạp
- **Time**: O(N). Each comparison eliminates one senator.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Two Queues

**Algorithm**:
1.  Populate queues with indices.
2.  While both not empty:
3.  Compare heads. Winner pushes `index + n` to back. Loser removed.
4.  Check which queue remains.

---
