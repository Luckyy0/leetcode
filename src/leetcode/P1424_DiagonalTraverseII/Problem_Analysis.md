# 1424. Diagonal Traverse II / Duyệt Đường chéo II

## Problem Description / Mô tả bài toán
2D List `nums` (jagged array).
Traverse diagonals from bottom-left to top-right.
Order: Group by `i + j`. Inside group, order by `j` increasing (or `i` decreasing).
Wait, problem example shows `[0,0]`, `[1,0], [0,1]`...
This is same diagonal `i+j`.
Within same diagonal: elements with larger row index come first. (e.g. `[1,0]` comes before `[0,1]`).
So order by `sum = i+j` ASC, then `i` DESC (or `j` ASC, if `i+j` is constant, `i` decreasing means `j` increasing). Wait.
`[1,0]` (sum 1, row 1), `[0,1]` (sum 1, row 0). So yes, larger row first.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / Grouping by Sum
Similar to typical diagonal traversal.
Key challenges: Jagged array (rows have different lengths) & Space efficiency.
If we iterate `i` then `j` and add to a bucket `List[sum]`:
- Elements added in order: row 0 first, row 1 next.
- For `sum = S`, we encounter `(0, S), (1, S-1), ...`
- This is `i` increasing order.
- But we need `i` DECREASING order.
So we can just reverse the list for each diagonal? No, jagged array means checking `(i, j)` might be out of bounds if loops are standard.
But if we iterate input:
- Row 0 items: `nums[0][j]`. Add to bucket `0+j`.
- Row 1 items: `nums[1][j]`. Add to bucket `1+j`.
Since we process row 0 then row 1...
For a bucket `S`: `(0, S)` added first, then `(1, S-1)`...
Result in bucket: `[(0, S), (1, S-1)...]`. `i` increasing.
We need `i` decreasing.
So:
1. Collect in buckets.
2. For each bucket, read from end to start? No, just add to head of list or reverse?
Or Process rows from `n-1` to `0`. Then `i` decreases naturally.

### Complexity / Độ phức tạp
- **Time**: O(N) (total elements).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: BFS with Queue / Sorting
Approach 1: BFS. Enqueue `(0, 0)`. While queue not empty, poll `(r, c)`, add values. Add `(r+1, c)` and `(r, c+1)`. Use `visited` set. Order is `(r+1, c)` before `(r, c+1)` to prioritize bottom-left.
Wait. Standard BFS actually traverses layers by distance `i+j`.
With `(r+1, c)` enqueued before `(r, c+1)`, we will explore higher `r` first for same `i+j`.
This handles jagged arrays and missing elements perfectly because we only enqueue valid neighbors.
Valid neighbor check: `c == 0` for `(r+1, c)`? To avoid duplicates.
Actually, if we enqueue `(r+1, c)` only when `c == 0`, and `(r, c+1)` always...
Let's see: `(0,0)` -> `(1,0), (0,1)`.
`(1,0)` -> `(2,0), (1,1)`.
`(0,1)` -> `(1,1), (0,2)`.
Duplicate `(1,1)` problem.
Standard way: enqueue `(r+1, c)` ONLY if `c == 0`. Enqueue `(r, c+1)` ALWAYS.
This covers all nodes unique?
- `(0,0)` gives `(1,0)` and `(0,1)`.
- `(1,0)` gives `(2,0)` and `(1,1)`.
- `(0,1)` gives `(0,2)`. (`1,1` not added by this).
Yes. All nodes covered exactly once.

Approach 2: Collecting
Total elements `T`.
Iterate all elements, store tuple `(sum, row, val)`. Sort tuples. O(T log T). Slower.

Approach 3: List of Lists
`Map<Integer, List<Integer>>`.
Iterate `row` from `n-1` to `0`.
For `col` in `row`: add to `map.get(row+col)`.
Because we go `n-1` to `0`, larger row indices are added first.
So `map.get(sum)` will have elements in `i` decreasing order.
Then Flatten. This is O(T).
Lặp `row` từ `n-1` đến `0`.
Đối với `col` trong `row`: thêm vào `map.get(row+col)`.
Vì chúng ta đi từ `n-1` đến `0`, các chỉ số hàng lớn hơn được thêm vào trước.
Vì vậy `map.get(sum)` sẽ có các phần tử theo thứ tự giảm dần `i`.
Sau đó Flatten. Đây là O(T).

---
