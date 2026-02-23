# Result for Most Stones Removed with Same Row or Column
# *Kết quả cho bài toán Xoá nhiều Đá nhất cùng Hàng hoặc Cột*

## Description
## *Mô tả*

On a 2D plane, we place `n` stones at some integer coordinate points. Each coordinate point may have at most one stone.
*Trên một mặt phẳng 2D, chúng ta đặt `n` viên đá tại một số điểm tọa độ nguyên. Mỗi điểm tọa độ có thể có tối đa một viên đá.*

A stone can be removed if it shares either **the same row or the same column** as another stone that has not been removed.
*Một viên đá có thể được gỡ bỏ nếu nó chia sẻ **cùng hàng hoặc cùng cột** với một viên đá khác chưa bị gỡ bỏ.*

Given an array `stones` of length `n` where `stones[i] = [xi, yi]` represents the location of the `i`-th stone, return *the largest possible number of stones that can be removed*.
*Cho một mảng `stones` có độ dài `n` trong đó `stones[i] = [xi, yi]` đại diện cho vị trí của viên đá thứ `i`, hãy trả về *số lượng đá lớn nhất có thể được gỡ bỏ*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
**Output:** 5
**Explanation:** One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.

## Example 2:
## *Ví dụ 2:*

**Input:** stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
**Output:** 3
**Explanation:** One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.

## Example 3:
## *Ví dụ 3:*

**Input:** stones = [[0,0]]
**Output:** 0
**Explanation:** [0,0] is the only stone on the plane, so you cannot remove it.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= stones.length <= 1000`
*   `0 <= xi, yi <= 10^4`
*   No two stones are at the same coordinate point.
