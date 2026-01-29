# 1461. Check If a String Contains All Binary Codes of Size K / Kiểm tra Xem một Chuỗi có Chứa Tất cả các Mã Nhị phân có Kích thước K hay không

## Problem Description / Mô tả bài toán
String `s`. Check if it contains every binary code of length `k`.
Total codes $2^k$.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Substring Set
Total possibilities $2^k$.
Iterate all substrings of length `k`. Add to set.
If `set.size() == 2^k`, return true.
Optimization:
Max k=20.
Number of substrings N. `N * K` to stringify.
Better: Rolling hash (integer value).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(2^K).

---

## Analysis / Phân tích

### Approach: Hash Set of Integers (or Strings)
Iterate `i` from 0 to `n-k`. Extract `s.substring(i, i+k)`. Add to set.
Or keep rolling integer value. Mask `(1<<k)-1`.
Shift left, add new bit, mask.
Add integer to boolean array of size `2^k`. Count unique.
Since Constraints: $N \le 5 \cdot 10^5$, $k \le 20$.
String approach O(NK) is okay for k=20? $5 \cdot 10^5 \cdot 20 = 10^7$. OK.
Rolling hash O(N) is better.
Sử dụng Rolling hash. Lưu trữ các mã trong một mảng boolean hoặc HashSet.

---
