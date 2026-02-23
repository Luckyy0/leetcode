# Analysis for Number of Subarrays with Bounded Maximum
# *Phân tích cho bài toán Số lượng Mảng con với Giá trị Lớn nhất bị Ràng buộc*

## 1. Problem Essence & Counting
## *1. Bản chất vấn đề & Đếm*

### The Challenge
### *Thách thức*
We want subarrays where `left <= max <= right`.
This is equivalent to: `(count of max <= right) - (count of max < left)`.
*Chúng ta muốn các mảng con có `left <= max <= right`. Điều này tương đương với: `(số lượng max <= right) - (số lượng max < left)`.*

Let `count(bound)` be the number of subarrays where all elements are `<= bound`.
For a subarray to have max `<= bound`, **all** its elements must be `<= bound`.
If we find a contiguous segment of elements all `<= bound` with length `L`, it contributes `L * (L + 1) / 2` subarrays.
If we encounter an element `> bound`, the segment breaks.
*Gọi `count(bound)` là số mảng con mà mọi phần tử đều `<= bound`. Nếu gặp một đoạn liên tiếp các phần tử đều `<= bound` có độ dài `L`, nó đóng góp `L * (L + 1) / 2`. Nếu gặp phần tử `> bound`, đoạn bị ngắt.*

---

## 2. Strategy: Two Pointers / Single Pass
## *2. Chiến lược: Hai Con trỏ / Duyệt Một lần*

### Method 1: Function Subtraction
### *Phương pháp 1: Trừ Hàm*

`return count(right) - count(left - 1)`.
Helper `count(bound)`:
- Iterate `nums`. If `nums[i] <= bound`, `currentLen++`.
- Else `currentLen = 0`.
- Add `currentLen` to total (Wait, if length becomes 3, subarrays ending at 3 is 3. Total is sum of currentLen).
- Total += currentLen.
*Trả về `count(right) - count(left - 1)`. Hàm `count(bound)` duyệt mảng, nếu phần tử thỏa mãn thì tăng độ dài hiện tại và cộng vào tổng.*

### Method 2: Single Pass with Pointers
### *Phương pháp 2: Duyệt Một lần với Con trỏ*

Iterate with index `i`. Maintain `start` (index of start of valid window) and `count`.
- If `nums[i] > right`: Reset window. `start = i + 1`. `count = 0`.
- If `nums[i] >= left` (and `<= right`): Valid peak. New valid subarrays ending at `i` start from `start`. Count = `i - start + 1`.
- If `nums[i] < left`: It can extend previous valid subarrays. It uses the `count` from the last valid peak calculation?
  - Actually, number of valid subarrays ending at `i` is the same as the number of valid subarrays ending at the most recent index `j` where `nums[j] >= left`.
  - Basically, if `nums[i] < left`, we can append it to any valid subarray ending at `i-1`.
  - Let `lastCount` be the number of valid subarrays ending at `i-1`.
  - If `nums[i] < left`, `currCount = lastCount`.
  - If `nums[i] in [left, right]`, `currCount = i - start + 1`.
  - If `nums[i] > right`, `currCount = 0`, `start = i + 1`.
*Duyệt với `i`. Nếu `> right`: Reset window. Nếu `>= left`: `i` là đỉnh hợp lệ, số mảng con kết thúc tại `i` là `i - start + 1`. Nếu `< left`: có thể nối vào mảng trước đó, số lượng bằng lần trước.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Nums:** `[2, 1, 4, 3]`, Left=2, Right=3.
1. `i=0`, val=2. Range `[2,3]`. `start=0`. `count = 0-0+1 = 1`. Total += 1. (Subarrays: `[2]`)
2. `i=1`, val=1. Range `<2`. `count = 1` (carry over). Total += 1. (Subarrays: `[2,1]`)
   - Why carry over? valid are `[2,1]`. `[1]` is invalid (max 1 < 2).
   - Correct logic: `count` tracks valid subarrays ending at `i`.
   - `[2,1]` extends `[2]`.
3. `i=2`, val=4. Range `>3`. Reset `start=3`, `count=0`. Total += 0.
4. `i=3`, val=3. Range `[2,3]`. `count = 3-3+1 = 1`. Total += 1. (Subarrays: `[3]`)
**Total:** 3. Correct.

**Nums:** `[2, 9, 2, 5, 6]`, Left=2, Right=8.
1. `i=0` (2). Valid. `start=0`. `count=1`. Total=1. (`[2]`)
2. `i=1` (9). Invalid (>8). `start=2`. `count=0`.
3. `i=2` (2). Valid. `start=2`. `count=1`. Total=1+1=2. (`[2]`)
4. `i=3` (5). Valid. `start=2`. `count=3-2+1=2`. Total=2+2=4. (`[2,5], [5]`)
5. `i=4` (6). Valid. `start=2`. `count=4-2+1=3`. Total=4+3=7. (`[2,5,6], [5,6], [6]`)
**Total:** 7. Correct.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The single pass method tracking `lastCount` is very clever and O(N). The `count(R) - count(L-1)` method is also O(N) (2 passes) and easier to reason about (standard inclusion-exclusion).
*Phương pháp duyệt một lần theo dõi `lastCount` rất thông minh và O(N). Phương pháp `count(R) - count(L-1)` cũng O(N) và dễ suy luận hơn.*
