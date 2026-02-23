# Result for Contain Virus
# *Kết quả cho bài toán Ngăn chặn Virus*

## Description
## *Mô tả*

A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.
*Một loại virus đang lây lan nhanh chóng, và nhiệm vụ của bạn là cách ly khu vực bị nhiễm bằng cách dựng các bức tường.*

The world is modeled as an `m x n` binary grid `isInfected`, where `isInfected[i][j] == 0` represents uninfected cells, and `isInfected[i][j] == 1` represents cells contaminated with the virus. A wall involves only two cells: one infected and one uninfected. It's not the same as a blocked cell.
*Thế giới được mô hình hóa dưới dạng một lưới nhị phân `m x n` `isInfected`, trong đó `isInfected[i][j] == 0` đại diện cho các ô chưa bị nhiễm, và `isInfected[i][j] == 1` đại diện cho các ô bị nhiễm virus. Một bức tường chỉ liên quan đến hai ô: một ô bị nhiễm và một ô không bị nhiễm. Nó không giống với một ô bị chặn hoàn toàn.*

Every night, the virus spreads to all neighboring cells in all 4 directions unless blocked by a wall.
*Mỗi đêm, virus lây lan sang tất cả các ô lân cận theo 4 hướng trừ khi bị chặn bởi một bức tường.*

Resources are limited. Each day, you can install walls around **only one** region -- the affected area (continuous block of infected cells) that threatens to infect the most uninfected cells the following night. There will never be a tie.
*Tài nguyên có hạn. Mỗi ngày, bạn chỉ có thể dựng tường xung quanh **một** khu vực -- khu vực bị ảnh hưởng (khối các ô bị nhiễm liên tục) mà đe dọa lây nhiễm cho nhiều ô chưa bị nhiễm nhất vào đêm tiếp theo. Sẽ không bao giờ có trường hợp hòa.*

Can you find the number of walls required to quarantine all the infected cells? If the virus cannot be controlled, return the number of walls used.
*Bạn có thể tìm số lượng bức tường cần thiết để cách ly tất cả các ô bị nhiễm không? Nếu virus không thể được kiểm soát, hãy trả về số lượng bức tường đã sử dụng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** isInfected = [[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]
**Output:** 10
**Explanation:** There are 2 contaminated regions.
On the first day, add 5 walls to quarantine the virus region on the left. The board after the virus spreads is:
[[0,1,0,0,0,0,1,1],[0,1,0,0,0,0,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1]]
On the second day, add 5 walls to quarantine the virus region on the right. The virus is fully contained.

---

## Constraints:
## *Ràng buộc:*

*   `m == isInfected.length`
*   `n == isInfected[i].length`
*   `1 <= m, n <= 50`
*   `isInfected[i][j]` is either `0` or `1`.
*   There will never be a tie in the number of uninfected cells threatened.
