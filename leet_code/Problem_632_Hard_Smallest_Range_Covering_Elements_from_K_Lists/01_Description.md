# Result for Smallest Range Covering Elements from K Lists
# *Kết quả cho bài toán Phạm vi Nhỏ nhất Chứa các Phần tử từ K Danh sách*

## Description
## *Mô tả*

You have `k` lists of sorted integers in **non-decreasing order**. Find the **smallest** range that includes at least one number from each of the `k` lists.
*Bạn có `k` danh sách các số nguyên đã được sắp xếp theo **thứ tự không giảm**. Hãy tìm phạm vi **nhỏ nhất** bao gồm ít nhất một số từ mỗi danh sách trong số `k` danh sách đó.*

We define the range `[a, b]` is smaller than range `[c, d]` if `b - a < d - c` or `a < c` if `b - a == d - c`.
*Chúng ta định nghĩa phạm vi `[a, b]` nhỏ hơn phạm vi `[c, d]` nếu `b - a < d - c` hoặc `a < c` nếu `b - a == d - c`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
**Output:** [20,24]
**Explanation:** 
List 1: [4, 10, 15, 24, 26], 24 is in range [20, 24].
List 2: [0, 9, 12, 20], 20 is in range [20, 24].
List 3: [5, 18, 22, 30], 22 is in range [20, 24].

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [[1,2,3],[1,2,3],[1,2,3]]
**Output:** [1,1]

---

## Constraints:
## *Ràng buộc:*

*   `nums.length == k`
*   `1 <= k <= 3500`
*   `1 <= nums[i].length <= 50`
*   `-10^5 <= nums[i][j] <= 10^5`
*   `nums[i]` is sorted in **non-decreasing order**.
