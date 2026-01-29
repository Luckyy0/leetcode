# 859. Buddy Strings / Chuỗi Bạn bè

## Problem Description / Mô tả bài toán
Given two strings `s` and `goal`, return `true` if you can swap two letters in `s` so the result is equal to `goal`.
Cho hai chuỗi `s` và `goal`, trả về `true` nếu bạn có thể hoán đổi hai chữ cái trong `s` sao cho kết quả bằng `goal`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Case Analysis / Phân tích Trường hợp
Two scenarios for a valid swap:
1. `s` and `goal` are already equal:
   - There must be at least one duplicate character in `s` to swap (e.g., "aa").
2. `s` and `goal` are different:
   - They must differ in exactly 2 positions.
   - For positions `i, j`, `s[i] == goal[j]` and `s[j] == goal[i]`.
   - Lengths must be equal.

Algorithm:
1. Check if `s.length() != goal.length()`.
2. If `s.equals(goal)`, check if any character count is `> 1`.
3. If not equal, find all indices `i` where `s[i] != goal[i]`.
4. If there are exactly 2 such indices, check the swap condition.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (for character frequency array).

---

## Analysis / Phân tích

### Approach: Difference Counter
A valid buddy string relationship requires either a perfect match with redundancy or exactly one swap's worth of discrepancy. By tracking mismatched indices, we can verify the swap feasibility instantly.
Mối quan hệ chuỗi bạn bè hợp lệ yêu cầu một sự khớp hoàn hảo với tính dư thừa hoặc sai lệch đúng bằng một lần hoán đổi. Bằng cách theo dõi các chỉ số không khớp, chúng ta có thể xác minh tính khả thi của việc hoán đổi ngay lập tức.

---
