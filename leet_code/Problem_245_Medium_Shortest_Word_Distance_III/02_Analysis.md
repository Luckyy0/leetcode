# Analysis for Shortest Word Distance III
# *Phân tích cho bài toán Khoảng cách từ ngắn nhất III*

## 1. Problem Essence & Same Word Handling
## *1. Bản chất vấn đề & Xử lý từ giống nhau*

### The Twist
### *Điểm mấu chốt*
`word1` can be equal to `word2`.
If `word1 != word2`, it works exactly like Problem 243.
If `word1 == word2`, we need to find the shortest distance between two *different occurrences* of the same word.
*Nếu hai từ giống nhau, cần tìm khoảng cách ngắn nhất giữa hai lần xuất hiện khác nhau.*

---

## 2. Approach: Iterative with Index Update
## *2. Hướng tiếp cận: Lặp với Cập nhật chỉ số*

### Logic
### *Logic*
1.  Initialize `p1 = -1`, `p2 = -1`, `minDist = infinity`.
2.  Iterate `i` from 0 to `n`:
    - If `word1 == word2`:
        - If `words[i].equals(word1)`:
            - If `p1 != -1`, `minDist = min(minDist, i - p1)`.
            - `p1 = i` (Update latest occurrence).
    - If `word1 != word2`:
        - If `words[i].equals(word1)`: `p1 = i`.
        - If `words[i].equals(word2)`: `p2 = i`.
        - If both found, update `minDist`.

### Refined Logic for Same Words
### *Logic tinh chỉnh*
We can use a single variable `prevIndex`.
If `words[i] == word1`:
- `minDist = min(minDist, i - prevIndex)`.
- `prevIndex = i`.

### Unified Logic
### *Logic hợp nhất*
Iterate.
If match `word1`:
- If `word1 == word2`, consider `p1` as the "previous" occurrence. Update dist based on old `p1`, then update `p1`.
- If different, just update `p1`, try `p1 - p2`.
If match `word2`:
- Update `p2`, try `p2 - p1`.

Let's maintain `index1` and `index2`.
If `word1 == word2`:
- When we find a match at `i`:
    - Check distance with `index1` (which stores the previous index).
    - update `index1 = i`.
Else:
- Standard logic.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Adaptability:** One condition changes the behavior but the core linear scan remains.
    *Khả năng thích ứng: Một điều kiện thay đổi hành vi nhưng bản chất quét tuyến tính vẫn giữ nguyên.*

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

**Input:** ["a", "b", "a"], w1="a", w2="a".

1.  i=0 ("a"). Match. `index1` (prev -1). Update `index1 = 0`.
2.  i=1 ("b"). No match.
3.  i=2 ("a"). Match.
    - Calc dist `2 - index1(0) = 2`. Min=2.
    - Update `index1 = 2`.

**Input:** ["a", "b", "c", "a"], w1="a", w2="b".

1.  i=0 ("a"). Match w1. `p1=0`. Dist? p2=-1.
2.  i=1 ("b"). Match w2. `p2=1`. Dist `|1-0|=1`.
3.  i=3 ("a"). Match w1. `p1=3`. Dist `|3-1|=2`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Handle the `word1.equals(word2)` case explicitly or merge logic carefully. Explicit handling is cleaner.
*Xử lý trường hợp hai từ giống nhau một cách rõ ràng sẽ sạch sẽ hơn.*
---
*Đôi khi kẻ thù lớn nhất của bạn chính là bản thân bạn (word1 == word2), và khoảng cách ngắn nhất là giữa hai phiên bản của chính mình.*
Sometimes your biggest enemy is yourself (word1 == word2), and the shortest distance is between two versions of yourself.
