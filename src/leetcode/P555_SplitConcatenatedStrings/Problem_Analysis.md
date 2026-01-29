# 555. Split Concatenated Strings / Tách Chuỗi Nối

## Problem Description / Mô tả bài toán
You are given an array of strings `strs`. You could flip each string individually (reverse it) or leave it as is.
Bạn được cho một mảng các chuỗi `strs`. Bạn có thể lật từng chuỗi riêng lẻ (đảo ngược nó) hoặc giữ nguyên.

After that, you will simplify concatenate all the strings in the given order into a giant string (looping back to start).
Sau đó, bạn sẽ nối tất cả các chuỗi theo thứ tự đã cho thành một chuỗi khổng lồ (vòng lại từ đầu).

Specifically, if the concatenated string is `s`, you can cut `s` at any point to form a new string starting at the cut point.
Cụ thể, nếu chuỗi nối là `s`, bạn có thể cắt `s` tại bất kỳ điểm nào để tạo thành một chuỗi mới bắt đầu tại điểm cắt.

The goal is to find the lexicographically largest string among all possible outcomes.
Mục tiêu là tìm chuỗi lớn nhất theo thứ tự từ điển trong số tất cả các kết quả có thể.

### Example 1:
```text
Input: strs = ["abc", "xyz"]
Output: "zyxcba"
Explanation: You can obtain "abcxyz", "abczyx", "cbaxyz", "cbazyx".
Then split and rotate. Best is "zyx" + "cba".
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy + Enumeration / Tham lam + Liệt kê
1. **Local Optimization**: For each string in the array, we should generally pick the lexicographically larger version between `s` and `reverse(s)` to be part of the base concatenated string.
   - Example: if we have "abc", we likely want "cba" inside the body unless the split happens inside it.
2. **Global Enumeration**: The split point can be inside *one* specific string.
   - We iterate through each string `strs[i]` as the potential "split string".
   - For this specific `strs[i]`, we treat it specially: we try both its original form and reversed form, and try every cut point inside it.
   - All other strings `strs[j]` (where `j != i`) are essentially "fixed" to their locally optimal orientation (max of original or reversed).

Algorithm:
1. Preprocess: Replace every `strs[i]` with `max(strs[i], reverse(strs[i]))`.
2. Iterate `i` from `0` to `n-1`:
   - Let `body` be the concatenation of `strs[i+1...n-1] + strs[0...i-1]` (all other strings in order).
   - Consider `strs[i]`. Try both original `org` and reversed `rev`.
   - For `org`: iterate split `k`. Candidate = `org[k:] + body + org[:k]`. Update max.
   - For `rev`: iterate split `k`. Candidate = `rev[k:] + body + rev[:k]`. Update max.
3. Return global max.

### Complexity / Độ phức tạp
- **Time**: O(N * L^2) or slightly better. `N` strings, avg length `L`.
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Greedy Selection with Pivot Iteration

**Algorithm**:
1.  Greedily reverse each string to be lexicographically max.
2.  Iterate through each string as the potential split pivot.
3.  For the pivot, try both original and reversed forms.
4.  Try all cut points within the pivot.
5.  Compare candidates to find global maximum.

---
