# Analysis for Concatenated Words
# *Phân tích cho bài toán Chuỗi nối tiếp*

## 1. Problem Essence & Word Break
## *1. Bản chất vấn đề & Phân tách Từ*

### The Challenge
### *Thách thức*
Identifying which words in a list are composed of two or more other words from the same list. This is essentially solving the **Word Break (LeetCode 139)** problem for each word, using the other words as the dictionary.

### Strategy: Sort + DP (or Top-Down Memoization) with HashSet
### *Chiến lược: Sắp xếp + DP (hoặc Ghi nhớ Tùy biến) với HashSet*

1.  **Optimized Lookups:** Store all words in a `HashSet` for $O(1)$ existence checks.
2.  **Length Sort:** Sort `words` by length. Why? A word can only be formed by words *shorter* than itself.
    - If we process from shortest to longest, when we check word $W$, all possible components are already processed (and potentially added to our "valid dictionary").
    - Wait, actually, the problem says "at least two shorter words in the given array". The components must be in the original `words` list. So simple sorting helps in efficiency but isn't strictly necessary for correctness if we handle the recursion carefully (e.g. not allowing a word to break into *itself*).
3.  **Recursion/DP Logic (Word Break):**
    - `canForm(word, dictionary)`: Can `word` be segmented into parts found in `dictionary`?
    - Base case: if `dictionary` contains `word`, return true (but we must ensure we used $\ge 2$ words total).
4.  **Refined Logic:**
    - Insert all words into a Set.
    - For each word $W$:
        - Temporarily remove $W$ from the Set (so it doesn't match itself as 1 component).
        - Run `canForm(W, Set)`.
        - If true, add to result.
        - Add $W$ back (or just keep it in Set and handle the "at least 2" logic).

---

## 2. Approach: DFS with Trie or Set
## *2. Hướng tiếp cận: DFS với Trie hoặc Set*

### Logic
### *Logic*
(See above). The `canForm` function is classic DP. `dp[i]` is true if `word[0...i]` can be segmented.
- Iterate `j` from 0 to `i`: if `dp[j]` is true and `word[j...i]` is in Set, then `dp[i]` is true.
- Since max word length is 30 (very small!), we don't need optimal Trie. Simple Set checks along substrings are fast enough. $30^2$ iterations is negligible.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Small Constraints:** Word length $\le 30$ means $O(L^2)$ DP per word is extremely fast. The bottleneck is the number of words ($10^4$).
    *Ràng buộc nhỏ: Độ dài từ $\le 30$ nghĩa là DP $O(L^2)$ cho mỗi từ cực kỳ nhanh. Nút thắt là số lượng từ ($10^4$).*
*   **HashSet Efficiency:** Constant time lookup dominates complexity.
    *Hiệu quả HashSet: Tra cứu thời gian hằng số chiếm ưu thế.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L^3)$ or $O(N \cdot L^2)$ depending on substring implementation. With $N=10^4, L=30$, $10^4 \cdot 900 \approx 9 \times 10^6$ ops, very safe.
    *Độ phức tạp thời gian: $O(N \cdot L^2)$.*
*   **Space Complexity:** $O(N \cdot L)$ to store words in Set.
    *Độ phức tạp không gian: $O(N \cdot L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Word:** `catdog` inside `[cat, dog, catdog]`
1. Remove `catdog` from Set. Set: `{cat, dog}`.
2. Check `catdog`:
   - Prefix `c`: no.
   - ...
   - Prefix `cat`: yes (`dp[3]=true`). Remain `dog`.
   - Check `dog`: yes (`dp[6]=true`).
3. `dp[6]` reached. Valid.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterate words, use DFS/DP with HashSet to check if it's composed of other words.
*Duyệt qua các từ, sử dụng DFS/DP với HashSet để kiểm tra xem nó có được tạo thành từ các từ khác không.*
---
*Một từ ghép (concatenated word) không tự nhiên sinh ra, nó là sự kết tinh của những mảnh ghép nhỏ bé hơn. Bằng cách tách một thực thể phức tạp (word break) thành những đơn vị cơ bản đã biết (dictionary), ta hiểu được cấu trúc nội tại của nó. Cũng giống như thành công lớn được xây dựng từ vô số nỗ lực nhỏ, việc nhận diện (identification) đòi hỏi ta phải nhìn thấu bản chất của sự kết hợp.*
A compound word (Concatenated Word) is not naturally born, it is the crystallization of smaller pieces. By separating a complex entity (Word Break) into known basic units (Dictionary), we understand its internal structure. Just as great success is built from countless small efforts, identification (Identification) requires us to see through the nature of the combination.
