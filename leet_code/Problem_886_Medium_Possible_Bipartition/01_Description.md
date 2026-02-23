# Result for Possible Bipartition
# *Kết quả cho bài toán Phân chia Nhị phân Có thể*

## Description
## *Mô tả*

We want to split a group of `n` people (labeled from `1` to `n`) into two groups of **any size**. Each person may dislike some other people, and they should not go into the same group.
*Chúng ta muốn chia một nhóm `n` người (được đánh số từ `1` đến `n`) thành hai nhóm có **kích thước bất kỳ**. Mỗi người có thể không thích một số người khác, và họ không nên ở trong cùng một nhóm.*

Given the integer `n` and an array `dislikes` where `dislikes[i] = [a_i, b_i]` indicates that the person labeled `a_i` does not like the person labeled `b_i`, return `true` *if it is possible to split everyone into two groups in this way*.
*Cho số nguyên `n` và một mảng `dislikes` trong đó `dislikes[i] = [a_i, b_i]` chỉ ra rằng người có nhãn `a_i` không thích người có nhãn `b_i`, hãy trả về `true` *nếu có thể chia mọi người thành hai nhóm theo cách này*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 4, dislikes = [[1,2],[1,3],[2,4]]
**Output:** true
**Explanation:** group1 [1,4], group2 [2,3]

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3, dislikes = [[1,2],[1,3],[2,3]]
**Output:** false

## Example 3:
## *Ví dụ 3:*

**Input:** n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2000`
*   `0 <= dislikes.length <= 10^4`
*   `dislikes[i].length == 2`
*   `1 <= dislikes[i][j] <= n`
*   `ai < bi`
*   All the pairs of dislikes are unique.
