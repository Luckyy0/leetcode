# 1156. Swap For Longest Repeated Character Substring / Hoán đổi cho Chuỗi con Ký tự Lặp lại Dài nhất

## Problem Description / Mô tả bài toán
Given a string `text`, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.
Cho một chuỗi `text`, chúng ta được phép hoán đổi hai trong số các ký tự trong chuỗi. Tìm độ dài của chuỗi con dài nhất có các ký tự lặp lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group-Based Analysis / Segment Scan with Lookahead / Phân tích Dựa trên Nhóm / Quét Phân đoạn với Nhìn trước
1. Group consecutive characters: `list of [char, count]`.
   E.g., "aaabaaa" -> `[[a, 3], [b, 1], [a, 3]]`.
2. Also store total count of each character: `freq[a] = 6, freq[b] = 1`.
3. Check each group. Max length is initially group length.
   - If `freq[char] > group_len`, we can extend by 1 (swapping in from elsewhere). So `len + 1`.
4. Check special case: Two groups of same char separated by exactly one different char.
   - `[[a, 3], [b, 1], [a, 3]]`. `group[i]` is 'a', `group[i+2]` is 'a', `group[i+1]` is 'b' (len 1).
   - If `group[i+1].len == 1`, we can merge.
   - Merged length = `g[i].len + g[i+2].len`.
   - If `freq[a] > merged_len`, we can swap in another 'a' (or the one causing separation IS the 'b', wait. Swapping means taking 'a' from somewhere else and putting at `b` pos. BUT we must swap 'b' out. So we end up with `a...a a...a`).
   - Actually strict swap: we move `group[i+1]` char out, and move an `a` in.
   - Does an extra `a` exist?
     - If `freq[a] > g[i].len + g[i+2].len`, yes, we have spare `a` elsewhere. Length is `g[i] + g[i+2] + 1`.
     - Else (all `a`s are in these two groups), length is `g[i] + g[i+2]`. We just bridge them.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Compressed Group Iteration
First, compress the string into groups of identical consecutive characters (e.g., "aaabbaa" becomes `[(a,3), (b,2), (a,2)]`) and calculate the total frequency of each character. Then iterate through the groups to find the longest potential repeated substring:
1. Extend a single group by 1 if additional instances of that character exist elsewhere.
2. Merge two groups of the same character separated by a single different character (length 1 group). If extra characters exist beyond these two groups, extend by 1 (swap in); otherwise, the length is the sum of the two groups.
Đầu tiên, nén chuỗi thành các nhóm ký tự liên tiếp giống nhau (ví dụ: "aaabbaa" trở thành `[(a,3), (b,2), (a,2)]`) và tính tổng tần suất của mỗi ký tự. Sau đó lặp qua các nhóm để tìm chuỗi con lặp lại tiềm năng dài nhất:
1. Mở rộng một nhóm đơn thêm 1 nếu tồn tại các phiên bản bổ sung của ký tự đó ở nơi khác.
2. Hợp nhất hai nhóm ký tự giống nhau được ngăn cách bởi một ký tự khác (nhóm độ dài 1). Nếu các ký tự bổ sung tồn tại ngoài hai nhóm này, hãy mở rộng thêm 1 (hoán đổi vào); nếu không, độ dài là tổng của hai nhóm.

---
