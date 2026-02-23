# Analysis for Random Flip Matrix
# *Phân tích cho bài toán Lật Ma trận Ngẫu nhiên*

## 1. Problem Essence & Sparse Mapping
## *1. Bản chất vấn đề & Ánh xạ Thưa thớt*

### The Challenge
### *Thách thức*
Randomly selecting available slots in a huge logical grid ($10^4 \times 10^4 = 10^8$) efficiently.
- Using a 2D array is $O(M \cdot N)$ space ($10^8$ ints/bits), too large.
- We perform very few flips (1000) relative to total size.
- Need efficient random selection without rejection sampling (which gets slow as grid fills up, though here it stays empty mostly).
- Wait, rejection sampling works if usage is low. But if we flip many times, we must guarantee coverage.
- Problem: "All indices ... equally likely".
- Fisher-Yates shuffle logic is ideal for "draw without replacement".

### Strategy: Map-based Fisher-Yates
### *Chiến lược: Fisher-Yates dựa trên Map*

1.  **Virtual Array:** Treat grid as 1D array `0` to `total - 1`.
2.  **Tracking Size:** `total` tracks available slots.
3.  **Draw:**
    - Pick random index `r` in `[0, total - 1]`.
    - The value at `r` is the chosen coordinate.
    - To "remove" `r`, we swap the value at `r` with the value at `total - 1` (last available).
    - Decrement `total`.
4.  **Sparse Storage:**
    - Since most values are index=value, we only store exceptions in a `HashMap`.
    - If `map` contains `r`, use it. Else use `r`.
    - To swap with `last`: If `map` contains `last`, use it.
    - Update `map`: `map.put(r, val_at_last)`.
    - `map.remove(last)`? Actually we just need to ensure `r` maps to something fresh. The `last` index is now effectively 'garbage' (flipped).

---

## 2. Approach: Hash Map Swapping
## *2. Hướng tiếp cận: Hoán đổi Hash Map*

### Logic
### *Logic*
(See above).
`flip()`:
- `r = rand.nextInt(total)`.
- `target = map.getOrDefault(r, r)`.
- `map.put(r, map.getOrDefault(total - 1, total - 1))`.
- `total--`.
- Return `[target / n, target % n]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Space Efficient:** $O(K)$ where K is number of flips.
    *Hiệu quả không gian: $O(K)$.*
*   **Time Efficient:** $O(1)$ per flip.
    *Hiệu quả thời gian: $O(1)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ average.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(K)$.
    *Độ phức tạp không gian: $O(K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Total 5. Map {}**
1. Rand 2. Val 2. Swap 2 with 4. Map `{2: 4}`. Total 4. Return 2.
2. Rand 2. Val `map.get(2)=4`. Swap 2 with 3. Map `{2: 3}`. Total 3. Return 4.
3. ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Map actual positions to the end of the logical array.
*Ánh xạ các vị trí thực tế vào cuối mảng logic.*
---
*Trong một không gian mênh mông (m x n), sự ngẫu nhiên (random) cần được quản lý để đảm bảo công bằng. Bằng cách hoán đổi (flip) những vị trí đã chọn với những vị trí cuối cùng (tail), ta thu hẹp dần không gian tìm kiếm mà không cần phải ghi nhớ tất cả những khoảng trống vô tận.*
In a vast space (M x N), randomness (Random) needs to be managed to ensure fairness. By swapping (Flip) selected positions with last positions (Tail), we gradually narrow the search space without having to remember all the endless gaps.
