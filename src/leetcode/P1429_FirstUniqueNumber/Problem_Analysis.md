# 1429. First Unique Number / Số Duy nhất Đầu tiên

## Problem Description / Mô tả bài toán
Class `FirstUnique`.
- `FirstUnique(int[] nums)`
- `showFirstUnique()`: return value of first unique. -1 if none.
- `add(value)`: append value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Doubly Linked List + HashMap
Maintain order of unique numbers using a LinkedHashSet or Queue.
Since we need to remove elements that become non-unique:
HashMap `num -> count`? Or `num -> node`.
If count becomes > 1, remove from list.
Better:
Set `all` (seen numbers).
Set `duplicates` (repeated numbers).
LinkedHashSet `uniques` (candidates in order).
`add(val)`:
- If `duplicates` contains val: do nothing (already bad).
- If `uniques` contains val: remove from `uniques`, add to `duplicates`.
- Else: add to `uniques` (and `all`? `duplicates` logic covers `all` if we check `duplicates` first. Wait. We need to distinguish "seen once" vs "seen zero").
Correct Logic:
Map `val -> status` (unique, duplicate).
Or Set `unique`, Set `seen`.
LinkedHashSet for `unique` (preserves insertion order).
- `add(x)`:
  - If `seen` contains `x`:
    - If `unique` contains `x`: remove `x`. (Now it's duplicate).
  - Else:
    - Add to `seen`. Add to `unique`.
`showFirstUnique()`: return `unique.iterator().next()`.

Queue approach (lazier):
Queue `q` stores candidates. Map `count`.
`add(x)`: `count[x]++`. `q.add(x)`.
`show()`: while `q` not empty and `count[q.peek()] > 1`, `q.poll()`. Return `q.peek()`.

### Complexity / Độ phức tạp
- **Time**: `add` O(1), `show` O(1) amortized.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Queue + Map
Maintain a Map to count frequencies of all numbers. Maintain a Queue to store numbers in order of arrival.
When `showFirstUnique()` is called:
Check the head of the Queue. If its count in Map is > 1, it's no longer unique, so remove it. Repeat until head is unique or Queue is empty.
If unique, return it. If empty, return -1.
(Lazy removal strategy).
Duy trì Bản đồ để đếm tần suất của tất cả các số. Duy trì một Hàng đợi để lưu trữ các số theo thứ tự đến.
Khi `showFirstUnique()` được gọi:
Kiểm tra phần đầu của Hàng đợi. Nếu số lượng của nó trong Bản đồ > 1, nó không còn là duy nhất, vì vậy hãy xóa nó. Lặp lại cho đến khi phần đầu là duy nhất hoặc Hàng đợi trống.
Nếu duy nhất, trả lại. Nếu trống, trả về -1.

---
