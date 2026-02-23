# Result for Stone Game
# *Kết quả cho bài toán Trò chơi Bốc đá*

## Description
## *Mô tả*

Alice and Bob play a game with piles of stones. There are an **even number** of piles arranged in a row, and each pile has a **positive integer** number of stones `piles[i]`.
*Alice và Bob chơi một trò chơi với các nải đá. Có một số **nải chẵn** được sắp xếp thành một hàng, và mỗi nải có một số nguyên **dương** viên đá `piles[i]`.*

The objective of the game is to end with the most stones. The **total** number of stones across all piles is **odd**, so there are no ties.
*Mục tiêu của trò chơi là kết thúc với nhiều đá nhất. **Tổng** số đá trong tất cả các nải là **lẻ**, vì vậy không có kết quả hòa.*

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the **beginning** or from the **end** of the row. This continues until there are no more piles left, at which point the person with the most stones **wins**.
*Alice và Bob luân phiên bốc đá, Alice bắt đầu trước. Mỗi lượt, người chơi lấy toàn bộ nải đá từ **đầu** hoặc từ **cuối** hàng. Quá trình này tiếp tục cho đến khi không còn nải nào, người có nhiều đá nhất sẽ **thắng**.*

Assuming Alice and Bob play optimally, return `true` if Alice wins the game, and `false` if she loses.
*Giả sử Alice và Bob chơi tối ưu, hãy trả về `true` nếu Alice thắng trò chơi và `false` nếu cô ấy thua.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** piles = [5,3,4,5]
**Output:** true
**Explanation:** 
Alice starts first, she can only take 5 from the first or 5 from the last.
If she takes 5 from the first, the row becomes [3,4,5].
If Bob takes 3 from the first, the row becomes [4,5], then Alice takes 5 to win with 10 stones.
If Bob takes 5 from the last, the row becomes [3,4], then Alice takes 4 to win with 9 stones.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= piles.length <= 500`
*   `piles.length` is **even**.
*   `1 <= piles[i] <= 500`
*   `sum(piles[i])` is **odd**.
