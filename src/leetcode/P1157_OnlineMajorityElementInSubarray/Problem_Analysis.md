# 1157. Online Majority Element In Subarray / Phần tử Đa số Trực tuyến Trong Mảng con

## Problem Description / Mô tả bài toán
Design a class `MajorityChecker` to check the majority element of a subarray of a given array `arr`.
- `MajorityChecker(int[] arr)`
- `int query(int left, int right, int threshold)`: returns value `val` such that `val` occurs `>= threshold` times in `arr[left...right]`, or -1 if no such element exists.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Segment Tree / Random Sampling / Map of Positions / Cây Phân đoạn / Lấy mẫu Ngẫu nhiên / Bản đồ Vị trí
Approach 1: Segment Tree. Each node stores the majority candidate and its count.
Merging nodes: Classic majority vote merge logic.
Cost: O(N) build. O(log N) query to get candidate.
Verification: Need actual count of candidate in range.
Use binary search on position lists (stored in a map) to get exact frequency in range.
`countInRange(val, left, right) = upper_bound(indices[val], right) - lower_bound(indices[val], left)`.

Approach 2: Random Sampling.
Majority element appears > half time (or threshold often high).
Pick random index in `[left, right]`. Check if `arr[index]` is majority. Repeat ~20 times.
This works well if threshold is roughly `len/2`.
Problem allows threshold >= `len/2`? No, threshold is given.
Constraints: `2 * threshold > right - left + 1`.
Since threshold is strictly more than half, random sampling has prob >= 0.5 success per trial.
20 trials -> failure prob 2^-20 is tiny.
This is probabilistic but accepted for this problem usually.

Implementation: Map `val -> List<Integer>` (indices).
`query`:
1. Try random indices loop.
2. For candidate, check frequency using `upper_bound`.
3. If freq >= threshold, return candidate.
4. Return -1.

### Complexity / Độ phức tạp
- **Time**: Build O(N). Query O(K * log N) where K is number of trials.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Randomized Selection with Verification
Since the requested element must appear at least `threshold` times (where `threshold > (right - left + 1) / 2`), randomly sampling an element from the subarray `[left, right]` has a probability of at least 0.5 of picking the majority element. By repeating this sampling 20 times, the probability of failure becomes negligible ($2^{-20}$). For each candidate picked, verify its frequency in the range using binary search (specifically `upper_bound - lower_bound` on the precomputed index list for that value). This provides a fast and effective solution.
Vì phần tử được yêu cầu phải xuất hiện ít nhất `ngưỡng` lần (trong đó `ngưỡng > (phải - trái + 1) / 2`), việc lấy mẫu ngẫu nhiên một phần tử từ mảng con `[trái, phải]` có xác suất ít nhất là 0.5 để chọn phần tử đa số. Bằng cách lặp lại việc lấy mẫu này 20 lần, xác suất thất bại trở nên không đáng kể ($2^{-20}$). Đối với mỗi ứng cử viên được chọn, hãy xác minh tần suất của nó trong phạm vi bằng cách sử dụng tìm kiếm nhị phân (cụ thể là `giới hạn trên - giới hạn dưới` trên danh sách chỉ số được tính toán trước cho giá trị đó). Điều này cung cấp một giải pháp nhanh chóng và hiệu quả.

---
