# Result for Number of Provinces
# *Kết quả cho bài toán Số lượng Tỉnh thành*

## Description
## *Mô tả*

There are `n` cities. Some of them are connected, while some are not. If city `a` is connected directly with city `b`, and city `b` is connected directly with city `c`, then city `a` is connected indirectly with city `c`.
*Có `n` thành phố. Một số thành phố được kết nối với nhau, trong khi một số khác thì không. Nếu thành phố `a` kết nối trực tiếp với thành phố `b`, và thành phố `b` kết nối trực tiếp với thành phố `c`, thì thành phố `a` kết nối gián tiếp với thành phố `c`.*

A **province** is a group of directly or indirectly connected cities and no other cities outside of the group.
*Một **tỉnh** là một nhóm các thành phố được kết nối trực tiếp hoặc gián tiếp và không có thành phố nào khác ngoài nhóm đó.*

You are given an `n x n` matrix `isConnected` where `isConnected[i][j] = 1` if the `ith` city and the `jth` city are directly connected, and `isConnected[i][j] = 0` otherwise.
*Bạn được cho một ma trận `isConnected` kích thước `n x n` trong đó `isConnected[i][j] = 1` nếu thành phố thứ `i` và thành phố thứ `j` kết nối trực tiếp, và `isConnected[i][j] = 0` nếu ngược lại.*

Return *the total number of **provinces***.
*Trả về *tổng số lượng **tỉnh thành***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `isConnected = [[1,1,0],[1,1,0],[0,0,1]]`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `isConnected = [[1,0,0],[0,1,0],[0,0,1]]`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 200`
*   `n == isConnected.length`
*   `n == isConnected[i].length`
*   `isConnected[i][j]` is `1` or `0`.
*   `isConnected[i][i] == 1`
*   `isConnected[i][j] == isConnected[j][i]`
