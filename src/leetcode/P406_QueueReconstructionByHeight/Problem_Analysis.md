# 406. Queue Reconstruction by Height / Tái Cấu Trúc Hàng Đợi Theo Chiều Cao

## Problem Description / Mô tả bài toán
You are given an array of people, `people`, which are the attributes of some people in a queue (not necessarily in order). Each `people[i] = [hi, ki]` represents the `i-th` person of height `hi` with exactly `ki` other people in front who have a height greater than or equal to `hi`.
Bạn được cho một mảng `people`, là các thuộc tính của một số người trong một hàng đợi (không nhất thiết theo thứ tự). Mỗi `people[i] = [hi, ki]` đại diện cho người thứ `i` có chiều cao `hi` với đúng `ki` người khác đứng trước họ có chiều cao lớn hơn hoặc bằng `hi`.

Reconstruct and return the queue that is represented by the input array `people`. The returned queue should be formatted as an array `queue`, where `queue[j] = [hj, kj]` is the attributes of the `j-th` person in the queue.
Hãy tái cấu trúc và trả về hàng đợi được đại diện bởi mảng đầu vào `people`. Hàng đợi trả về phải được định dạng dưới dạng một mảng `queue`, trong đó `queue[j] = [hj, kj]` là các thuộc tính của người thứ `j` trong hàng đợi.

### Example 1:
```text
Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
- Person [5,0] has 0 people taller or equal in front.
- Person [7,0] has 0 people taller or equal in front.
- Person [5,2] has [5,0] and [7,0] taller or equal in front.
- Person [6,1] has [7,0] taller or equal in front. (Note: [5,x] is shorter than [6,1])
- Person [4,4] has [5,0], [7,0], [5,2], [6,1] taller or equal in front.
- Person [7,1] has [7,0] taller or equal in front.
```

### Example 2:
```text
Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
```

## Constraints / Ràng buộc
- `1 <= people.length <= 2000`
- `0 <= hi <= 10^6`
- `0 <= ki < people.length`
- It is guaranteed that the queue can be reconstructed.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Approach / Phương pháp Tham lam
The strategy is to handle taller people first, as their positions are not affected by shorter people in the queue.

Algorithm:
1. Sort the `people` array:
   - Primarily by height in descending order.
   - Secondarily by `k` value in ascending order (if heights are equal, the person with smaller `k` should come first).
2. Create an empty list (to represent the reconstructed queue).
3. Iterate through the sorted `people`:
   - Insert each person into the list at the index equal to their `k` value.
4. Convert the list back to an array and return it.

Why it works:
When we insert a person with attributes `[h, k]` into the list at index `k`, all people already in the list are either taller than `h` or equal to `h` (because of the sorting). Therefore, by placing this person at index `k`, they will have exactly `k` people in front of them in the final queue.

### Complexity / Độ phức tạp
- **Time**: O(N^2) because list insertion (at a specific index) takes O(N) time in an ArrayList.
- **Space**: O(N) to store the result list.

---

## Analysis / Phân tích

### Approach: Sort and Insert

**Algorithm**:
1.  Implement a `Comparator` for the specific sorting requirements.
2.  Use `List.add(index, element)`.

---
