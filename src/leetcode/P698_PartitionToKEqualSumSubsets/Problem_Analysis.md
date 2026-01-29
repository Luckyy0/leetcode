# 698. Partition to K Equal Sum Subsets / Phân chia thành K Tập hợp con có Tổng Bằng nhau

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return `true` if it is possible to divide this array into `k` non-empty subsets whose sums are all equal.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về `true` nếu có thể chia mảng này thành `k` tập hợp con không rỗng có tổng đều bằng nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Pruning / Quay lui với Cắt tỉa
This is an NP-hard problem. We use recursion with several optimizations.
Đây là một bài toán NP-khó. Chúng ta sử dụng đệ quy với một số tối ưu hóa.

Pre-requisites:
- Total sum must be divisible by `k`. Target = `totalSum / k`.
- All `nums[i] <= Target`.

Optimizations:
1. Sort `nums` in descending order. Filling larger numbers first helps prune failed branches faster.
2. If we fail to put `nums[i]` into an empty bucket, we don't need to try other empty buckets (as they are identical).
3. Record visited states? (More complex: use bitmask DP if constraints allow).

### Complexity / Độ phức tạp
- **Time**: O(K * 2^N) in the worst case, but significantly reduced by pruning.
- **Space**: O(N) recursion depth.

---

## Analysis / Phân tích

### Approach: Bucket-filling Backtracking
Try to place each number into one of the `K` buckets. If a bucket's sum exceeds `Target`, move to the next. If all numbers are placed successfully, return `true`.
Hãy thử đặt từng số vào một trong `K` thùng chứa. Nếu tổng của một thùng vượt quá `Target`, hãy chuyển sang thùng tiếp theo. Nếu tất cả các số được đặt thành công, hãy trả về `true`.

---
