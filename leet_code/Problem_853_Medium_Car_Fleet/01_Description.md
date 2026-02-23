# Result for Car Fleet
# *Kết quả cho bài toán Đội xe*

## Description
## *Mô tả*

There are `n` cars at given miles away from the starting mile 0, traveling to reach the target mile `target`.
*Có `n` chiếc xe ở các dặm cách dặm 0 điểm xuất phát cho trước, đang di chuyển để đạt được dặm mục tiêu `target`.*

You are given two integer arrays `position` and `speed`, both of length `n`, where `position[i]` is the starting position of the `i`-th car and `speed[i]` is the speed of the `i`-th car in miles per hour.
*Bạn được cho hai mảng số nguyên `position` và `speed`, cả hai đều có độ dài `n`, trong đó `position[i]` là vị trí xuất phát của chiếc xe thứ `i` và `speed[i]` là tốc độ của chiếc xe thứ `i` tính bằng dặm trên giờ.*

A car can never pass another car ahead of it, but it can catch up to it and drive at the same speed as the car ahead, forming a **car fleet**. A car fleet is one or more cars driving at the same position and same speed.
*Một chiếc xe không bao giờ có thể vượt qua một chiếc xe khác phía trước nó, nhưng nó có thể đuổi kịp và đi với cùng tốc độ với chiếc xe phía trước, tạo thành một **đội xe**. Một đội xe là một hoặc nhiều chiếc xe chạy cùng vị trí và cùng tốc độ.*

If a car catches up to another car right at the destination, it is still considered to be part of the same car fleet.
*Nếu một chiếc xe đuổi kịp một chiếc xe khác ngay tại điểm đích, nó vẫn được coi là một phần của cùng một đội xe.*

Return *the number of car fleets that will arrive at the destination*.
*Trả về *số lượng đội xe sẽ đến đích*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
**Output:** 3
**Explanation:** 
- The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
- The car starting at 0 (speed 1) does not catch up to any other car, so it forms a fleet by itself.
- The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Note that no other cars meet these fleets before the destination, so the answer is 3.

## Example 2:
## *Ví dụ 2:*

**Input:** target = 10, position = [3], speed = [3]
**Output:** 1
**Explanation:** There is only one car, hence there is only one fleet.

## Example 3:
## *Ví dụ 3:*

**Input:** target = 100, position = [0,2,4], speed = [4,2,1]
**Output:** 1
**Explanation:** 
- The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
- Then, the fleet (at 4, speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

---

## Constraints:
## *Ràng buộc:*

*   `n == position.length == speed.length`
*   `1 <= n <= 10^5`
*   `0 < target <= 10^6`
*   `0 <= position[i] < target`
*   All the values in `position` are **unique**.
*   `0 < speed[i] <= 10^6`
