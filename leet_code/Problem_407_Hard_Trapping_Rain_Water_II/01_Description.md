# Result for Trapping Rain Water II
# *Kết quả cho bài toán Hứng nước mưa II*

## Description
## *Mô tả*

Given an `m x n` integer matrix `heightMap` representing the height of each unit cell in a 2D elevation map, return *the volume of water it can trap after raining*.
*Cho một ma trận số nguyên `m x n` `heightMap` đại diện cho chiều cao của từng ô trong một bản đồ độ cao 2D, hãy trả về *thể tích nước mà nó có thể hứng được sau khi trời mưa*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]`
**Output:** `4`
**Explanation:** After the rain, water is trapped between the blocks.
We can trap 4 units of water.

## Example 2:
## *Ví dụ 2:*

**Input:** `heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]`
**Output:** `10`

## Constraints:
## *Ràng buộc:*

*   `m == heightMap.length`
*   `n == heightMap[i].length`
*   `1 <= m, n <= 200`
*   `0 <= heightMap[i][j] <= 2 * 10^4`
