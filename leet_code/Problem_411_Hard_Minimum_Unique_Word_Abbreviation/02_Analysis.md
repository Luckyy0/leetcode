# Analysis for Minimum Unique Word Abbreviation
# *Phân tích cho bài toán Từ viết tắt Duy nhất Ngắn nhất*

## 1. Problem Essence & Bitmask Logic
## *1. Bản chất vấn đề & Logic Bitmask*

### The Challenge
### *Thách thức*
Finding the shortest abbreviation of a `target` word that doesn't overlap with any words in a `dictionary`. Only dictionary words with the same length as `target` are relevant.

### Strategy: Bitmasking & Conflict Check
### *Chiến lược: Sử dụng Bitmask & Kiểm tra xung đột*
1.  **Dictionary Filtering:** Only keep dictionary words with `length == target.length`.
2.  **Difference Masks:** For each valid dictionary word, create a bitmask where a bit is `1` if the character at that position differs from `target`, and `0` otherwise.
    - Let the dictionary masks be $\{D_1, D_2, \dots, D_n\}$.
3.  **Abbreviation Mask:** An abbreviation can be represented by a bitmask `M` of length `target.length`.
    - `1` at position `j` means we **keep** the character `target[j]`.
    - `0` means we **abbreviate** it.
4.  **Validity Condition:** An abbreviation mask `M` is **unique** if for every dictionary mask $D_i$, there is at least one kept character that differs: $M \ \& \ D_i \neq 0$.
5.  **Minimization:** We want the `M` that results in the smallest number of components in the final string (consecutive `0`s count as one component).

---

## 2. Approach: DFS with Pruning
## *2. Hướng tiếp cận: DFS với Nhánh và Cận*

### Logic
### *Logic*
We explore all possible bitmasks of length $m$. To find the shortest abbreviation, we can use DFS to pick which bits to turn on.
-   Calculate the "abbreviated length" of a mask.
-   Prune branches if the current length already exceeds the best found so far.
-   For a mask to be valid, it must resolve all "conflicts" with the dictionary masks.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bitwise Speed:** Checking `(M & D) != 0` is extremely fast.
    *Tốc độ Bitwise: Kiểm tra xung đột cực nhanh.*
*   **Effective Pruning:** By sorting or carefully selecting indices, we can quickly find shorter versions.
    *Cắt tỉa hiệu quả: Giúp tìm ra các bản rút gọn ngắn nhất nhanh hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^M)$, where $M$ is the length of `target` ($M \le 21$). $2^{21} \approx 2 \times 10^6$, which fits within time limits.
    *Độ phức tạp thời gian: $O(2^M)$.*
*   **Space Complexity:** $O(N \text{ in filtered dictionary})$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Target:** `apple` (len 5), **Dict:** `[blade]`
1.  Dict Mask for `blade`:
    - `a` vs `b`: diff (1)
    - `p` vs `l`: diff (1)
    - `p` vs `a`: diff (1)
    - `l` vs `d`: diff (1)
    - `e` vs `e`: same (0)
    - Mask $D = 11110_2 = 30$.
2.  Try `M = 00000` (abbr "5"). $M \ \& \ D = 0$. Invalid.
3.  Try `M = 10000` (abbr "a4"). $M \ \& \ D = 10000_2 \ \& \ 11110_2 = 10000_2 \neq 0$. Valid!
4.  Length of "a4" (bits 10000) is 2.
Result: "a4".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Pre-calculate difference masks and use DFS to find the minimal unique bitmask.
*Tính toán trước các mặt nạ khác biệt và dùng DFS để tìm bitmask duy nhất tối thiểu.*
---
*Ngôn ngữ là một trò chơi của sự ẩn dụ và rút gọn (abbreviation). Để giữ được bản sắc riêng (unique) mà vẫn tối giản hết mức, ta cần chọn đúng những "từ khóa" (bits set to 1) tại các vị trí xung đột (diff masks). Chỉ một vài điểm chạm đúng chỗ cũng đủ để phân biệt ta với phần còn lại của thế giới.*
Language is a game of metaphor and abbreviation. To keep our own identity (unique) while remaining as minimal as possible, we need to choose the right "keywords" (bits set to 1) at conflict positions (diff masks). Just a few right touches are enough to distinguish us from the rest of the world.
