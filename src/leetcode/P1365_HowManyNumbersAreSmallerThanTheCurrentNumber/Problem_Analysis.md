# 1365. How Many Numbers Are Smaller Than the Current Number / Có Bao Nhiêu Số Nhỏ Hơn Số Hiện Tại

## Problem Description / Mô tả bài toán
Array `nums`.
For each `nums[i]`, count `j` such that `nums[j] < nums[i]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / Bucket Sort
1. Clone and Sort. Map value first index.
2. Counting Sort (since range 0-100).
   `count[val]` stores frequency.
   Prefix sum `pref[val]` stores count of nums < val.

### Complexity / Độ phức tạp
- **Time**: O(N) (Counting Sort) or O(N log N).
- **Space**: O(N) or O(101).

---

## Analysis / Phân tích

### Approach: Counting Sort
Since constraints say `0 <= nums[i] <= 100`.
Use frequency array `cnt` of size 101.
Compute prefix sums.
`ans[i] = prefix[nums[i]-1]`. (Sum of counts of all numbers strictly smaller).
If `nums[i] == 0`, answer 0.
Vì ràng buộc `0 <= nums[i] <= 100`.
Sử dụng mảng tần suất `cnt` kích thước 101.
Tính tổng tiền tố.
`ans[i] = prefix[nums[i]-1]`. (Tổng số lượng của tất cả các số nhỏ hơn hoàn toàn).
Nếu `nums[i] == 0`, trả lời 0.

---
