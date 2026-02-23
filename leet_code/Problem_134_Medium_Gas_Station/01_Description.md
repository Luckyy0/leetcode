# Result for Gas Station
# *Kết quả cho bài toán Trạm Xăng*

## Description
## *Mô tả*

There are `n` gas stations along a circular route, where the amount of gas at the `i`-th station is `gas[i]`.
*Có `n` trạm xăng dọc theo một con đường vòng tròn, trong đó lượng xăng tại trạm thứ `i` là `gas[i]`.*

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the `i`-th station to its next `(i + 1)`-th station. You begin the journey with an empty tank at one of the gas stations.
*Bạn có một chiếc xe với bình xăng không giới hạn và nó tiêu tốn `cost[i]` xăng để đi từ trạm thứ `i` đến trạm thứ `(i + 1)` tiếp theo. Bạn bắt đầu hành trình với một bình xăng trống tại một trong các trạm xăng.*

Given two integer arrays `gas` and `cost`, return *the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return `-1`*. If there exists a solution, it is **guaranteed** to be **unique**.
*Cho hai mảng số nguyên `gas` và `cost`, hãy trả về *chỉ số của trạm xăng bắt đầu nếu bạn có thể đi hết một vòng tròn theo chiều kim đồng hồ, nếu không hãy trả về `-1`*. Nếu tồn tại một giải pháp, nó được **đảm bảo** là **duy nhất**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `gas = [1,2,3,4,5], cost = [3,4,5,1,2]`
**Output:** `3`
**Explanation:**
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

## Example 2:
## *Ví dụ 2:*

**Input:** `gas = [2,3,4], cost = [3,4,3]`
**Output:** `-1`
**Explanation:**
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
Travel to station 2. Your tank = 3 - 4 = -1
You can't travel back to station 2. No matter where you start, you can't travel around the circuit once.

## Constraints:
## *Ràng buộc:*

*   `n == gas.length == cost.length`
*   `1 <= n <= 10^5`
*   `0 <= gas[i], cost[i] <= 10^4`
