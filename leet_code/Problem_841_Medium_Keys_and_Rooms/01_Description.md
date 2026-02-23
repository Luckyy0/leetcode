# Result for Keys and Rooms
# *Kết quả cho bài toán Chìa khóa và Căn phòng*

## Description
## *Mô tả*

There are `n` rooms labeled from `0` to `n - 1` and all the rooms are locked except for room `0`. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
*Có `n` căn phòng được đánh số từ `0` đến `n - 1` và tất cả các phòng đều bị khóa ngoại trừ phòng `0`. Mục tiêu của bạn là tham quan tất cả các phòng. Tuy nhiên, bạn không thể vào một phòng đang bị khóa nếu không có chìa khóa của nó.*

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock other rooms.
*Khi bạn tham quan một căn phòng, bạn có thể tìm thấy một bộ các chìa khóa riêng biệt trong đó. Mỗi chìa khóa có một con số trên đó, cho biết nó mở căn phòng nào, và bạn có thể mang tất cả chúng theo để mở các phòng khác.*

Given an array `rooms` where `rooms[i]` is the set of keys that you can obtain if you visited room `i`, return `true` *if you can visit all the rooms, or* `false` *otherwise*.
*Cho một mảng `rooms` trong đó `rooms[i]` là bộ chìa khóa bạn có thể nhận được nếu tham quan phòng `i`, hãy trả về `true` *nếu bạn có thể tham quan tất cả các phòng, ngược lại trả về* `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** rooms = [[1],[2],[3],[]]
**Output:** true
**Explanation:** 
We visit room 0 and get key 1.
We use key 1 to open room 1 and get key 2.
We use key 2 to open room 2 and get key 3.
We use key 3 to open room 3.
Since we were able to visit every room, we return true.

## Example 2:
## *Ví dụ 2:*

**Input:** rooms = [[1,3],[3,0,1],[2],[0]]
**Output:** false
**Explanation:** We can not enter room 2 since the only key that unlocks it is in room 2 itself.

---

## Constraints:
## *Ràng buộc:*

*   `n == rooms.length`
*   `2 <= n <= 1000`
*   `0 <= rooms[i].length <= 1000`
*   `1 <= sum(rooms[i].length) <= 3000`
*   `0 <= rooms[i][j] < n`
*   All the values of `rooms[i]` are **unique**.
