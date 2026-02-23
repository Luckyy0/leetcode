# Result for Queue Reconstruction by Height
# *Kết quả cho bài toán Tái cấu trúc Hàng đợi theo Chiều cao*

## Description
## *Mô tả*

You are given an array of people, `people`, which are the attributes of some people in a queue (not necessarily in order). Each `people[i] = [hi, ki]` represents the $i^{th}$ person of height `hi` with exactly `ki` other people in front who have a height greater than or equal to `hi`.
*Bạn được cho một mảng `people`, là các thuộc tính của một số người trong một hàng đợi (không nhất thiết theo thứ tự). Mỗi `people[i] = [hi, ki]` đại diện cho người thứ $i$ có chiều cao `hi` với đúng `ki` người khác ở phía trước có chiều cao lớn hơn hoặc bằng `hi`.*

Reconstruct and return the queue that is represented by the input array `people`. The returned queue should be formatted as an array `queue`, where `queue[j] = [hj, kj]` is the attributes of the $j^{th}$ person in the queue (`queue[0]` is the person at the front of the queue).
*Hãy tái cấu trúc và trả về hàng đợi được đại diện bởi mảng đầu vào `people`. Hàng đợi được trả về phải được định dạng dưới dạng mảng `queue`, trong đó `queue[j] = [hj, kj]` là các thuộc tính của người thứ $j$ trong hàng đợi (`queue[0]` là người ở đầu hàng).*

## Example 1:
## *Ví dụ 1:*

**Input:** `people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]`
**Output:** `[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]`
**Explanation:**
- Person 0 has height 5 with no one taller or the same height in front.
- Person 1 has height 7 with no one taller or the same height in front.
- Person 2 has height 5 with two people taller or the same height in front (person 0 and 1).
- Person 3 has height 6 with one person taller or the same height in front (person 1).
- Person 4 has height 4 with four people taller or the same height in front (people 0, 1, 2, and 3).
- Person 5 has height 7 with one person taller or the same height in front (person 1).

## Constraints:
## *Ràng buộc:*

*   `1 <= people.length <= 2000`
*   `0 <= hi <= 10^6`
*   `0 <= ki < people.length`
*   It is guaranteed that the queue can be reconstructed.
