# 1286. Iterator for Combination / Bộ lặp cho Tổ hợp

## Problem Description / Mô tả bài toán
Design `CombinationIterator`.
Constructor takes string `characters` (sorted distinct) and length `combinationLength`.
Methods:
- `next()`: returns next combination in lexicographical order.
- `hasNext()`: true if next exists.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combinations Generation
Constraints: string length <= 15. Combinations length <= 15.
Total combinations C(15, 7) = 6435 (small).
Strategy:
1. Precompute all combinations and store in List. Maintain index.
2. Generate on the fly using next permutation logic or bit manipulation.

Precomputation is easiest. Since N is small, space O(C(N, K)) is fine.

### Complexity / Độ phức tạp
- **Time**: Constructor O(C(N, K) * K). next O(1).
- **Space**: O(C(N, K) * K).

---

## Analysis / Phân tích

### Approach: Precompute Combinations
Since the maximum number of combinations is small (bounded by $C(15, 7) \approx 6435$), we can generate all combinations in lexicographical order during initialization and store them in a list. The `next()` function simply returns the next element, and `hasNext()` checks if the current index is within bounds. This makes query operations O(1).
Vì số lượng tổ hợp tối đa là nhỏ (giới hạn bởi $C(15, 7) \approx 6435$), chúng ta có thể tạo tất cả các tổ hợp theo thứ tự từ điển trong quá trình khởi tạo và lưu trữ chúng trong một danh sách. Hàm `next()` chỉ cần trả về phần tử tiếp theo và `hasNext()` kiểm tra xem chỉ mục hiện tại có nằm trong giới hạn hay không. Điều này làm cho các hoạt động truy vấn là O(1).

---
