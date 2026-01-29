# 1234. Replace the Substring for Balanced String / Thay thế Chuỗi con cho Chuỗi Cân bằng

## Problem Description / Mô tả bài toán
String `s` containing 'Q', 'W', 'E', 'R'. Length `4n`.
Balanced if each char appears `n` times.
Find minimum length of substring to replace so `s` becomes balanced.
You can replace substring with ANY string of same length.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
Target: Reduce counts of characters that exceed `n`.
Total counts `count[Q], count[W]...`.
Target counts: `n`.
Excess: `max(0, count[char] - n)`.
We need to find smallest substring that contains at least "Excess" amount of each char.
Valid window condition:
Remaining part (outside window) must have `count[char] <= n`.
Why? If remaining has `> n`, we can't fix it by replacing the window.
If remaining has `<= n` for all chars, we can fill window such that total is `n`.
Algorithm:
1. Count all chars.
2. If already balanced, return 0.
3. Sliding window `[left, right]`.
   - Decrement count of `s[right]` (moving it into window effectively removes it from "outside").
   - While `all counts <= n`:
     - Update min length `right - left + 1`.
     - Increment count of `s[left]` (moving it back "outside").
     - Left++.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sliding Window for Surplus Reduction
Calculate the frequency of each character. Determine which characters appear more than `n/4` times (surplus). To make the string balanced, we must replace a substring that contains at least all the surplus occurrences (so that the "outside" string has no character count $> n/4$). Use a sliding window to find the minimum length substring. As the window expands, decrement the counts of characters entering the window (treating them as removed). If all counts of the remaining characters (outside the window) are $\le n/4$, the window is valid; try to shrink it from the left to find the minimum valid window.
Tính tần suất của mỗi ký tự. Xác định ký tự nào xuất hiện nhiều hơn `n/4` lần (dư thừa). Để cân bằng chuỗi, chúng ta phải thay thế một chuỗi con chứa ít nhất tất cả các lần xuất hiện dư thừa (để chuỗi "bên ngoài" không có số lượng ký tự nào $> n/4$). Sử dụng cửa sổ trượt để tìm chuỗi con có độ dài tối thiểu. Khi cửa sổ mở rộng, hãy giảm số lượng ký tự đi vào cửa sổ (coi chúng như đã xóa). Nếu tất cả số lượng ký tự còn lại (bên ngoài cửa sổ) đều $\le n/4$, cửa sổ hợp lệ; hãy thử thu nhỏ nó từ bên trái để tìm cửa sổ hợp lệ tối thiểu.

---
