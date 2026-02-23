# Analysis for Contains Duplicate III
# *Phân tích cho bài toán Chứa bản sao III*

## 1. Problem Essence & Range Query
## *1. Bản chất vấn đề & Truy vấn phạm vi*

### The Question
### *Câu hỏi*
Is there any pair `(i, j)` with `j - i <= k` (index constraint) such that `nums[i] - t <= nums[j] <= nums[i] + t` (value constraint)?
*Có cặp `(i, j)` nào với khoảng cách chỉ số $\le k$ và khác biệt giá trị $\le t$ không?*

### The Sliding Window
### *Cửa sổ trượt*
Just like Problem 219, we maintain a sliding window of size `indexDiff` (`k`). The difference is that instead of finding an *exact match*, we need to find a distinct number within a *value range*.

If we sort the window, we can binary search. But adding/removing elements in a sorted array is $O(K)$.
We need a structure that supports:
1.  Insert/Remove in $O(\log K)$.
2.  Search for a value in range $[x - t, x + t]$ in $O(\log K)$.

A **Binary Search Tree (BST)**, specifically a **TreeSet** in Java, fits perfectly.
*Tương tự Bài 219, nhưng thay vì khớp chính xác, cần khớp trong phạm vi giá trị. TreeSet hỗ trợ chèn/xóa và tìm kiếm phạm vi trong $O(\log K)$.*

---

## 2. Approach 1: TreeSet (Balanced BST)
## *2. Hướng tiếp cận 1: TreeSet (BST Cân bằng)*

### Logic
### *Logic*
1.  Initialize `TreeSet<Long> set`. (Use `Long` to avoid integer overflow when doing `nums[i] + t`).
2.  Iterate `i` from 0 to `n`:
    - Find the smallest number in set that is $\ge nums[i] - valueDiff$. This is `set.ceiling(nums[i] - valueDiff)`.
    - If found value `s` exists and `s <= nums[i] + valueDiff`:
        - We found a valid neighbor! Return `true`.
    - Add `nums[i]` to set.
    - If `set.size() > indexDiff`:
        - Remove `nums[i - indexDiff]`.
3.  Return `false`.

---

## 3. Approach 2: Bucketing (O(N))
## *3. Hướng tiếp cận 2: Phân nhóm (O(N))*

### The Genius Move
### *Nước đi thiên tài*
We can put numbers into buckets of width `valueDiff + 1`.
- `bucketID = num / (valueDiff + 1)`.
- If two numbers fall in the same bucket, their diff is definitely $\le valueDiff$.
- If they fall in adjacent buckets, their diff *might* be $\le valueDiff$.
- If they are far apart, no chance.

We keep a `Map<Long, Long>` of `BucketID -> value`.
At any time, we only keep the "most recent" value for each bucket inside the sliding window `k`.
*Chia các số vào các thùng có độ rộng `valueDiff + 1`. Nếu hai số rơi vào cùng một thùng, hiệu của chúng $\le valueDiff$. Nếu ở thùng liền kề, có thể thỏa mãn. Chỉ cần kiểm tra thùng hiện tại và 2 thùng lân cận.*

This gives $O(N)$ because map operations are $O(1)$.
*Độ phức tạp $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **TreeSet:** $O(N \log (\min(N, K)))$.
*   **Bucketing:** $O(N)$.
*   **Space:** $O(\min(N, K))$.

---

## 5. Visualized Dry Run (TreeSet)
## *5. Chạy thử bằng hình ảnh (TreeSet)*

**Input:** `nums=[1, 5, 9, 1, 5, 9]`, `k=2`, `t=3`

1.  i=0 (1). Set `{1}`.
2.  i=1 (5). Search range $[5-3, 5+3] = [2, 8]$. `ceiling(2)` is 5? No, set has 1. `ceiling` returns null. Add 5. Set `{1, 5}`.
3.  i=2 (9). Range $[6, 12]$. `ceiling(6)` -> null. Add 9. Set `{1, 5, 9}`. Remove `nums[0]=1`. Set `{5, 9}`.
4.  i=3 (1). Range $[-2, 4]$. `ceiling(-2)`? No element. Add 1. Set `{1, 5, 9}`. Remove `nums[1]=5`. Set `{1, 9}`.
    ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

In an interview, the TreeSet solution is easier to derive and explain ($O(N \log K)$ is acceptable). The Bucket solution is superior ($O(N)$) but requires careful offset logic handling (especially for negative numbers). I will implement the TreeSet solution as it's more standard for "Range Query + Update" problems.
*Trong phỏng vấn, giải pháp TreeSet dễ giải thích hơn. Giải pháp Thùng ưu việt hơn nhưng cần xử lý logic offset cẩn thận. Tôi sẽ triển khai TreeSet vì nó tiêu chuẩn cho các bài toán "Truy vấn phạm vi + Cập nhật".*
---
*Đôi khi hàng xóm (neighbor) không nhất thiết phải ở ngay sát vách, chỉ cần họ ở "đủ gần" về cả khoảng cách lẫn giá trị.*
Sometimes neighbors don't have to be right next door, as long as they are "close enough" in both distance and value.
