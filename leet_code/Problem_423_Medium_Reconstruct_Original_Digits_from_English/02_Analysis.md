# Analysis for Reconstruct Original Digits from English
# *Phân tích cho bài toán Tái cấu trúc Chữ số từ Tiếng Anh*

## 1. Problem Essence & Unique Identifiers
## *1. Bản chất vấn đề & Định danh duy nhất*

### The Challenge
### *Thách thức*
Recovering digits from a jumbled mess of characters. Since each digit (0-9) corresponds to a unique word, we can identify them by looking for characters that only appear in certain words.

### Strategy: Hierarchical Deduction
### *Chiến lược: Suy luận Phân cấp*
We can find digits with unique characters first, and then subtract their counts to reveal others.

1.  **Level 1 (Strictly Unique):**
    - `0`: "zero" has `z` (unique).
    - `2`: "two" has `w` (unique).
    - `4`: "four" has `u` (unique).
    - `6`: "six" has `x` (unique).
    - `8`: "eight" has `g` (unique).
2.  **Level 2 (Dependency):**
    - `3`: "three" has `h` (also in 8, but we know 8). Count `h` - Count `8`.
    - `5`: "five" has `f` (also in 4). Count `f` - Count `4`.
    - `7`: "seven" has `s` (also in 6). Count `s` - Count `6`.
3.  **Level 3 (Remaining):**
    - `9`: "nine" has `i` (also in 5, 6, 8). Count `i` - Count `5` - Count `6` - Count `8`.
    - `1`: "one" has `o` (also in 0, 2, 4). Count `o` - Count `0` - Count `2` - Count `4`.

---

## 2. Approach: Frequency Counting
## *2. Hướng tiếp cận: Đếm Tần suất*

### Logic
### *Logic*
(See above). We first count every character in the input string. Then we apply the formulas above to determine the count of each digit from 0 to 9.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Single pass to count characters.
    *Hiệu quả O(N): Duyệt một lần để đếm ký tự.*
*   **Deterministic Logic:** No backtracking or recursion needed.
    *Logic xác định: Không cần quay lui hay đệ quy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ for the frequency array (size 26) and digit count array (size 10).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `"owoztneoer"`
1. Counts: `z:1, w:1, o:2, t:1, n:1, e:2, r:1` ...
2. `ans[0] = count[z] = 1`.
3. `ans[2] = count[w] = 1`.
4. `ans[1] = count[o] - ans[0] - ans[2] - ans[4] = 2 - 1 - 1 - 0 = 0`.
Wait, "owoztneoer" contains "zero", "one", "two"?
- zero: z, e, r, o
- two: t, w, o
- one: o, n, e
Check: `ans[0]=1, ans[2]=1, ans[1]=1`.
Result: "012".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Character-based math deduction.
*Suy luận toán học dựa trên ký tự.*
---
*Trong mớ hỗn độn (shuffled characters) của ngôn từ, mỗi chữ số đều mang trong mình một "vân tay" (unique character) riêng biệt. Bằng cách bóc tách từng lớp bằng chứng (deduction), ta có thể khôi phục lại trật tự vốn có của các con số, nơi mà sự thật cuối cùng sẽ luôn được phơi bày qua những phép tính chuẩn xác.*
In the chaos (shuffled characters) of words, each digit carries its own "fingerprint" (unique character). By peeling back each layer of evidence (deduction), we can restore the inherent order of the numbers, where the final truth will always be revealed through precise calculations.
