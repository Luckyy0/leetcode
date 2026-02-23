# Analysis for 3Sum Smaller
# *Phân tích cho bài toán 3Sum Nhỏ hơn*

## 1. Problem Essence & Two Pointers
## *1. Bản chất vấn đề & Hai con trỏ*

### The Naive Way
### *Cách ngây thơ*
3 nested loops. $O(N^3)$. With $N=3500$, $N^3 \approx 4 \times 10^{10}$, way too slow.
We need $O(N^2)$ or better.

### The Sorted Strategy
### *Chiến lược sắp xếp*
Since we need `sum < target` and order of indices `i < j < k` matters for *counting* but values can be rearranged if we only care about *combinations*.
Wait, problem asks for index triplets `i < j < k`.
BUT, scrambling the array changes indices.
Does reordering affect the *count* of valid triplets?
A triplet `{v1, v2, v3}` such that $v1+v2+v3 < T$ corresponds to indices in original array.
Yes, the count of sets of values is invariant.
E.g., `[-2, 0, 1]` satisfies. If we sort `[-2, 0, 1, 3]`, we find triplet values `[-2, 0, 1]` and `[-2, 0, 3]`.
Since all combinations of indices pointing to these values are valid? No, we need distinct indices.
Sorting preserves the *bag of numbers*. Any triplet picked from the sorted bag corresponds to valid indices in original bag (assuming distinct or handled correctly).
So YES, we can sort.

### Two Pointers Logic
### *Logic Hai con trỏ*
1.  Sort `nums`.
2.  Iterate `i` from 0 to `n-2`.
3.  Target for remaining two: `target - nums[i]`.
4.  Set `left = i + 1`, `right = n - 1`.
5.  If `nums[left] + nums[right] < remaining`:
    - This is the magic part.
    - If `sum < target`, then `nums[left]` plus ANY element from `left+1` to `right` will also be `< target` (since `nums[right]` was the largest).
    - So, we have `right - left` pairs valid for this specific `left`.
    - Count += `right - left`.
    - `left++` (Try a larger first number).
6.  Else (`sum >= target`):
    - `right--` (We need smaller sum).

---

## 2. Approach: Sorting + Two Pointers
## *2. Hướng tiếp cận: Sắp xếp + Hai con trỏ*

### Logic
### *Logic*
- `count = 0`
- Sort `nums`
- Loop `i`:
    - `l = i+1, r = n-1`
    - While `l < r`:
        - `sum = nums[i] + nums[l] + nums[r]`
        - if `sum < target`:
            - `count += (r - l)`
            - `l++`
        - else:
            - `r--`

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Batch Counting:** The `count += (r - l)` step counts multiple triplets at once ($O(1)$) instead of iterating them. This reduces complexity from $O(N^3)$ to $O(N^2)$.
    *Đếm theo lô: Bước cộng đếm nhiều bộ ba cùng lúc thay vì duyệt từng cái.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Sort takes $O(N \log N)$. Outer loop $N$, inner pointers $N$.
    *Độ phức tạp thời gian: $O(N^2)$.*
*   **Space Complexity:** $O(1)$ or $O(\log N)$ sort.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[-2, 0, 1, 3]`, Target 2.
Sorted: `[-2, 0, 1, 3]`.

1.  `i = 0` (val -2). Remainder needed < 4. `l=1 (0), r=3 (3)`.
    - `-2 + 0 + 3 = 1 < 2`.
    - Count += `r - l` = `3 - 1` = 2.
    - (Triplets: `[-2, 0, 3]` and `[-2, 0, 1]`).
    - `l++`.
    - `l=2 (1), r=3 (3)`. `l >= r`? Wait loop `l < r`.
    - `l` became 2. `r` is 3. `1+3 = 4`. `4 (from remaining loop logic)`.
    - Actually my dry run math: `l=1`, `r=3`. Counted. `l` becomes 2.
    - `l=2, r=3`. `0 + 1 + 3 = 4`. Not < 2? Wait.
    - `nums[i] + nums[l] + nums[r]` -> `-2 + 1 + 3 = 2`. Not `< 2`.
    - `r--`. `r=2`. Loop ends.
2.  `i = 1` (val 0). `l=2 (1), r=3 (3)`.
    - `0 + 1 + 3 = 4 >= 2`. `r--`.
    - `r=2`. Loop ends.

Total 2. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard 2-pointer problem. The range counting is key.
*Bài toán 2 con trỏ tiêu chuẩn. Việc đếm theo phạm vi là chìa khóa.*
---
*Khi bạn tìm thấy một điểm tựa vững chắc (left), mọi lựa chọn phía sau (đến right) đều an toàn. Đôi khi, một quyết định đúng mở ra vô số khả năng.*
When you find a solid pivot (left), all choices behind it (up to right) are safe. Sometimes, one right decision opens up countless possibilities.
