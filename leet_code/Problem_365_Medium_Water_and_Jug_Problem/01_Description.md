# Result for Water and Jug Problem
# *Kết quả cho bài toán Nước và Bình chứa*

## Description
## *Mô tả*

You are given two jugs with capacities `jug1Capacity` and `jug2Capacity` liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly `targetCapacity` liters using these two jugs.
*Bạn được cho hai chiếc bình với dung tích `jug1Capacity` và `jug2Capacity` lít. Có một lượng cung cấp nước vô tận. Hãy xác định xem có thể đong được chính xác `targetCapacity` lít bằng cách sử dụng hai chiếc bình này không.*

If `targetCapacity` liters of water are measurable, you must have `targetCapacity` liters of water contained within **one or both buckets** by the end.
*Nếu `targetCapacity` lít nước có thể đong được, bạn phải có `targetCapacity` lít nước nằm trong **một hoặc cả hai chiếc bình** vào thời điểm cuối cùng.*

Operations allowed:
*Các thao tác được phép:*

- Fill any of the jugs completely with water.
- Empty any of the jugs.
- Pour water from one jug into another till the other jug is full or the first jug is empty.

## Example 1:
## *Ví dụ 1:*

**Input:** `jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4`
**Output:** `true`
**Explanation:** The famous Die Hard example.

## Example 2:
## *Ví dụ 2:*

**Input:** `jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6`
