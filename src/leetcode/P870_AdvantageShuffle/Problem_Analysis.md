# 870. Advantage Shuffle / Xáo trộn Ưu thế

## Problem Description / Mô tả bài toán
You are given two integer arrays `nums1` and `nums2` of the same length `n`. The **advantage** of `nums1` with respect to `nums2` is the number of indices `i` such that `nums1[i] > nums2[i]`.
Bạn được cấp hai mảng số nguyên `nums1` và `nums2` có cùng độ dài `n`. **Ưu thế** của `nums1` đối với `nums2` là số lượng chỉ số `i` sao cho `nums1[i] > nums2[i]`.

Return any permutation of `nums1` that maximizes its advantage with respect to `nums2`.
Trả về bất kỳ hoán vị nào của `nums1` giúp tối đa hóa ưu thế của nó đối với `nums2`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach (Tian Ji's Horse Racing Strategy) / Chiến lược Tham lam (Đua ngựa Điền Kỵ)
To maximize wins:
1. Try to beat the smallest `nums2[i]` with the smallest possible `nums1[j]` that is larger.
2. If `nums1[j]` cannot beat even the smallest `nums2[i]`, "waste" that bad `nums1[j]` against the strongest `nums2[k]`.

Algorithm:
1. Sort `nums1`.
2. Pair `nums2` with original indices and sort it.
3. Use two pointers on `nums2` (left and right).
4. For each element in `nums1`:
   - If it can beat `nums2[left]`, assign it to `left` index.
   - Else, assign it to `right` index (sacrificing it against the largest value).

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) for storing results.

---

## Analysis / Phân tích

### Approach: Strategic Assignment
Process `nums1` in sorted order. If a value can provide a point, use it. Otherwise, use it to absorb a loss against the most difficult target in `nums2`, preserving better values for easier matches.
Xử lý `nums1` theo thứ tự đã sắp xếp. Nếu một giá trị có thể mang lại một điểm, hãy sử dụng nó. Nếu không, hãy sử dụng nó để chấp nhận một trận thua trước mục tiêu khó nhất trong `nums2`, nhằm bảo toàn các giá trị tốt hơn cho các trận đấu dễ dàng hơn.

---
