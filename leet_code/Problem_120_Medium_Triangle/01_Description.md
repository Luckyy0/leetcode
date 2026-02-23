# Result for Triangle
# *Kết quả cho bài toán Tam Giác*

## Description
## *Mô tả*

Given a `triangle` array, return *the minimum path sum from top to bottom*.
*Cho một mảng `triangle`, hãy trả về *tổng đường đi tối thiểu từ đỉnh xuống đáy***.*

For each step, you may move to an adjacent number of the row below. More formally, if you are on index `i` on the current row, you may move to either index `i` or index `i + 1` on the next row.
*Đối với mỗi bước, bạn có thể di chuyển đến một số liền kề của hàng bên dưới. Một cách trang trọng hơn, nếu bạn đang ở chỉ số `i` trên hàng hiện tại, bạn có thể di chuyển đến chỉ số `i` hoặc chỉ số `i + 1` trên hàng tiếp theo.*

## Example 1:
## *Ví dụ 1:*

**Input:** `triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]`
**Output:** `11`
**Explanation:** The triangle looks like:
   **2**
  **3** 4
 6 **5** 7
4 **1** 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

## Example 2:
## *Ví dụ 2:*

**Input:** `triangle = [[-10]]`
**Output:** `-10`

## Constraints:
## *Ràng buộc:*

*   `1 <= triangle.length <= 200`
*   `triangle[0].length == 1`
*   `triangle[i].length == triangle[i - 1].length + 1`
*   `-10^4 <= triangle[i][j] <= 10^4`

## Follow up:
*   Could you do this using only $O(n)$ extra space, where $n$ is the total number of rows in the triangle?
