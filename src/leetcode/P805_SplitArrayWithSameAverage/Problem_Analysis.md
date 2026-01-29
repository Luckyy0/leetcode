# 805. Split Array With Same Average / Chia mảng với cùng Giá trị Trung bình

## Problem Description / Mô tả bài toán
You are given an integer array `nums`. You should move each element of `nums` into one of the two arrays `A` and `B` such that `nums` is partitioned into `A` and `B`, and `average(A) == average(B)`.
Bạn được cho một mảng số nguyên `nums`. Bạn nên di chuyển từng phần tử của `nums` vào một trong hai mảng `A` và `B` sao cho `nums` được chia thành `A` và `B`, và `average(A) == average(B)`.

Return `true` if it is possible, or `false` otherwise.
Trả về `true` nếu có thể, ngược lại trả về `false`.

Note: The arrays `A` and `B` should be non-empty.
Lưu ý: Các mảng `A` và `B` phải không được rỗng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Property / Thuộc tính Toán học
Let `S` be the total sum of `nums`, and `N` be its length.
Gọi `S` là tổng quát của `nums`, và `N` là độ dài của nó.

If `average(A) == average(B)`, then `average(A) == average(nums)`.
`sum(A) / len(A) = S / N` => `sum(A) = S * len(A) / N`.

Since `sum(A)` must be an integer, `S * len(A)` must be divisible by `N`.
This restricts the possible values of `len(A)` to `[1, N/2]`.

### Knapsack / Meet-in-the-Middle / Knapsack / Giao ở giữa
This is a subset-sum variation. We need to find if there exists a subset of size `k` with sum `S*k/N`.
Đây là một biến thể của bài toán tổng tập hợp con (subset-sum). Chúng ta cần tìm xem có tồn tại một tập hợp con kích thước `k` với tổng `S*k/N` hay không.

Algorithm:
1. Prune: only check `k` such that `(S * k) % N == 0`.
2. Use bitmasks or `BitSet` to track possible sums for each subset size.
`dp[k]` = Set of all possible sums for subsets of size `k`.
`dp[k] = dp[k] | (dp[k-1] << nums[i])`

### Complexity / Độ phức tạp
- **Time**: O(N * S).
- **Space**: O(N * S).

---

## Analysis / Phân tích

### Approach: Subset Sum DP
By limiting the search to valid lengths based on the average constraint, we can use dynamic programming to determine if any achievable subset sum matches the target value.
Bằng cách giới hạn tìm kiếm ở các độ dài hợp lệ dựa trên ràng buộc giá trị trung bình, chúng ta có thể sử dụng quy hoạch động để xác định xem liệu có bất kỳ tổng tập hợp con nào khả thi khớp với giá trị mục tiêu hay không.

---
