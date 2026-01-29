# 967. Numbers With Same Consecutive Differences / Các số có Hiệu số Liên tiếp giống nhau

## Problem Description / Mô tả bài toán
Return all non-negative integers of length `n` such that the absolute difference between every two consecutive digits is `k`.
Trả về tất cả các số nguyên không âm có độ dài `n` sao cho hiệu tuyệt đối giữa hai chữ số liên tiếp bất kỳ bằng `k`.

Note that every number must not have leading zeros except the number 0 itself.
Lưu ý rằng mọi số không được có các số không ở đầu, ngoại trừ chính số 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dép-First Search (DFS) / Breadth-First Search (BFS) / Tìm kiếm theo chiều sâu (DFS) / Tìm kiếm theo chiều rộng (BFS)
Algorithm:
1. Start with digits `1` to `9` as the first digit. (Special case: if `n=1`, include `0`).
2. For each current number ending in digit `d`:
   - Possible next digit `next1 = d + k`. If `next1 <= 9`, recurse.
   - Possible next digit `next2 = d - k`. If `next2 >= 0` and `k != 0`, recurse.
3. Stop when number length reaches `n`.

### Complexity / Độ phức tạp
- **Time**: O(2^N).
- **Space**: O(2^N).

---

## Analysis / Phân tích

### Approach: Recursive Digit construction
Systematically build valid numbers position by position. Since the constraint is local (difference to the previous digit), we can expand our search tree from initial digits to full-length integers, pruning paths that lead to invalid digit values.
Xây dựng các số hợp lệ một cách có hệ thống theo từng vị trí. Vì ràng buộc mang tính cục bộ (hiệu số với chữ số đứng trước), chúng ta có thể mở rộng cây tìm kiếm từ các chữ số ban đầu đến các số nguyên có độ dài đầy đủ, cắt tỉa các đường dẫn dẫn đến các giá trị chữ số không hợp lệ.

---
