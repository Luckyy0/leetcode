# Analysis for Bulls and Cows
# *Phân tích cho bài toán Bò và Cựu*

## 1. Problem Essence & Counting
## *1. Bản chất vấn đề & Đếm*

### Bulls (x)
### *Bò (x)*
`secret[i] == guess[i]`. Simple iteration.

### Cows (y)
### *Cựu (y)*
Digits that exist in both but not at correct index.
But be careful with duplicates.
Example: Secret `112`, Guess `011`.
- i=0: '1' vs '0'.
- i=1: '1' vs '1' -> BULL.
- i=2: '2' vs '1'.
Remaining in Secret: `1`, `2`.
Remaining in Guess: `0`, `1`.
One COW (the '1' matches).
Total: 1A 1B.

### Strategy: Two Pass / Frequency Array
### *Chiến lược: Hai lượt / Mảng tần suất*
1.  **Count Bulls:** Iterate `i`. If match, `bulls++`. Else, count frequency of `secret[i]` in `sCount` and `guess[i]` in `gCount`.
2.  **Count Cows:** Iterat digits `0-9`. Cows contributed by digit `d` is `min(sCount[d], gCount[d])`.
    - Note: `sCount` should only include NON-BULL digits.

### Optimized Single Pass
### *Gộp một lượt tối ưu*
Iterate `i`.
- If match: `bulls++`.
- If no match:
    - `secret[i]` provides a potential cow from secret side.
    - `guess[i]` provides a potential cow from guess side.
    - We can use a single array `h` (histogram).
    - `s` digit increments. `g` digit decrements.
    - If `h[s] < 0`: Means `g` saw this digit before. `cows++`. `h[s]++`.
    - If `h[g] > 0`: Means `s` saw this digit before. `cows++`. `h[g]--`.

This is clever but potentially confusing. Two pass (or freq array) is safer.

Count all freq in Secret -> `map`.
Pass 1: Detect Bulls. If bull, decrement map.
Pass 2: Detect Cows (Remaining). If `map[g[i]] > 0` and NOT bull, cows++, decrement map.

Wait, better:
1.  `int[] count = new int[10]`.
2.  Pass 1:
    - If `s[i] == g[i]`: `bulls++`.
    - Else: `count[s[i]]++`.
3.  Pass 2:
    - If `s[i] != g[i]`:
        - If `count[g[i]] > 0`: `cows++`, `count[g[i]]--`.
This works perfectly.

---

## 2. Approach: Frequency Array
## *2. Hướng tiếp cận: Mảng Tần suất*

### Logic
### *Logic*
1.  `bulls = 0, cows = 0`. `digits[10]`.
2.  Loop `i` from 0 to N-1:
    - If `s[i] == g[i]`, `bulls++`.
    - Else `digits[s[i] - '0']++`.
3.  Loop `i` from 0 to N-1:
    - If `s[i] != g[i]`:
        - If `digits[g[i] - '0'] > 0`:
            - `cows++`.
            - `digits[g[i]]--`.
4.  Return formatted string.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Separation:** Handling Bulls first isolates the "exact match" logic, leaving a simple multiset intersection problem for Cows.
    *Tách biệt: Xử lý Bò trước cô lập logic "khớp chính xác", để lại bài toán giao đa tập đơn giản cho Cựu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (Array size 10).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** S="1807", G="7810"
1.  i=0: '1' vs '7'. `freq['1']++`.
2.  i=1: '8' vs '8'. Bull++. (Total 1).
3.  i=2: '0' vs '1'. `freq['0']++`.
4.  i=3: '7' vs '0'. `freq['7']++`.
Freq: `{1:1, 0:1, 7:1}`.

Pass 2 (Non-bulls):
1.  i=0: G='7'. Freq['7'] is 1. Cows++. Freq['7'] -> 0.
2.  i=1: Bull. Skip.
3.  i=2: G='1'. Freq['1'] is 1. Cows++. Freq['1'] -> 0.
4.  i=3: G='0'. Freq['0'] is 1. Cows++. Freq['0'] -> 0.
Total Cows: 3.
Result: 1A3B.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two-pass strategy is less error-prone than single-pass optimized.
*Chiến lược hai lượt ít lỗi hơn so với một lượt tối ưu.*
---
*Đừng nhầm lẫn giữa đúng người sai thời điểm (Cow) và đúng người đúng thời điểm (Bull). Hãy phân loại rõ ràng để đánh giá chính xác mối quan hệ.*
Don't confuse the right person at the wrong time (Cow) with the right person at the right time (Bull). Classify clearly to accurately assess the relationship.
