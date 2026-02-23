# Analysis for Range Sum Query - Mutable
# *Phân tích cho bài toán Truy vấn Tổng trong Phạm vi - Có thể thay đổi*

## 1. Problem Essence & Fenwick Tree
## *1. Bản chất vấn đề & Cây Fenwick*

### The Challenge
### *Thách thức*
Points updates + Range sums.
Naive Array: Update $O(1)$, Sum $O(N)$. Slow sum.
Prefix Sum Array: Update $O(N)$, Sum $O(1)$. Slow update.
We need balanced structure.
Segment Tree or Binary Indexed Tree (Fenwick Tree).
BIT is easier to implement (less code), faster constant factors, $O(N)$ space.

### Strategy: Binary Indexed Tree (BIT)
### *Chiến lược: Cây Chỉ số Nhị phân (BIT)*
BIT stores partial sums. `tree[i]` stores sum of range `[?, i]`.
Operation logic:
- `i & (-i)` extracts the lowest set bit.
- `update(i, delta)`: Add delta to `i`, then `i += i & (-i)` (climb up).
- `query(i)`: Sum at `i`, then `i -= i & (-i)` (climb down/left).
Index mapping: BIT is 1-based usually. Input is 0-based.
Map input index `i` to BIT index `i+1`.

We also need to store the original `nums` array to calculate `delta` during update (`newVal - oldVal`).

---

## 2. Approach: Fenwick Tree
## *2. Hướng tiếp cận: Cây Fenwick*

### Logic
### *Logic*
1.  Constructor: Init `tree` size `n+1`. Build tree by calling `update` for each element. Or stricter O(N) build. $O(N \log N)$ init is fine.
2.  `update(index, val)`:
    - `delta = val - nums[index]`.
    - `nums[index] = val`.
    - `add(index + 1, delta)`.
3.  `sumRange(left, right)`:
    - `query(right + 1) - query(left)`.

### Helper `add(i, val)`
### *Hàm trợ giúp `add(i, val)`*
Loop `while i <= n`: `tree[i] += val`, `i += i & (-i)`.

### Helper `query(i)`
### *Hàm trợ giúp `query(i)`*
Loop `while i > 0`: `sum += tree[i]`, `i -= i & (-i)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Balance:** $O(\log N)$ for both operations.
*   **Compact:** Only an array.
    *Cân bằng: O(log N) cho cả hai thao tác. Gọn nhẹ: Chỉ cần một mảng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Init $O(N \log N)$, Ops $O(\log N)$.
    *Độ phức tạp thời gian: Khởi tạo O(N log N), Theo tác O(log N).*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: O(N).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 3, 5]`
Tree (size 4).
Update 1 (idx 0->1): Tree[1]+=1, Tree[2]+=1, Tree[4]+=1.
Update 3 (idx 1->2): Tree[2]+=3, Tree[4]+=3.
Update 5 (idx 2->3): Tree[3]+=5, Tree[4]+=5.
Tree state roughly: `[0, 1, 4, 5, 9]`.
(Actually `tree[1]=1, tree[2]=4 (1+3), tree[3]=5, tree[4]=9 (1+3+5)`).

Query(0, 2) -> Query(3) - Query(0).
Q(3): `tree[3] + tree[2]`? No.
3 is `11` binary.
Loop 1: `i=3`. `sum += tree[3] (5)`. `i -= 1` -> 2.
Loop 2: `i=2`. `sum += tree[2] (4)`. `i -= 2` -> 0.
Sum = 9. Correct.

Update(1, 2). Old 3. Delta -1.
Add(2, -1). `tree[2] -= 1` -> 3. `tree[4] -= 1` -> 8.
Query(0, 2) -> 8. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard BIT implementation.
*Cài đặt BIT tiêu chuẩn.*
---
*Khả năng thay đổi (mutable) đòi hỏi sự linh hoạt. Cấu trúc cây (BIT) cho phép cập nhật cục bộ mà vẫn duy trì được cái nhìn toàn cục (sum).*
Mutability requires flexibility. The tree structure (BIT) allows local updates while maintaining the global view (sum).
