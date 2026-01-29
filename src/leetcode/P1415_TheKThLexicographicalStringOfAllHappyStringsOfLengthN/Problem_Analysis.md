# 1415. The k-th Lexicographical String of All Happy Strings of Length n / Chuỗi Từ vựng thứ k của Tất cả các Chuỗi Hạnh phúc có Độ dài n

## Problem Description / Mô tả bài toán
Happy string: 'a', 'b', 'c'. No adjacent equal chars. Length `n`.
Return k-th happy string sorted lexicographically. Empty if not exists.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Math
Total happy strings of length `n`:
First char: 3 choices.
Remaining `n-1` chars: 2 choices each.
Total = `3 * 2^(n-1)`.
If `k > Total`, return "".
Determine chars one by one.
First char (idx 0):
- Block size = `2^(n-1)`.
- If `k <= Block`: 'a'.
- If `k <= 2*Block`: 'b'. k -= Block.
- Else: 'c'. k -= 2*Block.
Next chars:
- Previous was `p`.
- Two valid next characters `small`, `large` (sorted). e.g. if p='a', `small`='b', `large`='c'.
- Block size = `2^(n-1-i)`.
- If `k <= Block`: append `small`.
- Else: append `large`. k -= Block.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Mathematical Construction
Instead of generating all (DFS), calculate character at each position.
1. Check if `k` is within range. Total = `3 * (1 << (n-1))`.
2. Determine first character based on chunks of size `1 << (n-1)`.
3. For subsequent positions, determine character based on previous char and chunks of size `1 << (n-1-i)`. The 2 choices must be sorted.
Thay vì tạo tất cả (DFS), hãy tính toán ký tự tại mỗi vị trí.
1. Kiểm tra xem `k` có nằm trong phạm vi không.
2. Xác định ký tự đầu tiên dựa trên các khối có kích thước `1 << (n-1)`.
3. Đối với các vị trí tiếp theo, xác định ký tự dựa trên ký tự trước đó và các khối có kích thước `1 << (n-1-i)`.

---
