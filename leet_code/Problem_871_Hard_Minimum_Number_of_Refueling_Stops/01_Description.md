# Result for Minimum Number of Refueling Stops
# *Kết quả cho bài toán Số lần Dừng tiếp nhiên liệu Tối thiểu*

## Description
## *Mô tả*

A car travels from a starting position to a destination which is `target` miles away. There are gas stations along the way. The gas stations are represented as an array `stations` where `stations[i] = [position_i, fuel_i]` indicates that the `i`-th gas station is `position_i` miles from the starting position and has `fuel_i` liters of gas.
*Một chiếc xe đi từ vị trí bắt đầu đến một điểm đích cách đó `target` dặm. Có các trạm xăng dọc theo con đường. Các trạm xăng được biểu diễn dưới dạng mảng `stations`, trong đó `stations[i] = [position_i, fuel_i]` cho biết trạm xăng thứ `i` cách vị trí bắt đầu `position_i` dặm và có `fuel_i` lít xăng.*

The car starts with an infinite capacity fuel tank, which initially contains `startFuel` liters of fuel. It uses one liter of fuel per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
*Chiếc xe bắt đầu với bình nhiên liệu có dung tích vô hạn, ban đầu chứa `startFuel` lít xăng. Nó tiêu thụ một lít xăng cho mỗi dặm đi được. Khi xe đến trạm xăng, nó có thể dừng lại và đổ thêm xăng, chuyển toàn bộ xăng từ trạm vào xe.*

Return *the minimum number of refueling stops the car must make in order to reach its destination*. If it cannot reach the destination, return `-1`.
*Hãy trả về *số lần dừng tiếp nhiên liệu tối thiểu mà xe phải thực hiện để đến đích*. Nếu không thể đến đích, hãy trả về `-1`.*

Note that if the car reaches a gas station with `0` fuel left, the car can still refuel there. If the car reaches the destination with `0` fuel left, it is still considered to have arrived.
*Lưu ý rằng nếu xe đến trạm xăng khi còn đúng `0` lít xăng, xe vẫn có thể đổ thêm xăng tại đó. Nếu xe đến đích khi còn đúng `0` lít xăng, xe vẫn được coi là đã đến nơi.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** target = 1, startFuel = 1, stations = []
**Output:** 0
**Explanation:** We can reach the target without refueling.

## Example 2:
## *Ví dụ 2:*

**Input:** target = 100, startFuel = 1, stations = [[10, 100]]
**Output:** -1
**Explanation:** We could not reach the 10 mile mark.

## Example 3:
## *Ví dụ 3:*

**Input:** target = 100, startFuel = 10, stations = [[10, 60], [20, 30], [30, 30], [60, 40]]
**Output:** 2
**Explanation:** We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel. We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel), and refuel from 10 liters to 50 liters of gas. We then drive to target 100.
We made 2 refueling stops along the way, so we return 2.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= target, startFuel <= 10^9`
*   `0 <= stations.length <= 500`
*   `0 < stations[i][0] < stations[i+1][0] < target`
*   `1 <= stations[i][1] <= 10^9`
