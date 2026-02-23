# Result for K Closest Points to Origin
# *Kết quả cho bài toán K Điểm Gần Gốc Tọa độ Nhất*

## Description
## *Mô tả*

Given an array of `points` where `points[i] = [xi, yi]` represents a point on the **X-Y** plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.
*Cho một mảng các `điểm`, trong đó `points[i] = [xi, yi]` biểu diễn một điểm trên mặt phẳng **X-Y** và một số nguyên `k`, hãy trả về `k` điểm gần gốc tọa độ `(0, 0)` nhất.*

The distance between two points on the **X-Y** plane is the Euclidean distance (i.e., $\sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$).
*Khoảng cách giữa hai điểm trên mặt phẳng **X-Y** là khoảng cách Euclid (tức là $\sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$).*

You may return the answer in **any order**. The answer is **guaranteed** to be **unique** (except for the order that it is in).
*Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**. Câu trả lời được **đảm bảo** là **duy nhất** (ngoại trừ thứ tự của nó).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** points = [[1,3],[-2,2]], k = 1
**Output:** [[-2,2]]
**Explanation:**
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

## Example 2:
## *Ví dụ 2:*

**Input:** points = [[3,3],[5,-1],[-2,4]], k = 2
**Output:** [[3,3],[-2,4]]
**Explanation:** The answer [[-2,4],[3,3]] would also be accepted.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= points.length <= 10^4`
*   `-10^4 < xi, yi < 10^4`
