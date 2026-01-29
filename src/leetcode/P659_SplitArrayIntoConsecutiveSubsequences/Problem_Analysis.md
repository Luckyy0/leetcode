# 659. Split Array into Consecutive Subsequences / Chia Mảng thành các Dãy con Liên tiếp

## Problem Description / Mô tả bài toán
You are given an integer array `nums` that is sorted in non-decreasing order.
Bạn được cho một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm.

Determine if it is possible to split `nums` into one or more subsequences such that each subsequence consists of consecutive integers and has a length of at least 3.
Xác định xem có thể chia `nums` thành một hoặc nhiều dãy con sao cho mỗi dãy con bao gồm các số nguyên liên tiếp và có độ dài ít nhất là 3.

Return `true` if you can split `nums` according to the above conditions, or `false` otherwise.
Trả về `true` nếu bạn có thể chia `nums` theo các điều kiện trên, ngược lại trả về `false`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach / Tiếp cận Tham lam
We use two HashMaps: one to store the frequency of each number (`countMap`) and another to store the number of subsequences ending at a particular number (`endMap`).
Chúng ta sử dụng hai HashMap: một cái để lưu tần suất của mỗi số (`countMap`) và một cái khác để lưu số lượng dãy con kết thúc tại một số cụ thể (`endMap`).

For each number `x` in `nums`:
1. If `x` has no more occurrences, skip it.
2. If there is a subsequence ending at `x-1`, we can append `x` to it. Update `endMap`.
3. Otherwise, try to start a new subsequence of length 3: `x, x+1, x+2`. Check availability in `countMap`.
4. If neither is possible, return `false`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `nums`.
- **Space**: O(N) to store frequencies and subsequence ends.

---

## Analysis / Phân tích

### Approach: Greedy with Frequency and End Tracking
The greedy choice is to always try to append the current number to an existing subsequence first, because it's harder to start a new subsequence of length 3 later.
Lựa chọn tham lam là luôn cố gắng thêm số hiện tại vào một dãy con hiện có trước, vì sau này sẽ khó hơn để bắt đầu một dãy con mới có độ dài 3.

---
