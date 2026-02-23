# Analysis for Count of Smaller Numbers After Self
# *Phân tích cho bài toán Đếm số lượng Số nhỏ hơn Phía sau*

## 1. Problem Essence & Merge Sort
## *1. Bản chất vấn đề & Sắp xếp trộn*

### The Metric
### *Thước đo*
For each `i`, count `j > i` such that `nums[j] < nums[i]`.
Equivalent to counting inversions, but specifically tracking count for each index.
Merge Sort is naturally suited for this.

### Strategy: Merge Sort with Index Tracking
### *Chiến lược: Sắp xếp trộn với Theo dõi Chỉ số*
We need to sort the array, but keep track of original indices to update the `counts` array correctly.
Store pairs `(value, original_index)`.
During the `merge` phase of `leftPart` and `rightPart`:
Both parts are already sorted (ascending).
We iterate pointers `i` (left) and `j` (right).
- If `right[j] < left[i]`:
    - `right[j]` is smaller than `left[i]`.
    - It is also smaller than all subsequent elements in `left` (since `left` is sorted).
    - But importantly, `right[j]` moves to the front of the merged array. It "jumps" over `left[i]`.
    - We interpret this as: this element from Right is smaller than `left[i]`.
    - So we increment a `rightCounter` (counting how many right-elements have been processed/moved).
    - `merged.add(right[j])`. `j++`.
- If `left[i] <= right[j]`:
    - `left[i]` is placed.
    - At this moment, all elements from `right` that have been processed (`rightCounter` amount) are strictly smaller than `left[i]`.
    - So `counts[left[i].original_index] += rightCounter`.
    - `merged.add(left[i])`. `i++`.

### Alternative: Fenwick Tree (BIT)
### *Thay thế: Cây Fenwick (BIT)*
Coordinate compression values to `1..rank`.
Iterate from right to left.
`query(rank-1)` gives count of smaller elements seen so far.
`update(rank, 1)` adds current element.
$O(N \log N)$.
BIT is often cleaner to implement but requires handling negative numbers/compression. Merge Sort handles values inherently. Given constraint `-10^4` to `10^4`, range is `20000`. No compression needed really, just offset.
However, Merge Sort is a very educational structural modification.

I will implement Merge Sort as it requires no offset magic.

---

## 2. Approach: Merge Sort
## *2. Hướng tiếp cận: Sắp xếp trộn*

### Logic
### *Logic*
1.  `Item` class: `val`, `index`.
2.  `counts` array size `n`.
3.  `mergeSort(items)`.
    - Base case length <= 1.
    - Split mid. Recurse left, right.
    - Merge:
        - `rightCount = 0`.
        - `i=0, j=0`.
        - Compare `left[i].val` vs `right[j].val`.
        - If `right < left`: `rightCount++`. Add right.
        - Else: `counts[left[i].index] += rightCount`. Add left.
    - Drain remaining. If left remains, add `rightCount` to them.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Divide and Conquer:** Breaking problem into independent sorted subproblems.
    *Chia để trị: Chia bài toán thành các bài toán con đã sắp xếp độc lập.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[5, 2, 6, 1]`
Split: `[5, 2]` | `[6, 1]`
- Sort `[5, 2]`:
  Split `[5]`, `[2]`.
  Merge `[5]` (L), `[2]` (R).
  `2 < 5`: `rightCount=1`. Add 2.
  `5 >=`: `count[idx_5] += 1`. Add 5.
  Res: `[2, 5]`. count[0]=1.
- Sort `[6, 1]`:
  Res: `[1, 6]`. count[2]=1.
Merge `[2, 5]` (L) and `[1, 6]` (R).
- `1 < 2`: `rightCount=1`. Add 1.
- `2 <= 6` (actually compare 2 vs 6):
  `L[0]=2`. `rightCount=1`. `count[idx_2] += 1`. Add 2.
  Next `L` is 5.
- Next `R` is 6. `6 >= 5`.
  `L[1]=5`. `rightCount=1`. `count[idx_5] += 1` (Total 1+1=2). Add 5.
- Remaining `R`: 6.
Result counts: `5->2, 2->1, 6->1, 1->0`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Merge Sort modification is elegant.
*Sửa đổi Sắp xếp trộn rất thanh lịch.*
---
*Khi ta tiến về phía trước (sorting), ta có thể nhìn thấy những người đã bị bỏ lại phía sau (smaller elements). Sự sắp xếp mang lại trật tự và cả sự thấu hiểu vị thế.*
When we move forward (sorting), we can see those left behind (smaller elements). Order brings both structure and understanding of position.
