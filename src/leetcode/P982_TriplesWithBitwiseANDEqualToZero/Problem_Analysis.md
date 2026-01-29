# 982. Triples with Bitwise AND Equal To Zero / Bộ ba có Bitwise AND bằng Không

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the number of **AND triples**, namely `(i, j, k)` such that `nums[i] & nums[j] & nums[k] == 0`.
Cho một mảng số nguyên `nums`, hãy trả về số lượng **bộ ba AND**, tức là `(i, j, k)` sao cho `nums[i] & nums[j] & nums[k] == 0`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Map for Pair AND / Bản đồ Tần suất cho AND của cặp
The naive $O(N^3)$ is too slow.
Cách tiếp cận $O(N^3)$ ngây thơ là quá chậm.

Algorithm:
1. Precompute frequencies of `nums[i] & nums[j]` for all pairs. Store in an array `counts` of size $2^{16} = 65536$.
2. Iterate through each `num` in `nums`:
   - Iterate through each possible AND value `val` from 0 to 65535:
     - If `(num & val) == 0`: `res += counts[val]`.

### Complexity / Độ phức tạp
- **Time**: O(N^2 + N * 2^{16}).
- **Space**: O(2^{16}).

---

## Analysis / Phân tích

### Approach: Partial Pre-aggregation
Reduce the cubic complexity to quadratic by collapsing the search space for pairs. By pre-calculating the bitwise AND results for every possible combination of two numbers, we can determine the final triplet count through a single linear pass against a fixed-size frequency domain.
Giảm độ phức tạp từ bậc ba xuống bậc hai bằng cách thu gọn không gian tìm kiếm các cặp. Bằng cách tính toán trước kết quả AND theo bit cho mọi tổ hợp của hai số, chúng ta có thể xác định số lượng bộ ba cuối cùng thông qua một lần duyệt tuyến tính duy nhất đối với miền tần suất có kích thước cố định.

---
