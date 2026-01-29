# 689. Maximum Sum of 3 Non-Overlapping Subarrays / Tổng Cực đại của 3 Mảng con không Chồng lấn

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, find three non-overlapping subarrays of length `k` with maximum sum and return their starting indices as a list.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy tìm ba mảng con không chồng lấn có độ dài `k` với tổng cực đại và trả về các chỉ số bắt đầu của chúng dưới dạng một danh sách.

If there are multiple answers, return the lexicographically smallest one.
Nếu có nhiều câu trả lời, hãy trả về câu trả lời nhỏ nhất theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Sliding Window / Quy hoạch Động với Cửa sổ Trượt
Calculated the sum of every possible subarray of length `k`. Let this be `sum[i]`.
Tính tổng của mọi mảng con có thể có độ dài `k`. Gọi đây là `sum[i]`.

We need to pick indices `i, j, l` such that `sum[i] + sum[j] + sum[l]` is maximized and `i + k <= j` and `j + k <= l`.
Chúng ta cần chọn các chỉ số `i, j, l` sao cho `sum[i] + sum[j] + sum[l]` được tối đa hóa.

To simplify:
1. Precompute `left[i]`: The index of the maximum subarray of length `k` in the range `[0, i]`.
2. Precompute `right[j]`: The index of the maximum subarray of length `k` in the range `[j, n-1]`.
3. Iterate through all possible middle subarray indices `j` (from `k` to `n - 2k`) and calculate the total sum: `sum[left[j-k]] + sum[j] + sum[right[j+k]]`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `nums`.
- **Space**: O(N) to store sums and best indices.

---

## Analysis / Phân tích

### Approach: Precomputed Extremes
By knowing the best subarray to the left and right of every possible middle choice, we reduce the search space to a linear scan of the middle index.
Bằng cách biết mảng con tốt nhất ở bên trái và bên phải của mỗi lựa chọn ở giữa, chúng ta giảm không gian tìm kiếm xuống một lượt quét tuyến tính của chỉ số ở giữa.

---
