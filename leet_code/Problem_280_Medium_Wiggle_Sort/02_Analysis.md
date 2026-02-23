# Analysis for Wiggle Sort
# *Phân tích cho bài toán Sắp xếp Lắc lư*

## 1. Problem Essence & Local Swapping
## *1. Bản chất vấn đề & Hoán đổi cục bộ*

### The Pattern
### *Mẫu*
Index: 0 1 2 3 4 5
Rel:   <= >= <= >= <=

Observe:
- If `i` is odd: `nums[i] >= nums[i-1]`.
- If `i` is even: `nums[i] <= nums[i-1]`.

### Strategy: One Pass Swap
### *Chiến lược: Hoán đổi một lượt*
Iterate `i` from 0 to `n-2`.
- If `i` is even: We want `nums[i] <= nums[i+1]`. If `nums[i] > nums[i+1]`, swap.
- If `i` is odd: We want `nums[i] >= nums[i+1]`. If `nums[i] < nums[i+1]`, swap.

Why does this work?
Suppose we just fixed `i`. `nums[i]` satisfies relation with `nums[i-1]`.
Now we check `i` and `i+1`.
If we swap `nums[i]` and `nums[i+1]`, does it break relation at `i-1`?
Example: `i` odd (so `nums[i-1] <= nums[i]`). We want `nums[i] >= nums[i+1]`.
If `nums[i] < nums[i+1]`, we swap. New `nums[i]` is bigger than old `nums[i]`.
Since old `nums[i] >= nums[i-1]`, new `nums[i]` (which is even bigger) definitely `>= nums[i-1]`.
It preserves the past!

---

## 2. Approach: Greedy Swapping
## *2. Hướng tiếp cận: Hoán đổi Tham lam*

### Logic
### *Logic*
1.  Loop `i` from 0 to `n-2`.
2.  If `i % 2 == 0`:
    - If `nums[i] > nums[i+1]`: Swap.
3.  Else (`i % 2 == 1`):
    - If `nums[i] < nums[i+1]`: Swap.
4.  Reference done.

Actually, loop can look at `i` and `i-1` starting from 1.
Loop `i` from 1 to `n-1`:
- If `i` is odd and `nums[i] < nums[i-1]`: Swap.
- If `i` is even and `nums[i] > nums[i-1]`: Swap.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Locality:** Fixing the current pair implicitly respects the previous constraint due to the direction of inequality.
    *Tính cục bộ: Việc sửa cặp hiện tại ngầm định tôn trọng ràng buộc trước đó do hướng của bất đẳng thức.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 5, 2, 1, 6, 4]`
1.  `i=0` (even). Want `<=` next `(3, 5)`. 3<=5. OK.
2.  `i=1` (odd). Want `>=` next `(5, 2)`. 5>=2. OK.
3.  `i=2` (even). Want `<=` next `(2, 1)`. 2>1. Swap -> `[3, 5, 1, 2, 6, 4]`.
    - Check back: `5 >= 1`? Yes.
4.  `i=3` (odd). Want `>=` next `(2, 6)`. 2<6. Swap -> `[3, 5, 1, 6, 2, 4]`.
    - Check back: `1 <= 6`? Yes.
5.  `i=4` (even). Want `<=` next `(2, 4)`. 2<=4. OK.
Result: `[3, 5, 1, 6, 2, 4]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple greedy algorithm.
*Thuật toán tham lam đơn giản.*
---
*Cuộc sống giống như Wiggle Sort: lên rồi xuống, xuống rồi lên. Quan trọng là duy trì sự cân bằng động trong mỗi bước đi.*
Life is like Wiggle Sort: up then down, down then up. The key is maintaining dynamic balance in every step.
