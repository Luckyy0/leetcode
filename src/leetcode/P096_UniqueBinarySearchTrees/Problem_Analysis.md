# 96. Unique Binary Search Trees / Cây Tìm Kiếm Nhị Phân Duy Nhất

## Problem Description / Mô tả bài toán
Given an integer `n`, return the number of structurally unique **BST**'s (binary search trees) which has exactly `n` nodes of unique values from `1` to `n`.
Cho một số nguyên `n`, trả về số lượng **BST** (cây tìm kiếm nhị phân) duy nhất về mặt cấu trúc có chính xác `n` nút có giá trị duy nhất từ `1` đến `n`.

### Example 1:
```text
Input: n = 3
Output: 5
```

### Example 2:
```text
Input: n = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 19`

---

## Analysis / Phân tích

### Approach: Dynamic Programming / Quy Hoạch Động
- **Idea**: Let `G(n)` be the number of unique BSTs for sequence of length `n`.
- **Ý tưởng**: Gọi `G(n)` là số lượng BST duy nhất cho chuỗi có độ dài `n`.
- **Logic**:
    - Pick root `i` (`1` to `n`).
    - Left subtree has `i-1` nodes. Number of ways: `G(i-1)`.
    - Right subtree has `n-i` nodes. Number of ways: `G(n-i)`.
    - Total for root `i`: `G(i-1) * G(n-i)`.
    - `G(n) = sum(G(i-1) * G(n-i))` for `i=1` to `n`.
- **Base Case**: `G(0) = 1`, `G(1) = 1`.
- **Time Complexity**: O(N^2).
- **Space Complexity**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **n=1**: 1.
2.  **n=19**: Fits in integer (Catalan(19) is large but < 2^31 - 1?). Actually Catalan(19) = 1767263190, which is < 2.14 billion. So `int` is fine.
